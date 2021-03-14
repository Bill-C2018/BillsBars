package com.billsbars.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billsbars.app.dao.InMemoryTokenStore;
import com.billsbars.app.model.Token;

@Service("TokenRepositoryService")
public class TokenRepositoryServiceImp implements TokenRepositoryService {

	
	@Autowired
	private InMemoryTokenStore tokenRepo;

	@Override
	public void createRecord(Token t) {
		tokenRepo.save(t);
	}

	@Override
	public Optional<Token> getRoleByToken(Token t) {
		return tokenRepo.findByToken(t);	
	}
	
	public Token getCompleteTokenFromTokenString(String t) {
		return tokenRepo.getFullToken(t);
	}

}
