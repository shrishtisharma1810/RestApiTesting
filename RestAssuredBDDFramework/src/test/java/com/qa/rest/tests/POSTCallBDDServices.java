package com.qa.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class POSTCallBDDServices {
	public String requestBody = "{\n" +
            "  \"name\": \"FreeBie\" \n}";
	@Test
	public void test_POST_Service()
	{
		
		given().
			body(requestBody).
		when().
			get("http://localhost:3030/services").
		then().
			assertThat().
				statusCode(200).
				and(). 
				body("name",equalTo("FreeBie"));
				
		/*
				and(). 
				body("country_code", equalTo("US")). 
				and(). 
				body("data[0].clouds", equalTo(11)).
				and(). 
				body("data[3].weather.code", equalTo(500)).
				/*
				and(). 
				body("lon", equalTo("-78.5")).
				and(). 
				body("state_code", equalTo("VA")).
				and(). 
				body("timezone", equalTo("America/New_York")).
				and(). 
				
				header("access-control-allow-methods", equalTo("GET, OPTIONS, POST")).
				and(). 
				header("Content-Type", equalTo("application/json; charset=utf-8")).
				and(). 
				header("Server", equalTo("RapidAPI-1.2.8"));
				*/
		
	}

	

}



