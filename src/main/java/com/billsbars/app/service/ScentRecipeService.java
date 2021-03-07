package com.billsbars.app.service;

import java.util.List;

import com.billsbars.app.model.SimpleScent;

public interface ScentRecipeService {
	
	boolean createScent(SimpleScent scent);
	
	boolean deleteScent(String scentId);
	
	SimpleScent editScent(SimpleScent scent);
	
	List<SimpleScent> getAllScents();
	
	SimpleScent getOneScent(String scentId);
		
		
	

}
