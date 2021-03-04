package com.billsbars.app.controller;

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

import com.billsbars.app.model.BarOfSoap;
import com.billsbars.app.model.ResponseModel;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class SoapBarControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	
	@Test
	void createABarOfSoap() throws Exception {
		
		BarOfSoap soap = new BarOfSoap();
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(soap,headers);	
		String uri = "http://localhost:";
		uri += port + "/soaps";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();
		System.out.println(bdy);
		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();

	}
	
	@Test
	void editABarOfSoap() throws Exception {
		
		BarOfSoap soap = new BarOfSoap();
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(soap,headers);	
		String uri = "http://localhost:";
		uri += port + "/soaps";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.PUT, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();
		System.out.println(bdy);
		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();

	}

	@Test
	void deleteABarOfSoap() throws Exception {
		
		BarOfSoap soap = new BarOfSoap();
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(soap,headers);	
		String uri = "http://localhost:";
		uri += port + "/soaps";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.DELETE, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();
		System.out.println(bdy);
		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();

	}

	@Test
	void getOneBarOfSoap() throws Exception {
		
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(headers);	
		String uri = "http://localhost:";
		uri += port + "/soaps/0001";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.GET, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();
		System.out.println(bdy);
		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();

	}
	
	@Test
	void getAllBarsOfSoap() throws Exception {
		
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(headers);	
		String uri = "http://localhost:";
		uri += port + "/soaps";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.GET, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();
		System.out.println(bdy);
		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();

	}
}
