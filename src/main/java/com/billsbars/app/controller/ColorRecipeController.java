package com.billsbars.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.billsbars.app.AccessDeniedException;
import com.billsbars.app.model.ColorRecipe;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.service.UserAuthenticationService;


@RestController
public class ColorRecipeController {
	
	Logger logger = LoggerFactory.getLogger(ColorRecipeController.class);

	@Autowired
	private UserAuthenticationService userAuthenticationService;
	
	
	@PostMapping(value = "/colorrecipe")
	ResponseEntity<ResponseModel> createColor(
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody ColorRecipe colorRecipe) {
		
		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}

		resp.setMessage("Not Implemented");
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
		
	}
	
	@PutMapping(value = "colorrecipe")
	ResponseEntity<ResponseModel> editColor (
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody ColorRecipe colorRecipe) {

		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}

		resp.setMessage("Not Implemented");
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);

	}
	
	@DeleteMapping(value = "colorrecipe")
	ResponseEntity<ResponseModel> deleteColor (
			@RequestHeader(value = "access-token", required = true) String r,
			@RequestBody ColorRecipe colorRecipe) {
		
		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}

		resp.setMessage("Not Implemented");
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);

		
	}
	
	@GetMapping(value ="colorrecipe")
	ResponseEntity<ResponseModel> getAllColors (
			@RequestHeader(value = "access-token", required = true) String r) {

		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}

		resp.setMessage("Not Implemented");
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}

	@GetMapping(value ="colorrecipe/{colorId}")
	ResponseEntity<ResponseModel> getOneColor (
			@RequestHeader(value = "access-token", required = true) String r) {

		ResponseModel resp = new ResponseModel();

		if (!userAuthenticationService.isUserAdmin(r)) {
			throw new AccessDeniedException("access denied");
		}

		resp.setMessage("Not Implemented");
		
		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}

	

}
