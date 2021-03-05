package com.billsbars.app.service;

import com.billsbars.app.model.Token;

public interface UserAuthenticationService {
	
	boolean isUserAdmin(Token token);

}
