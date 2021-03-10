package com.billsbars.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billsbars.app.dao.InventoryRepository;
import com.billsbars.app.dao.SoapBarsRepository;
import com.billsbars.app.model.BarOfSoap;
import com.billsbars.app.model.Inventory;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BarOfSoap getOneSoap(String soapId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private BarOfSoap checkInventory(BarOfSoap soap) {

		List<BarOfSoap> soaps = soapBarRepository.findByBarTypeAndBaseType(
				soap.getBarType().toString(), soap.getBaseType().toString());
		
		for (BarOfSoap s:  soaps) {
			if (s.getScent().getName().equalsIgnoreCase(soaps.get(0).getScent().getName())) {
				return s;
			}
					
		}
		
		return null;
		
	}
	
	private void addNewBar(BarOfSoap soap) {
		//create the soap entry
		soapBarRepository.save(soap);
		//now get it to get the id 
		BarOfSoap soaps = this.checkInventory(soap);
		if(soaps != null) {
			Inventory inv = new Inventory(soaps.getId(),1);
			inventoryRepository.save(inv);
		}
	}
	
	private void updateBarCount(BarOfSoap soap, boolean add) {
		
		Optional<Inventory> inv = inventoryRepository.findByBarOfSoapId(soap.getId());
		if (inv.isPresent()) {
			Inventory i = inv.get();
			i.setCount(i.getCount() + (add ? 1:-1));
			inventoryRepository.save(i);
			if(i.getCount() == 0) {
				inventoryRepository.deleteById(i.getId());
				soapBarRepository.deleteById(soap.getId());
			}
		}
	}

}
