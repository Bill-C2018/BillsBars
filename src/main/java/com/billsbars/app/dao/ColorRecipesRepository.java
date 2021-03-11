package com.billsbars.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.billsbars.app.model.ColorRecipe;


@Repository
public interface ColorRecipesRepository extends MongoRepository<ColorRecipe, String> {

	List<ColorRecipe> findByFinalColor(String finalColor);
	Optional<ColorRecipe> findById(String id);
	
}
