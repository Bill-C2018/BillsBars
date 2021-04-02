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
		this.tokenRepositoryService = service;		
	}
	
	@Override
	public boolean isUserAdmin(String t) {
		Token tok = tokenRepositoryService.getCompleteTokenFromTokenString(t);
		if (tok != null) {
			return isUserAdmin(tok);
		} else {
			return false;
		}
	}
	@Override
	public boolean isUserAdmin(Token token) {
		
		if (token != null) {
	    	Optional<Token> t = tokenRepositoryService.getRoleByToken(token);
	    	if(t.isPresent()) {
	    		Token tok = t.get();
	    		if(tok.getRole() != null && (tok.getRole().equals("ADMIN"))) {
	    			return true;
	    		} 
	    	}
		}

		return false;
	}
	
	@Override
	public boolean isUserAdminOrSelf(String t, String userName) {

		Token tok = tokenRepositoryService.getCompleteTokenFromTokenString(t);
		if (tok != null) {
			return isUserAdminOrSelf(tok,userName);
		} else {
			return false;
		}
		
	}
	
	@Override
	public boolean isUserAdminOrSelf(Token token, String userName) {
		if (token != null) {
	    	Optional<Token> t = tokenRepositoryService.getRoleByToken(token);
	    	if(t.isPresent()) {
	    		Token tok = t.get();
	    		if(tok.getToken() != null && ((tok.getRole().equals("ADMIN")) || tok.getUserName().equals(userName))) {
	    			return true;
	    		} 
	    	}
		}

		return false;
		
	}

}
