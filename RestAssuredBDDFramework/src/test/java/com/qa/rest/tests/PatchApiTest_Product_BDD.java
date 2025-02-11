package com.qa.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchApiTest_Product_BDD {

    
	@Test
	public void Test_PATCH_Product()
	{
		
		String jsonReqBody="{\r\n"
				+ "  \r\n"
				+ "  \"price\": 4.99\r\n"
				+ " \r\n"
				+ " }";
		
		given().
			accept(ContentType.JSON).
			and().
			contentType(ContentType.JSON).
			and().
			header("Content-Type","application/json").
			and().
			header("Accept","application/json").
			and().
			body(jsonReqBody).		
			
		when().
			patch("http://localhost:3030/products/43900").
		then().
				assertThat().
				statusCode(200).
				and(). 
				body("type",equalTo("HardGood")).
				and(). 
				body("price", equalTo(4.99f)). 
				and(). 
				body("shipping", equalTo(0)).
				and(). 
				body("manufacturer", equalTo("Duracell")).
				and(). 
				body("model", equalTo("MN2400B4Z")).
				and(). 
				header("Content-Type", equalTo("application/json; charset=utf-8"));
				
		
	}


}



