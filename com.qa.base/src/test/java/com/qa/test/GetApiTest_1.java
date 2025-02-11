package com.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

//import come.qa.client.RestClient;
import come.qa.client.RestClient_1;

public class GetApiTest_1 extends TestBase {
	public GetApiTest_1() throws IOException {
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
	@Test(priority = 1)
	public void getApiTestwithoutHeaders() throws ClientProtocolException, IOException {
		restclient = new RestClient_1();
		
		closeablehttpresponse=restclient.get(url);
		// Status Code--> get status code from statusline
		int statusCode = closeablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("The Status Code is -->" + statusCode);
		
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status Code is not 200");

		// Response Body
		// response string
		String responseString = EntityUtils.toString(closeablehttpresponse.getEntity(), "UTF-8");
		System.out.println("response String is -->" + responseString);

		// response json
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("response Json from API is -->" + responseJson);
		
		//Validating JSON Response object
		String perPageValue=TestUtil.getValueByJpath(responseJson,"/per_page");
		System.out.println("Per Page value from JSON Response Object-->"+perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		
		String totalValue=TestUtil.getValueByJpath(responseJson,"/total");
		System.out.println("Total value from JSON Response Object-->"+totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		//Validating JSON Response Array
		String first_name=TestUtil.getValueByJpath(responseJson,"/data[2]/first_name");
		System.out.println("first_name from JSON Response Array-->"+first_name);
		Assert.assertEquals(first_name, "Emma");

		// All Headers
		Header[] headerArray = closeablehttpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();
		for (Header header : headerArray) {
			allheaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers Array-->" + allheaders);

	}

	
	@Test(priority = 2)
	public void getApiTestwithHeaders() throws ClientProtocolException, IOException {
		restclient = new RestClient_1();
		
		HashMap<String, String> headerMap=new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		closeablehttpresponse=restclient.get(url, headerMap);
		// Status Code--> get status code from statusline
		int statusCode = closeablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("The Status Code is -->" + statusCode);
		
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status Code is not 200");

		// Response Body
		// response string
		String responseString = EntityUtils.toString(closeablehttpresponse.getEntity(), "UTF-8");
		System.out.println("response String is -->" + responseString);

		// response json
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("response Json from API is -->" + responseJson);
		
		//Validating JSON Response object
		String perPageValue=TestUtil.getValueByJpath(responseJson,"/per_page");
		System.out.println("Per Page value from JSON Response Object-->"+perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		
		String totalValue=TestUtil.getValueByJpath(responseJson,"/total");
		System.out.println("Total value from JSON Response Object-->"+totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		//Validating JSON Response Array
		String first_name=TestUtil.getValueByJpath(responseJson,"/data[2]/first_name");
		System.out.println("first_name from JSON Response Array-->"+first_name);
		Assert.assertEquals(first_name, "Emma");

		// All Headers
		Header[] headerArray = closeablehttpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();
		for (Header header : headerArray) {
			allheaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers Array-->" + allheaders);

	}

}
