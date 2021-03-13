package com.billsbars.app.model;

import java.util.Date;
import java.util.Random;

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
	
	public Token() {}
	public void createTokenString(CustomerModel customer) {
		
		Random rand = new Random();
		String tok = customer.getUserName() + customer.getUserRole()
			+ String.valueOf(rand.nextInt(10000));
		
		this.token = String.valueOf(tok.hashCode());
		this.role = customer.getUserRole();
		this.userName = customer.getUserName();
		this.expires = new Date();
	}

}
