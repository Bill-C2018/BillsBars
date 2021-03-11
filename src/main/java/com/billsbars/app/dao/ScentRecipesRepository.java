package com.billsbars.app.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.billsbars.app.model.ScentRecipe;

public interface ScentRecipesRepository extends MongoRepository<ScentRecipe, String> {

	List<ScentRecipe> findByName(String name);
}
