package com.billsbars.app.service;

import java.util.List;

import com.billsbars.app.model.ColorRecipe;

public interface ColorRecipesService {
	
	boolean createColor(ColorRecipe colorRecipe);
	
	boolean deleteColor(ColorRecipe colorRecipe);
	
	ColorRecipe editColor(ColorRecipe colorRecipe);
	
	List<ColorRecipe> getAllColors();
	
	List<ColorRecipe> getOneColor(String colorId);
	
	

}
