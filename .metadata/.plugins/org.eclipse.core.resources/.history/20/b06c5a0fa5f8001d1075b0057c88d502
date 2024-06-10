package com.qa.rest.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetCallBDD {
	@Test
	public void test_noOfCircuits_2015_Season()
	{
		given().
		when().
			get("http://ergast.com/api/f1/2020/circuits.json").
		then().
			assertThat().
				statusCode(200).
				and(). 
				body("MRData.limit",equalTo("30")).
				and().
				body("MRData.CircuitTable.Circuits.circuitId", hasSize(14)).
				and(). 
				header("Content-Length", equalTo("3184")).
				and(). 
				header("Content-Type", equalTo("application/json; charset=utf-8"));
	}
}
