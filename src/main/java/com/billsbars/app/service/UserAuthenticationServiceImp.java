package com.billsbars.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billsbars.app.model.Token;

@Service("UserAuthenticationService")
public class UserAuthenticationServiceImp implements UserAuthenticationService {

	@Autowired
	TokenRepositoryService tokenRepositoryService;

	public UserAuthenticationServiceImp(TokenRepositoryService service) {
		System.out.println("in user auth constructor");
		this.tokenRepositoryService = service;		
	}
	
	@Override
	public boolean isUserAdmin(String token) {
		
		if (token != null) {
	    	Optional<String> userRole = tokenRepositoryService.getRoleByToken(token);
	    	if(userRole.isPresent()) {
	    		String role = userRole.get();
	    		if(role != null && (role.equals("ADMIN"))) {
	    			return true;
	    		} 
	    	}
		}

		return false;
	}

}
