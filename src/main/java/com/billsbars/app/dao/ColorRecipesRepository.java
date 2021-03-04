package com.billsbars.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.billsbars.app.model.ColorRecipe;


@Repository
public interface ColorRecipesRepository extends MongoRepository<ColorRecipe, String> {

}
