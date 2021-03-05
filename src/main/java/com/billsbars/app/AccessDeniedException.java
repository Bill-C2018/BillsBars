package com.billsbars.app;

public class AccessDeniedException extends Exception{
	
	public AccessDeniedException(String errorMessage) {
		super(errorMessage);
	}

}
