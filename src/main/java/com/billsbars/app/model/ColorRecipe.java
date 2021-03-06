package com.billsbars.app.model;

import java.util.ArrayList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class ColorRecipe {
	
	@Id
	public String id;
	private ArrayList<SimpleColor> colors = new ArrayList<SimpleColor>();
	@NotBlank
	private String finalColor;
	
	public ColorRecipe() {}
	
	public ColorRecipe(ArrayList<SimpleColor> colors, String finalColor) {
		this.colors = colors;
		this.finalColor = finalColor;
	}
	
	

}
