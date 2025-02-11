package com.qa.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.data.Users;

import come.qa.client.MaverickRestClient;
import come.qa.client.RestClient_1;

public class MaverickPostApiTest extends TestBase {
	public MaverickPostApiTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	TestBase testbase;
	String serviceurl;
	String apiurl;
	String url;
	MaverickRestClient restclient;
	CloseableHttpResponse closeablehttpresponse;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testbase = new TestBase();
		serviceurl = prop.getProperty("ServiceURL1");
		apiurl = prop.getProperty("APIURL2");
		url = serviceurl + apiurl;

	}
	@Test
	public void postApiTest() throws JsonGenerationException, JsonMappingException, IOException {
		restclient = new MaverickRestClient();
		String token="eyJhbGciOiJSUzUxMiJ9.eyJpc3MiOiJodHRwczovL21hdmVyaWNrLmRldiIsImlhdCI6MTY4NDgyMTYyNiwianRpIjoiMSIsImV4cCI6MTY4NDgyNTIyNiwic3ViIjoiYjIxMGIyUnJZWEk9In0.gYM83al7QNtRzlzue9bXhWwiXGf3i1Pcu6hqy27gKi1DMySKXfkJAMVWDN9N1-OMCfRGSwo9986g-OFF8rXHbuJY9a3tDLv7Uai7BgD5NGBT4grbZ-2xKIOk3eN-nrIF4ljz_0WT8mmX6Ogblz-sVRFHL8EPMep_aQslFKM5Jcl5cjDRDDxz_NvMOVg6vZ2rI9WcfIM48GgwZGjbjggDTOs75TEFSbORLRdny0S8I3YaHyzK8A2VjoRrYO9dIa0yo7icx4rB18Y8N6IcqaBb30yjArXnVAgIAOItC7i0Lzl-oz6d5DcA0hm-FQCtf9IM-LpivW8UUXUiTacgPqkkG-5jJQgG2eTylIj8iFnlGCnFXj5tb1gbFEd87OBXLWL2mEHjhBGrqLn7N_ZrLeouNt3f2zBvASKqdtR6ZM7d1O_O570r1bB5gwZLJ1gZx5G3rES0CAaQH1pO1cvaPZDRsWaZiXXFSQRW4Xxdkd3AhtuERITn-G3yt9Obb0DtkSMvyfuj4oAH_fb8v13wGG1xKjyPppa-nJyzPzPn3ZsMK0rGkk_RzFYXVAzAJy_vOz57dmsnqb4C5evg709wi07H1exk4VMUKnZJ_iKOZZvEEZTUqG1IsP4oDd_ZFdLZJpkoTbIX7MHlR1mrBp15qY8AcuecIrtWE4kDPg0eAVW7AJk";
		
		HashMap<String, String> headerMap=new HashMap<String, String>();
		headerMap.put("Accept", "application/json");
		headerMap.put("Authorization", "Bearer " + token);
		
		//Jackson is needed to convert POJO to JSON
		
		//Create Mapper Obj
		ObjectMapper mapperObj=new ObjectMapper();
		
		//create User obj for payload
		String jsonString = "{\"limit\" : 10,\"offset\" : 0,\"query\" : \"*\",\"filters\" : \"[]\"}";
		/*
    	Construct a request specification
    */
   // RequestSpecification request= RestAssured.given();
   
    /*
    	Setting content type to specify the format in which the request payload will be sent.
    */
    //request.contentType(ContentType.JSON);

    /*
    	Adding URI
    */
    //request.baseUri("https://reqres.in/api/users");

    /*
    	Adding body as string
    */
  //  restclient.body(jsonString);
   
    /*
    	Calling POST method on URI. After hitting, we get Response
    */
   // Response response = request.post();
   
    /*
    	Printing Response as string
    */
  //  System.out.println(response.asString());
   
    /*
    	Get Validatable response to perform validation
    */
  //  ValidatableResponse validatableResponse = response.then();
   
    /*
    	Validate status code as 201
    */
  //  validatableResponse.statusCode(201);

 //   System.out.println(response.getStatusCode());
 //   System.out.println(response.getTime());
    }
//}
		
	//	closeablehttpresponse=restclient.post(url,jsonString,headerMap);
		
		int statusCode=closeablehttpresponse.getStatusLine().getStatusCode();
	//	Assert.assertEquals(statusCode,RESPONSE_STATUS_CODE_200);
		
	//	String responseString = EntityUtils.toString(closeablehttpresponse.getEntity(), "UTF-8");
	//	System.out.println("response String is -->" + responseString);
		
	//	JSONObject responseJson = new JSONObject(responseString);
	//	System.out.println("response Json from API is -->" + responseJson);
		
	//	Users userResObj=mapperObj.readValue(responseString,Users.class);
	//	System.out.println(userResObj);
		
	//	Assert.assertTrue(users.getName().equals(userResObj.getName()));
	//	Assert.assertTrue(users.getJob().equals(userResObj.getJob()));
		
	//	System.out.println("ID-->"+userResObj.getId());
	//	System.out.println("Created time-->"+userResObj.getCreatedAt());

//}
}


//}
