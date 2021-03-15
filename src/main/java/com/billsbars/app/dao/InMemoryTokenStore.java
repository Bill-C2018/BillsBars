package com.billsbars.app.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.billsbars.app.model.Token;
 
@Repository("InMemTokenStore")
public class InMemoryTokenStore {
	
	
	
	private Map<String,Token> tokenStore = 
			new HashMap<String, Token>();
	

	public void save(Token token) {
		
		tokenStore.put(token.getToken(),token);
	}
	
	public Optional<Token> findByToken(Token token) {

		Optional<Token> empty = Optional.empty();
		if (tokenStore.containsKey(token.getToken())) {
			Token ret = tokenStore.get(token.getToken());
			Optional<Token> optRet = Optional.of(ret);
			return optRet;
		}
		return empty;
	}	
	
	public Token getFullToken(String t) {
		
		if(tokenStore.containsKey(t)) {
			return tokenStore.get(t);
		} else {
			return null;
		}
	}

}
