package com.billsbars.app;

public class RecordNotFoundException extends RuntimeException {
	
	public RecordNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
