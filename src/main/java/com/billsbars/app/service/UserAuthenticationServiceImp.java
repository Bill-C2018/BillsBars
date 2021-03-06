package com.billsbars.app.service;

import org.springframework.stereotype.Service;

import com.billsbars.app.model.Token;

@Service("UserAuthenticationService")
public class UserAuthenticationServiceImp implements UserAuthenticationService {

	@Override
	public boolean isUserAdmin(String token) {
		// TODO Auto-generated method stub
		return false;
	}

}
