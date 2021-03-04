package com.billsbars.service;

import java.util.List;

import com.billsbars.model.ColorRecipe;

public interface ColorRecipesService {
	
	boolean createColor(ColorRecipe colorRecipe);
	
	boolean deleteColor(ColorRecipe colorRecipe);
	
	ColorRecipe editColor(ColorRecipe colorRecipe);
	
	List<ColorRecipe> getAllColors();
	
	ColorRecipe getOneColor(String colorId);
	
	

}
