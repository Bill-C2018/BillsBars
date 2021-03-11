package com.billsbars.app.model;

import java.util.ArrayList;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class ScentRecipe {
	
	@Id
	public String id;
	@NotBlank(message="Scent name can not be empty")
	String name;
	@NotNull
	ArrayList<SingleScent> baseScents;

	public ScentRecipe() {}
	public ScentRecipe(String name, ArrayList<SingleScent> baseScents) {
		this.name = name;
		this.baseScents = baseScents;
	}
}
