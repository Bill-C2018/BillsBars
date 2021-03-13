package com.billsbars.app.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
 
@Repository("InMemTokenStore")
public class InMemoryTokenStore {
	
/*
 * TODO
 * should probably just bite the bullet and store the
 * entire token object	
 */
	
	
	
	private Map<String,String[]> tokenStore = 
			new HashMap<String, String[]>();
	
	{
		String[] data = {"ADMIN","BILLC"};
		tokenStore.put("123456789",data);
	}
/*	
 * need to figure this bit out .. seems it always returns null 
 * the way I have things working now
	{
		final String[] activeProfile = env.getActiveProfiles();
		if (activeProfile[0].equalsIgnoreCase("dev") || activeProfile[0].equalsIgnoreCase("test")) {
			tokenStore.put("123456789","ADMIN");
		}
	}
*/
	
	public void save(String token, String role, String userName) {
		String[] data = {role,userName};
		
		tokenStore.put(token, data);
	}
	
	public Optional<String[]> findByToken(String token) {

		Optional<String[]> empty = Optional.empty();
		if (tokenStore.containsKey(token)) {
			String[] ret = tokenStore.get(token);
			Optional<String[]> optRet = Optional.of(ret);
			return optRet;
		}
		return empty;
	}	

}
