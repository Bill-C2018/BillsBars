package com.billsbars.service;

import java.util.List;

import com.billsbars.model.Scent;

public interface ScentRecipeService {
	
	boolean createScent(Scent scent);
	
	boolean deleteScent(String scentId);
	
	Scent editScent(Scent scent);
	
	List<Scent> getAllScents();
	
	Scent getOneScent(String scentId);
		
		
	

}
