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

import come.qa.client.MaverickRestClient;


public class MaverickGetApiTest extends TestBase {
	public MaverickGetApiTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	TestBase testbase;
	String serviceurl;
	String apiurl;
	String url;
	MaverickRestClient restclient;
	CloseableHttpResponse closeablehttpresponse;
	String AuthToken;
	//String token ="eyJhbGciOiJSUzUxMiJ9.eyJpc3MiOiJodHRwczovL21hdmVyaWNrLmRldiIsImlhdCI6MTY4NDc1NDc4NywianRpIjoiMSIsImV4cCI6MTY4NDc1ODM4Nywic3ViIjoiYjIxMGIyUnJZWEk9In0.IPf3keMGpjzIVe-YBA1uPuHZDh7eOIbMnEtkuF8FZRN4j8iFWJAy1QwRIq2YAjmd30S0wKRT8WGw5FTZ4LpSwAwztXHxNsqbPAeNQdhrpI_tN9pvG0TvfWKgPe9VBAXR71DkmJRLn7QCsZr2h_HLDhFHvpMtFs3k7x7nXNkKlFPEpv9qzkmkhfrno32xF_oSmclyoHyp5AL07i6nJg2QjPwFD85D1ouybQOOTQTHbE9S5npI2oDPG-mefmfuIyf_IrkP0OGB6Rqx1jsaNFF4etyPqX8UQaHAFhsuM_uQXKjTnxf6GOj023Xp8kP_ZGmYv0x4hsc-5LkOPXPk0UNdTuhe6m579YRM2K6qZJln6wmaXvJWrmPCqvl4UpuEXK1xgJTpciCjd175yu0LD7xKK1NSr3R6Ss9koTQ3SbhMFOzCJ-_46yOERoQKdfIx_9IOU2_fBRAloUixXWUU0i0uWxDAokxX-LRjGVV47ASCO_5WBG7vQ3qoZmAR-_jjbH3FECaqGcZJtxlj1GCHawJH1pn-cmJ2lkkv30CTvAatSRcca9J7hHOeGCcl8biMjkPRs0Ll7xlnbb_jHNrEPR3hNzaRTUu0tA-joPB04bP8NmMcl3T77NJddHEy_dCgjEdQGJbofFLjc-YYadX5ml6eeudJctlGBGFYn-8X_PduYkw";

	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testbase = new TestBase();
		serviceurl = prop.getProperty("ServiceURL1");
		apiurl = prop.getProperty("APIURL1");
		url = serviceurl + apiurl;
		//String token ="eyJhbGciOiJSUzUxMiJ9.eyJpc3MiOiJodHRwczovL21hdmVyaWNrLmRldiIsImlhdCI6MTY4NDc2MzI3OCwianRpIjoiMSIsImV4cCI6MTY4NDc2Njg3OCwic3ViIjoiYjIxMGIyUnJZWEk9In0.VVk98W6qIA56gWbFJ4nUlhHAAnFsAhRIpYvAolh8D2MifvT7y7qfqM32UM2WB4yzGAdDKa19znphcTW0W4SAqWf6rheLT9R1Qyp8w-tOG8Juo7XLr1HTAKQGmnEqU4RDBSoXabtYB_ouGXTtDRJDlE9Pzegw4mVTiN0mtqztYbTlZhhCjh9WgFmFWFlZDe6qSJCCus5h2BIFcxobBloK89ejuGfnYYlychUlLrmb4xcmY9bidz9tJLBYZMV-zGlHaJqqNalzPfEhUhYnpskIimuvNxnN4ufDG1Fu_HHrdaOFg9nzTWmdB4t9dvW9icpkVzjZPJt5hx7sAf_t0VdWEuxXeyH4NCVMflW5KLQmIpkem-_7opi8Ql7pY10dJtsDYnwFZqRt_sXINhoONbzv3v3svMOPQf59UUh2IQ87HgXGhVKdrUS37pieisV8pS9USsEGY6hqbXVkvxPke2eImm0rvuuoVaEwnbp-mXPkXYWW-0Xjhvt_yKhROISeqay1bPB__uO_w9qgMAGn0YeB7S-TRXArpJhc_CIFebtgyUmItpzNwpa75tz2EeP8c9cHYUdvnb_qoaqLnrB4fn_oBZ5nqS8Ve4ozkxE96pp3aB99VGok9pSeeZs3rsrUn9Zqz6uy2w7a8XV5HpTf1Ao_YsSkf7I-jxjwE471w7b5Y1k";

	}	
	
	@Test
	public void getApiTestwithHeaders() throws ClientProtocolException, IOException {
		restclient = new MaverickRestClient();
		String token="eyJhbGciOiJSUzUxMiJ9.eyJpc3MiOiJodHRwczovL21hdmVyaWNrLmRldiIsImlhdCI6MTY4NDc2MzI3OCwianRpIjoiMSIsImV4cCI6MTY4NDc2Njg3OCwic3ViIjoiYjIxMGIyUnJZWEk9In0.VVk98W6qIA56gWbFJ4nUlhHAAnFsAhRIpYvAolh8D2MifvT7y7qfqM32UM2WB4yzGAdDKa19znphcTW0W4SAqWf6rheLT9R1Qyp8w-tOG8Juo7XLr1HTAKQGmnEqU4RDBSoXabtYB_ouGXTtDRJDlE9Pzegw4mVTiN0mtqztYbTlZhhCjh9WgFmFWFlZDe6qSJCCus5h2BIFcxobBloK89ejuGfnYYlychUlLrmb4xcmY9bidz9tJLBYZMV-zGlHaJqqNalzPfEhUhYnpskIimuvNxnN4ufDG1Fu_HHrdaOFg9nzTWmdB4t9dvW9icpkVzjZPJt5hx7sAf_t0VdWEuxXeyH4NCVMflW5KLQmIpkem-_7opi8Ql7pY10dJtsDYnwFZqRt_sXINhoONbzv3v3svMOPQf59UUh2IQ87HgXGhVKdrUS37pieisV8pS9USsEGY6hqbXVkvxPke2eImm0rvuuoVaEwnbp-mXPkXYWW-0Xjhvt_yKhROISeqay1bPB__uO_w9qgMAGn0YeB7S-TRXArpJhc_CIFebtgyUmItpzNwpa75tz2EeP8c9cHYUdvnb_qoaqLnrB4fn_oBZ5nqS8Ve4ozkxE96pp3aB99VGok9pSeeZs3rsrUn9Zqz6uy2w7a8XV5HpTf1Ao_YsSkf7I-jxjwE471w7b5Y1k";
		HashMap<String, String> headerMap=new HashMap<String, String>();
		headerMap.put("Accept", "application/json");
		headerMap.put("Authorization", "Bearer " + token);
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
		String status=TestUtil.getValueByJpath(responseJson,"/status");
		System.out.println("Status value from JSON Response Object-->"+status);
		Assert.assertEquals(status, "SUCCESS");
		
				
		//Validating JSON Response Array
		String first_name=TestUtil.getValueByJpath(responseJson,"/result/firstName");
		System.out.println("first_name from JSON Response Array-->"+first_name);
		Assert.assertEquals(first_name, "Omkar");

		// All Headers
		Header[] headerArray = closeablehttpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();
		for (Header header : headerArray) {
			allheaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers Array-->" + allheaders);

	}

}



