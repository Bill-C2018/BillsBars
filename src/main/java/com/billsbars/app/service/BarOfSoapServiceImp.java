package com.billsbars.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.billsbars.app.dao.InventoryRepository;
import com.billsbars.app.dao.SoapBarsRepository;
import com.billsbars.app.model.BarOfSoap;
import com.billsbars.app.model.BarTypes;
import com.billsbars.app.model.Inventory;
import com.billsbars.app.model.UpdateSoapBars;

import java.util.Optional;

@Service("BarOfSoapService")
public class BarOfSoapServiceImp implements BarOfSoapService {

	Logger logger = LoggerFactory.getLogger(ColorRecipesServiceImp.class);

	@Autowired
	private SoapBarsRepository soapBarRepository; 
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public boolean createSoap(BarOfSoap soap) {
		//weight is based on type
		if(soap.getBarType() == BarTypes.FULLBAR) {
			soap.setWeight(4);
		} else if (soap.getBarType() == BarTypes.DECORATIVEBAR) {
			soap.setWeight(3);
		} else if (soap.getBarType() == BarTypes.SMALLDECORATIVE) {
			soap.setWeight(2);
		}
		//if this soap exists we need to inc the inventory count
		//else start the inventory count
		BarOfSoap soaps = this.checkInventory(soap);
		if (soaps == null) {
			this.addNewBar(soap);
			return true;
		} else {
			this.updateBarCount(soaps,true);
			return true;
		}

	}

	@Override
	public boolean deleteSoap(BarOfSoap soap) {
		BarOfSoap soaps = this.checkInventory(soap);
		if (soaps == null) {
			return false;
		} else {
			this.updateBarCount(soaps,false);
			return true;
		}
	}

	@Override
	public BarOfSoap editSoap(BarOfSoap soap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BarOfSoap> getAllSoaps() {
		return soapBarRepository.findAll();
	}
	
	public Page<BarOfSoap> getAllSoapsPaged(Pageable pageable) {
		return soapBarRepository.findAll(pageable);
	}

	@Override
	public BarOfSoap getOneSoap(String soapId) {
		
		Optional<BarOfSoap> res = soapBarRepository.findById(soapId);
		if(res.isPresent()) {
			return res.get();
		}
		return null;
		
	}
	
	@Override
	public BarOfSoap getOneBarByName(String soapName) {
		
		return soapBarRepository.findBySoapName(soapName);
		
	}
	
	private BarOfSoap checkInventory(BarOfSoap soap) {

		BarOfSoap soaps = soapBarRepository.findBySoapNameAndBarTypeAndBaseTypeAndScent(
				soap.getSoapName(), soap.getBarType().toString(), soap.getBaseType().toString(),soap.getScent());
		
		
		return soaps;
		
	}
	
	private void addNewBar(BarOfSoap soap) {
		//create the soap entry
		soapBarRepository.save(soap);
		//now get it to get the id 
		BarOfSoap soaps = this.checkInventory(soap);
		if(soaps != null) {
			Inventory inv = new Inventory(soap.getSoapName(),soaps.getId(),soap.getCount());
			inventoryRepository.save(inv);
		}
	}
	
	private void updateBarCount(BarOfSoap soap, boolean add) {
		
		Optional<Inventory> inv = inventoryRepository.findByBarOfSoapId(soap.getId());
		if (inv.isPresent()) {
			Inventory i = inv.get();
			i.setCount(i.getCount() + (add ? soap.getCount():-1));
			inventoryRepository.save(i);
			// we want to keep the count in the soap table synched 
			//with the inventory count 
			if (soap.getCount() != i.getCount()) {
				soap.setCount(i.getCount());
				soapBarRepository.save(soap);
			}
			if(i.getCount() == 0) {
				inventoryRepository.deleteById(i.getId());
				soapBarRepository.deleteById(soap.getId());
			}
		}
	}
	
	public boolean updateSoapCounts(UpdateSoapBars soap) {
		
		boolean ret = false;
		BarOfSoap soapToUpdate = getOneSoap(soap.getBarId());
		if (soapToUpdate != null) {
			soapToUpdate.setCount(soap.getCount());
			updateBarCount(soapToUpdate,true);
			ret = true;
		}

		return ret;
		
	}

}
