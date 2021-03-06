package com.billsbars.app;

public class AccessDeniedException extends RuntimeException{
	
	public AccessDeniedException(String errorMessage) {
		super(errorMessage);
	}

}
