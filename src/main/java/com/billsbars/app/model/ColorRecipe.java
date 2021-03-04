package com.billsbars.app.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ColorRecipe {
	
	private ArrayList<SimpleColor> colors = new ArrayList<SimpleColor>();
	private String finalColor;
	
	public ColorRecipe() {}
	
	public ColorRecipe(ArrayList<SimpleColor> colors, String finalColor) {
		this.colors = colors;
		this.finalColor = finalColor;
	}
	
	

}
