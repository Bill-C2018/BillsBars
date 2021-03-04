package com.billsbars.app.model;

import lombok.Data;

@Data
public class SimpleColor {
	
	private BaseColor color;
	private	int numberDrops;
	
	SimpleColor() {}
	SimpleColor(BaseColor color) {
		this.color = color;
	}
	
	{
		this.numberDrops = 0;
	}
	
}
