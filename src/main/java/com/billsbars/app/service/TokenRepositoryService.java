package com.billsbars.app.service;

import java.util.Optional;

import com.billsbars.app.model.Token;

public interface TokenRepositoryService {

	public void createRecord(Token t);
	
	public Optional<Token> getRoleByToken(Token t);
	
	public Token getCompleteTokenFromTokenString(String t);
}
