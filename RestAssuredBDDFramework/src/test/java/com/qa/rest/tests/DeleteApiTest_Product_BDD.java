package com.qa.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteApiTest_Product_BDD {
	@Test(priority=1)
	public void Test_Delete_Product()
	{
		
			given().
			accept(ContentType.JSON).
			and().
			contentType(ContentType.JSON).
			and().
			header("Content-Type","application/json").
			and().
			header("Accept","application/json").
						
		when().
			delete("http://localhost:3030/products/347146").
		then().
				assertThat().
				statusCode(200).
				and(). 
				body("type",equalTo("HardGood")).
				and(). 
				body("price", equalTo(16.99f)). 
				and(). 
				body("shipping", equalTo(0)).
				and(). 
				body("manufacturer", equalTo("Metra")).
				and(). 
				body("model", equalTo("70-1721")).
				and(). 
				header("Content-Type", equalTo("application/json; charset=utf-8"));
				
		
	}

	@Test(priority=2)
	public void Verify_Delete_Product()
	{
		
			given().
			accept(ContentType.JSON).
			and().
			contentType(ContentType.JSON).
			and().
			header("Content-Type","application/json").
			and().
			header("Accept","application/json").
						
		when().
			get("http://localhost:3030/products/347146").
		then().
				assertThat().
				statusCode(404).
				and(). 
				body("name",equalTo("NotFound")).
				and(). 
				body("message", equalTo("No record found for id \'347146\'")). 
				and(). 
				body("code", equalTo(404)).
				and(). 
				body("className", equalTo("not-found")).
				and(). 
				header("Content-Type", equalTo("application/json; charset=utf-8"));
				
		
	}

}


