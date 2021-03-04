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

import com.billsbars.app.model.ColorRecipe;
import com.billsbars.app.model.ResponseModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class ColorRecipeControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void createColor() throws Exception {

		ColorRecipe colorRecipe = new ColorRecipe();
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(colorRecipe,headers);	
		String uri = "http://localhost:";
		uri += port + "/colorrecipe";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Not Implemented")).isTrue();

	}	
	
	@Test
	void editColor() throws Exception {

		ColorRecipe colorRecipe = new ColorRecipe();
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(colorRecipe,headers);	
		String uri = "http://localhost:";
		uri += port + "/colorrecipe";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.PUT, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Not Implemented")).isTrue();

	}	
	
	@Test
	void deleteColor() throws Exception {

		ColorRecipe colorRecipe = new ColorRecipe();
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(colorRecipe,headers);	
		String uri = "http://localhost:";
		uri += port + "/colorrecipe";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.DELETE, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Not Implemented")).isTrue();

	}	

	@Test
	void getAllColors() throws Exception {

		ColorRecipe colorRecipe = new ColorRecipe();
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(colorRecipe,headers);	
		String uri = "http://localhost:";
		uri += port + "/colorrecipe";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.GET, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Not Implemented")).isTrue();

	}		
	
	@Test
	void getOneColor() throws Exception {

		ColorRecipe colorRecipe = new ColorRecipe();
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(colorRecipe,headers);	
		String uri = "http://localhost:";
		uri += port + "/colorrecipe/00001";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.GET, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Not Implemented")).isTrue();

	}		

}
