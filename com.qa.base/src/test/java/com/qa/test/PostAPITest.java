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

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.data.Users;

import come.qa.client.RestClient_1;

public class PostAPITest extends TestBase {
	public PostAPITest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	TestBase testbase;
	String serviceurl;
	String apiurl;
	String url;
	RestClient_1 restclient;
	CloseableHttpResponse closeablehttpresponse;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testbase = new TestBase();
		serviceurl = prop.getProperty("ServiceURL");
		apiurl = prop.getProperty("APIURL");
		url = serviceurl + apiurl;

	}
	@Test
	public void postApiTest() throws JsonGenerationException, JsonMappingException, IOException {
		restclient = new RestClient_1();
		
		HashMap<String, String> headerMap=new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		
		//Jackson is needed to convert POJO to JSON
		
		//Create Mapper Obj
		ObjectMapper mapperObj=new ObjectMapper();
		
		//create User obj for payload
		Users users=new Users("morpheus","leader");
		
		//Using mapper object and jackson api convert Users.java to json payload and json payload for post call will be saved in userjson file
		//Obj to json file
		try {
		mapperObj.writeValue(new File("C:\\Users\\shris\\RESTAPITESTING\\com\\qa\\base\\src\\main\\java\\com\\qa\\data\\users.json"), users);
		}catch(FileNotFoundException e)
		{
			
		}
		//java obj to json in string
		String usersjsonString=mapperObj.writeValueAsString(users);
		System.out.println(usersjsonString);
		
		
		closeablehttpresponse=restclient.post(url,usersjsonString,headerMap);
		
		int statusCode=closeablehttpresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode,RESPONSE_STATUS_CODE_201);
		
		String responseString = EntityUtils.toString(closeablehttpresponse.getEntity(), "UTF-8");
		System.out.println("response String is -->" + responseString);
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("response Json from API is -->" + responseJson);
		
		Users userResObj=mapperObj.readValue(responseString,Users.class);
		System.out.println(userResObj);
		
		Assert.assertTrue(users.getName().equals(userResObj.getName()));
		Assert.assertTrue(users.getJob().equals(userResObj.getJob()));
		
		System.out.println("ID-->"+userResObj.getId());
		System.out.println("Created time-->"+userResObj.getCreatedAt());

}
}
