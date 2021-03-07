package com.billsbars.app.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class SimpleScent {
	
	String name;
	ArrayList<SingleScent> baseScents;

	public SimpleScent() {}
	public SimpleScent(String name, ArrayList<SingleScent> baseScents) {
		this.name = name;
		this.baseScents = baseScents;
	}
}
