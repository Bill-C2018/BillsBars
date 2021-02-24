package com.billsbars.model;

import lombok.Data;

@Data
public class BarOfSoap {
	

	private BarTypes barType;
	private BaseTypes baseType;
	private ColorRecipe color;
	private boolean isOrganic = false;
	
	BarOfSoap() { }
	
	BarOfSoap(BarTypes type, BaseTypes baseType, ColorRecipe color,
					boolean organic) {
		
		this.barType = type;
		this.baseType = baseType;
		this.color = color;
		this.isOrganic = organic; 
	}
	

	public boolean equals(BarOfSoap o) {
		
		if (this == o) { return true; }
		if (o == null) { return false; }
		
		if ( this.barType == o.barType 
			&& this.baseType == o.baseType
			&& this.color.getFinalColor().equals(o.color.getFinalColor())) {
			return true;
		}
		
		return false;
	}
	
	public int hashCode() {
		return this.color.getFinalColor().hashCode();
	}
	
	

}
