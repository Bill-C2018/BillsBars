package com.billsbars.app.service;

import com.billsbars.app.model.Token;

public interface UserAuthenticationService {
	
	boolean isUserAdmin(Token token);
	boolean isUserAdminOrSelf(Token token, String userName);
	boolean isUserAdmin(String t);
	boolean isUserAdminOrSelf(String t, String userName);

}
