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

import com.billsbars.app.model.CustomerModel;
import com.billsbars.app.model.ResponseModel;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void createCustomer() throws Exception {
		
		CustomerModel customer = new CustomerModel("bob@google.com","billc","howdy");

		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(customer,headers);	
		String uri = "http://localhost:";
		uri += port + "/customer";        
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();
		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("User Created")).isTrue();
		response = this.restTemplate.exchange(uri, HttpMethod.DELETE, entity, ResponseModel.class);
		bdy = response.getBody();
		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Customer deleted")).isTrue();

	}
	

}