package com.billsbars.app.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billsbars.app.DuplicateRecordException;
import com.billsbars.app.dao.ColorRecipesRepository;
import com.billsbars.app.model.ColorRecipe;

@Service("ColorRecipesService")
public class ColorRecipesServiceImp implements ColorRecipesService {
	
	Logger logger = LoggerFactory.getLogger(ColorRecipesServiceImp.class);
	
	@Autowired
	private ColorRecipesRepository colorRecipesRepository;

	@Override
	public boolean createColor(ColorRecipe colorRecipe) {
		List<ColorRecipe> exists= colorRecipesRepository.findByFinalColor(colorRecipe.getFinalColor());
		if (exists.size() == 0) {
			colorRecipesRepository.save(colorRecipe);
			return true;
		} else {
			throw new DuplicateRecordException("color alread exists" + colorRecipe.getFinalColor());
		}

	}

	@Override
	public boolean deleteColor(ColorRecipe colorRecipe) {
		List<ColorRecipe> exists= colorRecipesRepository.findByFinalColor(colorRecipe.getFinalColor());
		if (exists.size() > 0) {
			String id = exists.get(0).getId();
			colorRecipesRepository.deleteById(id);
			return true;
		}
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
