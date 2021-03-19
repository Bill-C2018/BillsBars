package com.billsbars.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billsbars.app.DuplicateRecordException;
import com.billsbars.app.dao.ScentRecipesRepository;
import com.billsbars.app.model.ScentRecipe;

@Service("ScentRecipeService")
public class ScentRecipeServiceImp implements ScentRecipeService {

	Logger logger = LoggerFactory.getLogger(ScentRecipeServiceImp.class);
			
	@Autowired
	private ScentRecipesRepository scentRecipesRepository;
	
	@Override
	public boolean createScent(ScentRecipe scent) {
		List<ScentRecipe> exists = scentRecipesRepository.findByName(scent.getName());
		if (exists != null && exists.size() > 0) {
			throw new DuplicateRecordException("Scent already exists " + scent.getName());
		}
		scentRecipesRepository.save(scent);
		return true;
	}

	@Override
	public boolean deleteScent(String scentName) {
		List<ScentRecipe> exists = scentRecipesRepository.findByName(scentName);
		if (exists != null && exists.size() > 0) {
			scentRecipesRepository.deleteById(exists.get(0).getId());
			return true;
		}
		return false;
	}

	@Override
	public ScentRecipe editScent(ScentRecipe scent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScentRecipe> getAllScents() {
		return scentRecipesRepository.findAll();
	}

	@Override
	public List<ScentRecipe> getOneScent(String scentName) {
		// TODO Auto-generated method stub
		return scentRecipesRepository.findByName(scentName);
	}

}
