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
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<String> getRoleByToken(String t) {
		return tokenRepo.findByToken(t);	}

}
