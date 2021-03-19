package com.billsbars.app.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ResponseModel {
	
	private int code;
	private String message;
	private String token;
	private String role;
	
	ArrayList<BarTypes> barTypes;
	ArrayList<MoldStyle> moldStyles;
	ArrayList<BaseColor> baseColors;
	ArrayList<BaseScents> baseScents;
	ArrayList<BaseTypes> baseTypes;
	ArrayList<ColorRecipe> colorRecipes;
	ArrayList<ScentRecipe> scentRecipes;
	List<FieldErrorMessage> fieldErrors;
	String[] scentRecipeNames;
	String[] colorRecipeNames;
	
	public void addScentRecipesAsList(List<ScentRecipe> l) {
		this.scentRecipes = new ArrayList<ScentRecipe>();
		this.scentRecipes.addAll(l);
	}
	
	public void addColorRecipesAsList(List<ColorRecipe> l) {
		this.colorRecipes = new ArrayList<ColorRecipe>();
		this.colorRecipes.addAll(l);
	}

}
