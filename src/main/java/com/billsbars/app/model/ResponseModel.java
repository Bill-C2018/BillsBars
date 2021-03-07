package com.billsbars.app.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ResponseModel {
	
	private int code;
	private String message;
	
	ArrayList<ColorRecipe> colorRecipes;

}
