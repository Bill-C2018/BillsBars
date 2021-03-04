package com.billsbars.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.billsbars.model.BarOfSoap;
import com.billsbars.model.ResponseModel;
import com.billsbars.model.Scent;

@RestController
public class SoapBarController {
	
	Logger logger = LoggerFactory.getLogger(SoapBarController.class);
	
	@PostMapping(value = "/soaps")
	ResponseEntity<ResponseModel> createASoap(
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody BarOfSoap soap) {
		
		ResponseModel resp = new ResponseModel();
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}
	
	@PutMapping(value = "/soaps")
	ResponseEntity<ResponseModel> edotASoap(
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody BarOfSoap soap) {
		
		ResponseModel resp = new ResponseModel();
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}
	
	@DeleteMapping(value = "/soaps")
	ResponseEntity<ResponseModel> deleteASoap(
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody BarOfSoap soap) {
		
		ResponseModel resp = new ResponseModel();
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}
	
	@GetMapping(value = "/soaps")
	ResponseEntity<ResponseModel> getAllSoap(
			@RequestHeader(value = "access-token", required = true) String r) {
		
		ResponseModel resp = new ResponseModel();
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}

	@GetMapping(value = "/soaps/{soapId}")
	ResponseEntity<ResponseModel> getOneSoap(
			@RequestHeader(value = "access-token", required = true) String r) {
		
		ResponseModel resp = new ResponseModel();
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}
	
}