package com.billsbars.app.service;

import java.util.List;

import com.billsbars.app.model.ScentRecipe;

public interface ScentRecipeService {
	
	boolean createScent(ScentRecipe scent);
	
	boolean deleteScent(String scentName);
	
	ScentRecipe editScent(ScentRecipe scent);
	
	List<ScentRecipe> getAllScents();
	
	List<ScentRecipe> getOneScent(String scentName);
		
		
	

}
