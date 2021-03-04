package com.billsbars.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.billsbars.model.ColorRecipe;

@Service
public class ColorRecipesServiceImp implements ColorRecipesService {
	
	Logger logger = LoggerFactory.getLogger(ColorRecipesServiceImp.class);

	@Override
	public boolean createColor(ColorRecipe colorRecipe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteColor(ColorRecipe colorRecipe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ColorRecipe editColor(ColorRecipe colorRecipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ColorRecipe> getAllColors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColorRecipe getOneColor(String colorId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
