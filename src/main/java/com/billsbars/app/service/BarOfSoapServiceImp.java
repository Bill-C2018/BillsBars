package com.billsbars.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billsbars.app.model.BarOfSoap;

@Service("BarOfSoapService")
public class BarOfSoapServiceImp implements BarOfSoapService {

	@Override
	public boolean createSoap(BarOfSoap soap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSoap(String soapId) {
		// TODO Auto-generated method stub
		return false;
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

}
