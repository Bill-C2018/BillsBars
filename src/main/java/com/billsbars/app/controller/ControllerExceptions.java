package com.billsbars.app.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.billsbars.app.AccessDeniedException;
import com.billsbars.app.model.ResponseModel;

@RestControllerAdvice
public class ControllerExceptions {
	
	Logger logger = LoggerFactory.getLogger(ControllerExceptions.class);
	
	@ExceptionHandler(AccessDeniedException.class)
	ResponseEntity<ResponseModel> handleAccessDenied() {
		logger.info("**** In Access Denied");
		
		ResponseModel resp = new ResponseModel();
		resp.setCode(403);
		resp.setMessage("Access Denied");
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(resp);
	}

}
