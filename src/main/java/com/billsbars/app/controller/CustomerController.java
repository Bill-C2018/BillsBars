package com.billsbars.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.billsbars.app.model.CustomerModel;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.service.CustomerService;


@RestController
public class CustomerController {
	
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/customer")
	ResponseEntity<ResponseModel> createCustomer(
			@RequestHeader(value = "access-token", required = true) String r,
			@Valid @RequestBody CustomerModel customer) {
		
		ResponseModel resp = new ResponseModel();	
		
		
		resp.setMessage("Not Implemented");
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}
	
	@PutMapping(value = "/customer")
	ResponseEntity<ResponseModel> editCustomer(
			@RequestHeader(value = "access-token", required = true) String r,
			@Valid @RequestBody CustomerModel customer) {
		
		ResponseModel resp = new ResponseModel();	
		
		
		resp.setMessage("Not Implemented");
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}
	
	@DeleteMapping(value = "/customer")
	ResponseEntity<ResponseModel> deleteCustomer(
			@RequestHeader(value = "access-token", required = true) String r,
			@Valid @RequestBody CustomerModel customer) {
		
		ResponseModel resp = new ResponseModel();	
		
		
		resp.setMessage("Not Implemented");
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}
	
	@GetMapping(value = "/customer/{username}")
	ResponseEntity<ResponseModel> getOneCustomer(
			@RequestHeader(value = "access-token", required = true) String r,
			@PathVariable String userName) {
		
		ResponseModel resp = new ResponseModel();	
		
		
		resp.setMessage("Not Implemented");
		return ResponseEntity.status(HttpStatus.OK).body(resp);




}
