package com.billsbars.app.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

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
import com.billsbars.app.model.BaseScents;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.model.ScentRecipe;
import com.billsbars.app.model.SingleScent;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class ScentRecipeControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
/*
	@Test
	void createScent() throws Exception {
		
		
		ArrayList<SingleScent> scentRecipe = new ArrayList<SingleScent>();
		scentRecipe.add(new SingleScent(BaseScents.BLUEBERRY_COBBLER,8));
		scentRecipe.add(new SingleScent(BaseScents.VANILLA,2));
		ScentRecipe scent = new ScentRecipe("Blueberry Vanilla",scentRecipe);
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(scent,headers);	
		String uri = "http://localhost:";
		uri += port + "/scentrecipe";        

		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.DELETE, entity, ResponseModel.class);

		response = this.restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Scent created")).isTrue();

	}	
*/
	@Test
	void createScentNoName() throws Exception {

		ArrayList<SingleScent> scentRecipe = new ArrayList<SingleScent>();
		scentRecipe.add(new SingleScent(BaseScents.BLUEBERRY_COBBLER,8));
		scentRecipe.add(new SingleScent(BaseScents.VANILLA,2));
		ScentRecipe scent = new ScentRecipe("",scentRecipe);
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(scent,headers);	
		String uri = "http://localhost:";
		uri += port + "/scentrecipe";        


		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.BAD_REQUEST).isTrue();
		assertThat(bdy.getMessage().contains("Validation")).isTrue();

	}	

	
	@Test
	void editScent() throws Exception {
		
		ScentRecipe scent = new ScentRecipe();
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
		
		ScentRecipe scent = new ScentRecipe();
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
		
		ScentRecipe scent = new ScentRecipe();
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
		
		ScentRecipe scent = new ScentRecipe();
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
