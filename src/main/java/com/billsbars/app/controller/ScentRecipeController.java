package com.billsbars.app.controller;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.billsbars.app.AccessDeniedException;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.model.ScentRecipe;
import com.billsbars.app.service.ScentRecipeService;
import com.billsbars.app.service.UserAuthenticationService;

@RestController
public class ScentRecipeController {
	
	Logger logger = LoggerFactory.getLogger(ScentRecipeController.class);
	
	@Autowired
	private ScentRecipeService scentRecipeService;
	
	@Autowired
	private UserAuthenticationService userAuthenticationService;


	@PostMapping(value ="scentrecipe")
	ResponseEntity<ResponseModel> createScent(
			@RequestHeader(value = "access-token", required = true) String r,
			@Valid @RequestBody ScentRecipe scent) {
		
		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}

		if(scent != null) {
			scentRecipeService.createScent(scent);
			resp.setMessage("Scent created");
			resp.setCode(200);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		} else {
			throw new ValidationException("Scent recipe invalid or null");
		}

		
	
	}
	
	@PutMapping(value = "scentrecipe")
	ResponseEntity<ResponseModel> editScent(
			@RequestHeader(value = "access-token", required = true) String r,
			@Valid @RequestBody ScentRecipe scent) {
		
		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}
		


		resp.setMessage("Not Implemented");
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}	

	
	@DeleteMapping(value = "scentrecipe")
	ResponseEntity<ResponseModel> deleteScent(
			@RequestHeader(value = "access-token", required = true) String r,
			@Valid @RequestBody ScentRecipe scent) {
		
		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}

		boolean res = scentRecipeService.deleteScent(scent.getName());
		
		resp.setMessage("Not Implemented");
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}	
	
	@GetMapping(value = "scentrecipe/{scentId}")
	ResponseEntity<ResponseModel> getOneScent(
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody ScentRecipe scent) {
		
		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}

		resp.setMessage("Not Implemented");
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}	

	@GetMapping(value = "scentrecipe")
	ResponseEntity<ResponseModel> getAllScents(
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody ScentRecipe scent) {
		
		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}

		resp.setMessage("Not Implemented");
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	
	}	


}
