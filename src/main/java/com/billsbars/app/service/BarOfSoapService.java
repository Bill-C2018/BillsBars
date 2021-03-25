package com.billsbars.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.billsbars.app.model.BarOfSoap;
import com.billsbars.app.model.UpdateSoapBars;

public interface BarOfSoapService {
	
	boolean createSoap(BarOfSoap soap);
	
	boolean deleteSoap(BarOfSoap soap);
	
	BarOfSoap editSoap(BarOfSoap soap);
	
	List<BarOfSoap> getAllSoaps();
	
	public Page<BarOfSoap> getAllSoapsPaged(Pageable pageable);
	
	BarOfSoap getOneSoap(String soapId);
	
	BarOfSoap getOneBarByName(String soapName);
	
	boolean updateSoapCounts(UpdateSoapBars soap);
	

}
