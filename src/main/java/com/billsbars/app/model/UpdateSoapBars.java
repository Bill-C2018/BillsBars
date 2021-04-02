package com.billsbars.app.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateSoapBars {
	
	@NotBlank
	private String barId;
	@NotBlank
	private String soapName;
	@NotNull
	private int count;

}
