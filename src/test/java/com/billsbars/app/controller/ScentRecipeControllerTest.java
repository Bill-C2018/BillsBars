package com.billsbars.app.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.billsbars.app.model.BarOfSoap;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.model.Scent;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class ScentRecipeControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void createScent() throws Exception {
		
		Scent scent = new Scent();
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(scent,headers);	
		String uri = "http://localhost:";
		uri += port + "/scentrecipe";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Not Implemented")).isTrue();

	}	
	
	@Test
	void editScent() throws Exception {
		
		Scent scent = new Scent();
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(scent,headers);	
		String uri = "http://localhost:";
		uri += port + "/scentrecipe";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.PUT, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Not Implemented")).isTrue();

	}
	
	void deleteScent() throws Exception {
		
		Scent scent = new Scent();
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(scent,headers);	
		String uri = "http://localhost:";
		uri += port + "/scentrecipe/0001";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.DELETE, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Not Implemented")).isTrue();

	}
	
	void getAllScents() throws Exception {
		
		Scent scent = new Scent();
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(scent,headers);	
		String uri = "http://localhost:";
		uri += port + "/scentrecipe";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.GET, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Not Implemented")).isTrue();

	}

	void getOneScents() throws Exception {
		
		Scent scent = new Scent();
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(scent,headers);	
		String uri = "http://localhost:";
		uri += port + "/scentrecipe/00001";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.GET, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Not Implemented")).isTrue();

	}
	
}
