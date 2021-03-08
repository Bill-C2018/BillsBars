package com.billsbars.app.controller;



import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.billsbars.app.AccessDeniedException;
import com.billsbars.app.DuplicateRecordException;
import com.billsbars.app.RecordNotFoundException;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.model.FieldErrorMessage;

@RestControllerAdvice
public class ControllerExceptions {
	
	Logger logger = LoggerFactory.getLogger(ControllerExceptions.class);
	
	@ExceptionHandler(AccessDeniedException.class)
	ResponseEntity<ResponseModel> handleAccessDenied() {
		logger.info("|*** Access Denied Exception ***|");
		
		ResponseModel resp = new ResponseModel();
		resp.setCode(403);
		resp.setMessage("Access Denied");
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(resp);
	}
	
	@ExceptionHandler(ValidationException.class)
	ResponseEntity<ResponseModel> validationExceptionHandler(ValidationException e) {
		logger.info("|***  Validation execption {}  ***|",e.getMessage());
		ResponseModel resp = new ResponseModel();
		resp.setCode(400);
		resp.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}

	@ExceptionHandler(DuplicateRecordException.class)
	ResponseEntity<ResponseModel> duplicateRecordExceptionHandler(DuplicateRecordException e) {
		logger.info("|*** Duplicate record exception {}  ***|",e.getMessage());
		ResponseModel resp = new ResponseModel();
		resp.setCode(400);
		resp.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(resp);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	ResponseEntity<ResponseModel> RecordNotFoundException(RecordNotFoundException e) {
		logger.info("|***  Record not found exception {}  ***|",e.getMessage());
		ResponseModel resp = new ResponseModel();
		resp.setCode(404);
		resp.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ResponseModel> argNotValideHandler(MethodArgumentNotValidException e) {
		logger.info("|***  Method Argument Not Valid Exception {}  ***|",e.getMessage());
		ResponseModel resp = new ResponseModel();
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		List<FieldErrorMessage> fieldErrorMessages = 
				fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(),
				fieldError.getDefaultMessage()))
				.collect(Collectors.toList());
		resp.setFieldErrors(fieldErrorMessages);
		resp.setCode(400);
		resp.setMessage("Argument validation failed");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}	


}
