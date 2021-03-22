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

import com.billsbars.app.AccessDeniedException;
import com.billsbars.app.model.CustomerModel;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.service.CustomerService;
import com.billsbars.app.service.UserAuthenticationService;


@RestController
public class CustomerController {
	
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private UserAuthenticationService userAuthenticationService;

	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/customer")
	ResponseEntity<ResponseModel> createCustomer(
			@RequestHeader(value = "access-token", required = true) String r,
			@Valid @RequestBody CustomerModel customer) {
		
		ResponseModel resp = new ResponseModel();
		
		CustomerModel user = customerService.createCustomer(customer);
		if( user == null ) {
			resp.setCode(HttpStatus.BAD_REQUEST.value());
			resp.setMessage("Failed to create user");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		}
		resp.setCode(200);
		resp.setMessage("User Created");
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
		
		if (!userAuthenticationService.isUserAdminOrSelf(r,customer.getUserName())) {
			throw new AccessDeniedException("access denied");
		}

		if (customerService.deleteCustomer(customer) == true) {
			resp.setMessage("Customer deleted");
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}
		
		
		resp.setMessage("Not Deleted");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);

	}
	
	@GetMapping(value = "/customer/{username}")
	ResponseEntity<ResponseModel> getOneCustomer(
			@RequestHeader(value = "access-token", required = true) String r,
			@PathVariable String userName) {
		
		ResponseModel resp = new ResponseModel();	
		
		
		resp.setMessage("Not Implemented");
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}




}
