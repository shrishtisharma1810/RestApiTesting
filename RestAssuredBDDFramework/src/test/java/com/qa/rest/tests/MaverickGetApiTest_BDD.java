package com.qa.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.Test;

public class MaverickGetApiTest_BDD {
	@Test
	public void Test_User_Profile()
	{
		String token ="eyJhbGciOiJSUzUxMiJ9.eyJpc3MiOiJodHRwczovL21hdmVyaWNrLmRldiIsImlhdCI6MTY4NTY5NTgyNSwianRpIjoiMSIsImV4cCI6MTY4NTY5OTQyNSwic3ViIjoiYjIxMGIyUnJZWEk9In0.ZiKBsh3UBZTPj5P52f1BKI0dO22Ejr5xAdfbb-Bx-264o14YIf8XRiPhhg1EHFkrU05lc4JZ0pUC65DAiRBY6Kk4yj5ibEza8VzzmFeM0SXC_o_XEdGpjzzMbiuY5vqk1A7u83AEEQr5LuErzaJ4Wnz_iKbNLFt09o3sJGldQ2gax8zs4DtKnyLRg4scJNql7tvf2xrr16x1lwHSX-y91vfZOZFcDD4eElZmXqNzRdt0c3LDhFFMG4KE2gC5WADjPlEesaeZHdqG52e4KDH6ShurVhhwovP5OmlXq1fBG6LnOBLN2NZHw1lrX61lqa1GY-1gf2AJ3TZDERQyyDXoXw4x4JOSMMNweeOnQHWLkhCkbAL2a-HHFamzrohr87RCe6edxWElxth98E2EjnUy5PNAMRSgNjhtvd1NbsdgOZlRN6tjJiAv0OG-wY3h8ZoKtZ3vyeTcX7199_ctYF_7IJSrO93xSIgkVgUIaW5m-BTDS0_VRita4L6BhLapyEGF-ruBOjAqVm91byDWSQ7z7Npn5IRfZQP8zuBurQvto-ovePTq2TjEkOYH3-qwjr_Uo08-adlVj5fea0eE-9y78_Kk_JOjlHKIszzITT4wAyu49j35pU6xeqkbFGHyRR6xRyad_McsoUw06rUeQSVDjksbpisKVYV5Rv4CXrYq5sY";
		given().
			header("Authorization", "Bearer " + token).
		when().
			get("https://api.dev.maverick.dev/user/v1.0/profile").
		then().
			assertThat().
				statusCode(200).
				and(). 
				body("status",equalTo("SUCCESS")).
				and().
				body("result.id", equalTo(1)).
				and().
				body("result.firstName", equalTo("Omkar")).
				and().
				body("result.lastName", equalTo("Todkar")).
				and(). 
				header("Content-Length", equalTo("144")).
				and(). 
				header("Content-Type", equalTo("application/json"));
	}

}
