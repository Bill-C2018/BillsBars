package com.billsbars.app.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
 
@Repository("InMemTokenStore")
public class InMemoryTokenStore {
	
//	@Value("${spring.profiles.active}")
	private String activeProfile = "dev";
	
	private Map<String,String> tokenStore = 
			new HashMap<String, String>();
	
	{
		if (activeProfile.equalsIgnoreCase("dev")) {
			tokenStore.put("123456789","ADMIN");
		}
	}
	
	public void save(String token, String role) {
		tokenStore.put(token, role);
	}
	
	public Optional<String> findByToken(String token) {
		Optional<String> empty = Optional.empty();
		if (tokenStore.containsKey(token)) {
			String ret = tokenStore.get(token);
			Optional<String> optRet = Optional.of(ret);
			return optRet;
		}
		return empty;
	}	

}
