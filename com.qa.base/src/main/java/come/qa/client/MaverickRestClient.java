package come.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class MaverickRestClient {
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException
	{
		//create client obj
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		//Create Httpget obj with the url to be hit
		HttpGet httpget= new HttpGet(url);
		
		//Create response obj and use execute method on client obj with get obj
		CloseableHttpResponse closeablehttpresponse= httpclient.execute(httpget);
		return closeablehttpresponse;

	}
	
	// GET with Headers
	public CloseableHttpResponse get(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException
	{
		//create client obj
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		//Create Httpget obj with the url to be hit
		HttpGet httpget= new HttpGet(url);
		
		for(Map.Entry<String, String> entry:headerMap.entrySet()) {
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		
		//Create response obj and use execute method on client obj with get obj
		CloseableHttpResponse closeablehttpresponse= httpclient.execute(httpget);
		return closeablehttpresponse;

	}
	
	//POST method
	public CloseableHttpResponse post(String url,String entityString,HashMap<String, String> headerMap) throws ClientProtocolException, IOException
	{
		//create client obj
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		//Create Httppost obj with the url to be hit
		HttpPost httppost= new HttpPost(url);
		
		//set the payload entity
		httppost.setEntity(new StringEntity(entityString));
		
		//for adding headers
		for(Map.Entry<String, String> entry:headerMap.entrySet()) {
			httppost.addHeader(entry.getKey(), entry.getValue());
		}
		
		
		
		//Create response obj and use execute method on client obj with get obj
		CloseableHttpResponse closeablehttpresponse= httpclient.execute(httppost);
		return closeablehttpresponse;

	}
	
	
}



