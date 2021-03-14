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
	ArrayList<ColorRecipe> colorRecipes;
	List<FieldErrorMessage> fieldErrors;

}
