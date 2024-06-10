package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import come.qa.client.RestClient;

public class GetApiTest extends TestBase{
	

	public GetApiTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	TestBase testbase;
	String serviceurl;
	String apiurl;
	String url;
	RestClient restclient;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException
	{
		testbase= new TestBase();
		serviceurl=prop.getProperty("ServiceURL");
		apiurl=prop.getProperty("APIURL");
		url=serviceurl+apiurl;
		
	}
	
	@Test
	public void getApiTest() throws ClientProtocolException, IOException
	{
		restclient=new RestClient();
		restclient.get(url);
		
	}

}
