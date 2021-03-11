package com.billsbars.app.service;

import java.util.List;

import com.billsbars.app.model.BarOfSoap;

public interface BarOfSoapService {
	
	boolean createSoap(BarOfSoap soap);
	
	boolean deleteSoap(BarOfSoap soap);
	
	BarOfSoap editSoap(BarOfSoap soap);
	
	List<BarOfSoap> getAllSoaps();
	
	BarOfSoap getOneSoap(String soapId);
	

}
