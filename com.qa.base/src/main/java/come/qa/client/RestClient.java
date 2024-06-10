package come.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	//GET Method
	public void get(String url) throws ClientProtocolException, IOException
	{
		//create client obj
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		//Create Httpget obj with the url to be hit
		HttpGet httpget= new HttpGet(url);
		
		//Create response obj and use execute method on client obj with get obj
		CloseableHttpResponse closeablehttpresponse= httpclient.execute(httpget);
		
		//Status Code--> get status code from statusline
		int statusCode=closeablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("The Status Code is -->"+statusCode);
		
		//Response Body
		//response string
		String responseString=EntityUtils.toString(closeablehttpresponse.getEntity(),"UTF-8");
		System.out.println("response String is -->"+responseString);
		
		//response json 
		JSONObject responseJson=new JSONObject(responseString);
		System.out.println("response Json from API is -->"+responseJson);
		
		//All Headers
		Header[] headerArray=closeablehttpresponse.getAllHeaders();
		HashMap<String, String> allheaders=new HashMap<String, String>();
		for(Header header:headerArray)
		{
			allheaders.put(header.getName(),header.getValue());
		}
		System.out.println("Headers Array-->"+allheaders);
		
		
	}

}
