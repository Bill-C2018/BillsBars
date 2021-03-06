package com.billsbars.app;

public class DuplicateRecordException extends RuntimeException {
	
	public DuplicateRecordException(String errorMessage) {
		super(errorMessage);
	}

}
