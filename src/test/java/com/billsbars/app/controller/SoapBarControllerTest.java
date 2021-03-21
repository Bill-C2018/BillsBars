package com.billsbars.app.controller;

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
import org.springframework.test.util.ReflectionTestUtils;

import com.billsbars.app.model.BarOfSoap;
import com.billsbars.app.model.BarTypes;
import com.billsbars.app.model.BaseColor;
import com.billsbars.app.model.BaseScents;
import com.billsbars.app.model.BaseTypes;
import com.billsbars.app.model.ColorRecipe;
import com.billsbars.app.model.CustomerModel;
import com.billsbars.app.model.MoldStyle;
import com.billsbars.app.model.ResponseModel;
import com.billsbars.app.model.ScentRecipe;
import com.billsbars.app.model.SimpleColor;
import com.billsbars.app.model.SingleScent;
import com.billsbars.app.service.BarOfSoapService;
import com.billsbars.app.service.UserAuthenticationService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class SoapBarControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	private String myToken = "";
	
	CustomerModel customer = new CustomerModel("admin@google.com","admin","Password1");

	
	@BeforeAll
	public void setUp() {
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

	@Test
	void createABarOfSoap() throws Exception {
		
		SimpleColor simpleColor = new SimpleColor(BaseColor.PURPLE,20);
		ArrayList<SimpleColor> newColor = new ArrayList<SimpleColor>();
		newColor.add(simpleColor);
		ColorRecipe colorRecipe = new ColorRecipe(newColor,"TEST Lavender Purple");

		ArrayList<SingleScent> scentRecipe = new ArrayList<SingleScent>();
		scentRecipe.add(new SingleScent(BaseScents.BLUEBERRY_COBBLER,8));
		scentRecipe.add(new SingleScent(BaseScents.VANILLA,2));
		ScentRecipe scent = new ScentRecipe("Blueberry Vanilla",scentRecipe);

		
		BarOfSoap soap = new BarOfSoap("Bob", BarTypes.FULLBAR,
				BaseTypes.GOATSMILK,colorRecipe.getFinalColor(),scent.getName(),MoldStyle.STANDARD,true);
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", this.myToken);
        HttpEntity<?> entity = new HttpEntity<>(soap,headers);	
		String uri = "http://localhost:";
		uri += port + "/soaps";        
		

		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Soap added")).isTrue();

	}
	
	@Test
	void editABarOfSoap() throws Exception {
		
		BarOfSoap soap = new BarOfSoap();
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", this.myToken);
        HttpEntity<?> entity = new HttpEntity<>(soap,headers);	
		String uri = "http://localhost:";
		uri += port + "/soaps";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.PUT, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Not Implemented")).isTrue();

	}

	@Test
	void deleteABarOfSoap() throws Exception {
		
		SimpleColor simpleColor = new SimpleColor(BaseColor.PURPLE,20);
		ArrayList<SimpleColor> newColor = new ArrayList<SimpleColor>();
		newColor.add(simpleColor);
		ColorRecipe colorRecipe = new ColorRecipe(newColor,"TEST Lavender Purple");

		ArrayList<SingleScent> scentRecipe = new ArrayList<SingleScent>();
		scentRecipe.add(new SingleScent(BaseScents.BLUEBERRY_COBBLER,8));
		scentRecipe.add(new SingleScent(BaseScents.VANILLA,2));
		ScentRecipe scent = new ScentRecipe("Blueberry Vanilla",scentRecipe);

		
		BarOfSoap soap = new BarOfSoap("Bob",BarTypes.FULLBAR,
				BaseTypes.GOATSMILK,colorRecipe.getFinalColor(),scent.getName(),MoldStyle.STANDARD,true);
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", this.myToken);
        HttpEntity<?> entity = new HttpEntity<>(soap,headers);	
		String uri = "http://localhost:";
		uri += port + "/soaps";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.DELETE, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Soap deleted")).isTrue();

	}

	@Test
	void getOneBarOfSoap() throws Exception {
		
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", this.myToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);	
		String uri = "http://localhost:";
		uri += port + "/soaps/0001";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.GET, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		assertThat(bdy.getMessage().equalsIgnoreCase("Not Implemented")).isTrue();

	}
	
	@Test
	void getAllBarsOfSoap() throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
        headers.set("access-token", this.myToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);	
		String uri = "http://localhost:";
		uri += port + "/soaps";        
		
		ResponseEntity<ResponseModel> response = this.restTemplate.exchange(uri, HttpMethod.GET, entity, ResponseModel.class);
		ResponseModel bdy = response.getBody();

		assertThat(response.getStatusCode() == HttpStatus.OK).isTrue();
		if (bdy.getListOfSoaps() == null) {
			assertThat(bdy.getMessage().equalsIgnoreCase("None found")).isTrue();
		} else {
			assertThat(bdy.getMessage().equalsIgnoreCase("soaps found")).isTrue();
		}
		

	}
}
