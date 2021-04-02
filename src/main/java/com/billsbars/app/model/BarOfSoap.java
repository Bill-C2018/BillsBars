package com.billsbars.app.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BarOfSoap {
	

	@Id
	public String id;
	@NotBlank
	private String soapName;
	private BarTypes barType;
	private BaseTypes baseType;
	@NotBlank
	private String color;
	@NotBlank
	private String scent;
	@NotNull
	private int count;
	private int weight;
	private MoldStyle moldStyle;
	private boolean isOrganic = false;
	
	public BarOfSoap() { }
	
	public BarOfSoap(String name,BarTypes type, BaseTypes baseType, String color,
					String scent,MoldStyle moldStyle,boolean organic) {
		
		this.soapName = name;
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
			&& this.scent.equals(o.scent)) {
			return true;
		}
		
		return false;
	}
	
	public int hashCode() {
		return this.scent.hashCode();
	}
	
	

}
