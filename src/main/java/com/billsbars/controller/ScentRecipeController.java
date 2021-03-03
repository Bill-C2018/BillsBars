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

import com.billsbars.model.ResponseModel;
import com.billsbars.model.Scent;

@RestController
public class ScentRecipeController {
	
	Logger logger = LoggerFactory.getLogger(ScentRecipeController.class);
			
	@PostMapping(value ="scentrecipe")
	ResponseEntity<ResponseModel> createScent(
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody Scent scent) {
		
		ResponseModel resp = new ResponseModel();
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}
	
	@PutMapping(value = "scentrecipe")
	ResponseEntity<ResponseModel> editScent(
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody Scent scent) {
		
		ResponseModel resp = new ResponseModel();
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}	

	
	@DeleteMapping(value = "scentrecipe/{scentId}")
	ResponseEntity<ResponseModel> deleteScent(
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody Scent scent) {
		
		ResponseModel resp = new ResponseModel();
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}	
	
	@GetMapping(value = "scentrecipe/{scentId}")
	ResponseEntity<ResponseModel> getOneScent(
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody Scent scent) {
		
		ResponseModel resp = new ResponseModel();
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}	

	@GetMapping(value = "scentrecipe")
	ResponseEntity<ResponseModel> getAllScents(
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody Scent scent) {
		
		ResponseModel resp = new ResponseModel();
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}	


}
