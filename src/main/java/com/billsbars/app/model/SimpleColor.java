package com.billsbars.app.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SimpleColor {
	
	@NotBlank(message = "BaseColor can not be blank")
	private BaseColor color;
	@NotBlank(message = "Number of drops can not be blank")
	private	int numberDrops;
	
	public SimpleColor() {}
	
	public SimpleColor(BaseColor color,int numberDrops) {
		this.color = color;
		this.numberDrops = numberDrops;
	}
	

	
}
