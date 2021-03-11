package com.billsbars.app.model;

import org.springframework.data.annotation.Id;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class BarOfSoap {
	

	@Id
	public String id;
	@NotNull
	private BarTypes barType;
	@NotNull
	private BaseTypes baseType;
	@NotNull
	private ColorRecipe color;
	@NotNull
	private ScentRecipe scent;
	@NotNull
	private int count;
	@NotNull
	private MoldStyle moldStyle;
	private boolean isOrganic = false;
	
	public BarOfSoap() { }
	
	public BarOfSoap(BarTypes type, BaseTypes baseType, ColorRecipe color,
					ScentRecipe scent,MoldStyle moldStyle,boolean organic) {
		
		this.barType = type;
		this.baseType = baseType;
		this.color = color;
		this.scent = scent;
		this.isOrganic = organic; 
		this.moldStyle = moldStyle;
		
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
