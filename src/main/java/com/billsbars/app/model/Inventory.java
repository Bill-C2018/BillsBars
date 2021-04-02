package com.billsbars.app.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Inventory {
	
	@Id
	public String id; 
	private String barOfSoapId;
	private String soapName;
	private int count;
	
	public Inventory() {}
	public Inventory(String soapName, String id, int count) {
		this.soapName = soapName;
		this.barOfSoapId = id;
		this.count = count;
	}
	

}
