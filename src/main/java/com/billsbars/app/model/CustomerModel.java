package com.billsbars.app.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class CustomerModel {

	@Id
	public String id;
	@NotBlank
	private String emailAddy;
	@NotBlank
	private String userName;
	@NotBlank
	private String userPword;
	private String userRole;
	
	{
		this.userRole = "USER";
	}
	
	public CustomerModel() {} 
	
	public CustomerModel(String emailAddy,String userName,String userPword) {
		this.emailAddy = emailAddy;
		this.userName = userName;
		this.userPword = userPword;
	}

}
