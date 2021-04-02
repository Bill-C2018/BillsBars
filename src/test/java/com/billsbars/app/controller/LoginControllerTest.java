package com.billsbars.app.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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

import com.billsbars.app.model.CustomerModel;
import com.billsbars.app.model.ResponseModel;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class LoginControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private String myToken = "";
	
	CustomerModel customer = new CustomerModel("billc@yahoo.com","billc-2018","Password1");

	
	@BeforeAll
	public void setUp() {

		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "");
        HttpEntity<?> entity = new HttpEntity<>(customer,headers);	
		String uri = "http://localhost:";
		uri += port + "/customer";        
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();
		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("User Created")).isTrue();

	}
	
	@AfterAll
	public void cleanUp() {

		HttpHeaders headers3 = new HttpHeaders();
        headers3.set("access-token", myToken);
        HttpEntity<?> entity3 = new HttpEntity<>(customer,headers3);	
        String uri = "http://localhost:";
		uri += port + "/customer";      

		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.DELETE, entity3, ResponseModel.class);
		ResponseModel bdy = response.getBody();
		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Customer deleted")).isTrue();

	}
	
	@Test
	void loginCustomer() throws Exception {
		
		HttpHeaders headers2 = new HttpHeaders();
        headers2.set("access-token", "");
        HttpEntity<?> entity2 = new HttpEntity<>(customer,headers2);	
		String uri2 = "http://localhost:";
		uri2 += port + "/login";   
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri2, HttpMethod.POST, entity2, ResponseModel.class);
		ResponseModel bdy = response.getBody();
		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Logged in")).isTrue();
		assertThat(bdy.getToken() != null).isTrue();
		this.myToken = bdy.getToken();

	
	}

}
