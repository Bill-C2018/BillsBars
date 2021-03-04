package com.billsbars.app.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Scent {
	
	String name;
	ArrayList<BaseScent> baseScents;

	public Scent() {}
}
