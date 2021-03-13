package com.billsbars.app.service;

import com.billsbars.app.model.Token;

public interface UserAuthenticationService {
	
	boolean isUserAdmin(String token);
	boolean isUserAdminOrSelf(String token, String userName);

}
