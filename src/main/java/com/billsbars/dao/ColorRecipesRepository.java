package com.billsbars.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.billsbars.model.ColorRecipe;


@Repository
public interface ColorRecipesRepository extends MongoRepository<ColorRecipe, String> {

}
