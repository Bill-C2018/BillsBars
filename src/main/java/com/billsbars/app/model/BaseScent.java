package com.billsbars.app.model;

import lombok.Data;

@Data
public class BaseScent {
	
	String name;
	int drops;
	
	BaseScent() {}
	BaseScent(String name, int drops) {
		this.name = name;
		this.drops = drops;
				
	}
	

}
