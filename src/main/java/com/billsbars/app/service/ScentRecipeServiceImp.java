package com.billsbars.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.billsbars.app.model.SimpleScent;

@Service("ScentRecipeService")
public class ScentRecipeServiceImp implements ScentRecipeService {

	Logger logger = LoggerFactory.getLogger(ScentRecipeServiceImp.class);
			
	@Override
	public boolean createScent(SimpleScent scent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteScent(String scentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SimpleScent editScent(SimpleScent scent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SimpleScent> getAllScents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleScent getOneScent(String scentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
