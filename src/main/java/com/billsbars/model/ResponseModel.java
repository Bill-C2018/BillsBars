package com.billsbars.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ResponseModel {
	
	private int code;
	private String message;
	
	ArrayList<ColorRecipe> recipes;

}
