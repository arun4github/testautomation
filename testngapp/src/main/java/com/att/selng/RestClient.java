package com.att.selng;

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

public class RestClient {
	
	
	public CloseableHttpResponse  getRequest(String endpointUrl) throws ClientProtocolException, IOException
	{
		CloseableHttpClient cClient=HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(endpointUrl); 
		CloseableHttpResponse cResponse=cClient.execute(httpGet);
		return cResponse;
	}
	
	public CloseableHttpResponse postRequest(String endpointUrl,String entityString,HashMap<String,String> headerValues) throws ClientProtocolException, IOException
	{
		CloseableHttpClient cClient=HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(endpointUrl); 
		httpPost.setEntity(new StringEntity(entityString));
		for(Map.Entry<String, String> entry:headerValues.entrySet())
		{
			httpPost.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse cPResponse=cClient.execute(httpPost);
		return cPResponse;
	}

}
