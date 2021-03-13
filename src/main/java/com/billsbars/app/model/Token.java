package com.billsbars.app.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Token {

	@Id
	public String Id;
	private String userName;
	private String role;
	private String token;
	private Date expires;

}
