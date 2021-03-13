package com.billsbars.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.billsbars.app.model.CustomerModel;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.model.Token;
import com.billsbars.app.service.CustomerService;
import com.billsbars.app.service.TokenRepositoryService;

@RestController
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TokenRepositoryService tokenRepositoryService;

	
	@PostMapping(value = "/login")
	ResponseEntity<ResponseModel> login(
			@Valid @RequestBody CustomerModel customer) {
		
		ResponseModel resp = new ResponseModel();
		
		CustomerModel validLogin = customerService.checkCustomerLogin(customer.getUserName(),customer.getUserPword());
		if(validLogin != null) {
			Token t = new Token();
			t.createTokenString(validLogin);
			tokenRepositoryService.createRecord(t);
			resp.setToken(t.getToken());
			resp.setMessage("Logged in");
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}
		
		resp.setMessage("Not Found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);		
	}

}
