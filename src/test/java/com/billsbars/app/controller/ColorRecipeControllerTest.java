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

import com.billsbars.app.model.BaseColor;
import com.billsbars.app.model.ColorRecipe;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.model.SimpleColor;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class ColorRecipeControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	

	@Test
	void createColor() throws Exception {
		
		SimpleColor simpleColor = new SimpleColor(BaseColor.PURPLE,20);
		ArrayList<SimpleColor> newColor = new ArrayList<SimpleColor>();
		newColor.add(simpleColor);

		ColorRecipe colorRecipe = new ColorRecipe(newColor,"TEST Lavender Purple");
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(colorRecipe,headers);	
		String uri = "http://localhost:";
		uri += port + "/colorrecipe";        
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.DELETE, entity, ResponseModel.class);
		response = this.restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseModel.class);

		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Color Created")).isTrue();

		response = this.restTemplate.exchange(uri, HttpMethod.DELETE, entity, ResponseModel.class);
		bdy = response.getBody();
		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Color Deleted")).isTrue();

	}	


	@Test
	void editColor() throws Exception {

		SimpleColor simpleColor = new SimpleColor(BaseColor.PURPLE,20);
		ArrayList<SimpleColor> newColor = new ArrayList<SimpleColor>();
		newColor.add(simpleColor);

		ColorRecipe colorRecipe = new ColorRecipe(newColor,"TEST2 Lavender Purple");
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(colorRecipe,headers);	
		String uri = "http://localhost:";
		uri += port + "/colorrecipe";     

		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.DELETE, entity, ResponseModel.class);
		response = this.restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseModel.class);

		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Color Created")).isTrue();

        HttpEntity<?> entity2 = new HttpEntity<>(headers);	
		uri = "http://localhost:";
		uri += port + "/colorrecipe/" + colorRecipe.getFinalColor();        
		
		response = this.restTemplate.exchange(uri, HttpMethod.GET, entity2, ResponseModel.class);
		bdy = response.getBody();
		
		ArrayList<ColorRecipe> colors = bdy.getColorRecipes();
		assertThat(colors != null).isTrue();
		assertThat(colors.get(0) != null).isTrue();
		
		ColorRecipe acolor = colors.get(0);
		acolor.setFinalColor("TEST edit color");

        HttpEntity<?> entity3 = new HttpEntity<>(acolor,headers);	
        uri = "http://localhost:";
		uri += port + "/colorrecipe";        

		response = this.restTemplate.exchange(uri, HttpMethod.PUT, entity3, ResponseModel.class);
		bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Color updated")).isTrue();
		colors = bdy.getColorRecipes();
		assertThat(colors != null).isTrue();
		assertThat(colors.get(0) != null).isTrue();
		assertThat(colors.get(0).getFinalColor().equals(acolor.getFinalColor()));
		

	}	


	@Test
	void deleteColor() throws Exception {

		SimpleColor simpleColor = new SimpleColor(BaseColor.PURPLE,20);
		ArrayList<SimpleColor> newColor = new ArrayList<SimpleColor>();
		newColor.add(simpleColor);

		ColorRecipe colorRecipe = new ColorRecipe(newColor,"TEST Lavender Purple");
		
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
	void getOneColorThrowsNotFound() throws Exception {

		ColorRecipe colorRecipe = new ColorRecipe();
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", "123456789");
        HttpEntity<?> entity = new HttpEntity<>(colorRecipe,headers);	
		String uri = "http://localhost:";
		uri += port + "/colorrecipe/00001";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.GET, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.NOT_FOUND).isTrue();
		assertThat(bdy.getMessage().contains("Color Not Found")).isTrue();

	}		

}
