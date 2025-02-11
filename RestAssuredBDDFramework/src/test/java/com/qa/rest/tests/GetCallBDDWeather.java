package com.qa.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.Test;

//import io.restassured.specification.RequestSpecification;

public class GetCallBDDWeather {
	@Test
	public void test_Severe_Alerts()
	{
		given().
			param("lat","38.5").
			and().
			param("lon","-78.5"). 
			and().
			header("X-RapidAPI-Key","7edad2c639msh27e6a88b6935e50p1b8858jsn5affb6061184").
			and().
			header("X-RapidAPI-Host","weatherbit-v1-mashape.p.rapidapi.com"). 
		when().
			get("https://weatherbit-v1-mashape.p.rapidapi.com/forecast/daily?lat=38.5&lon=-78.5").
		then().
			assertThat().
				statusCode(200).
				and(). 
				body("city_name",equalTo("Stanley")).
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
				*/
				header("access-control-allow-methods", equalTo("GET, OPTIONS, POST")).
				and(). 
				header("Content-Type", equalTo("application/json; charset=utf-8")).
				and(). 
				header("Server", equalTo("RapidAPI-1.2.8"));
		
	}

	//private RequestSpecification .and() {
		// TODO Auto-generated method stub
		//return null;
	//}

}
