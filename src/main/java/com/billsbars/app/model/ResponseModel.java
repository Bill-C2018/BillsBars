package com.billsbars.app.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ResponseModel {
	
	private String code;
	private String message;
	private String token;
	private String role;
	
	private ArrayList<BarTypes> barTypes;
	private ArrayList<MoldStyle> moldStyles;
	private ArrayList<BaseColor> baseColors;
	private ArrayList<BaseScents> baseScents;
	private ArrayList<BaseTypes> baseTypes;
	private ArrayList<ColorRecipe> colorRecipes;
	private ArrayList<ScentRecipe> scentRecipes;
	private List<FieldErrorMessage> fieldErrors;
	ArrayList<BarOfSoap> listOfSoaps;
	private String[] scentRecipeNames;
	private String[] colorRecipeNames;
	private String currentPage;
	private String totalItems;
	private String totalPages;
	
	{
		this.code = "777";
		this.message = "forgot to set code and message in body";
	}
	
	public void addScentRecipesAsList(List<ScentRecipe> l) {
		this.scentRecipes = new ArrayList<ScentRecipe>();
		this.scentRecipes.addAll(l);
	}
	
	public void addColorRecipesAsList(List<ColorRecipe> l) {
		this.colorRecipes = new ArrayList<ColorRecipe>();
		this.colorRecipes.addAll(l);
	}
	
	public void setCode(int val) {
		this.code = Integer.toString(val);
	}
	
	public void setCode(String val) {
		this.code = val;
	}

}
