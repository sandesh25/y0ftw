package com.system.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpMethod;

import com.system.constants.ApplicationConstants;

public class ServiceCallerRest {
	private final static ServiceCallerRest instance = new ServiceCallerRest();

	public ServiceCallerRest() {}

	public String makePostServiceCall(String serviceURI, List<NameValuePair> urlParameters) {
		CloseableHttpClient httpClient = null;
		try {
			httpClient = HttpClientBuilder.create().build();
			HttpPost httpPostRequest = new HttpPost(ApplicationConstants.SERVICE_URL + serviceURI);
			httpPostRequest.setEntity(new UrlEncodedFormEntity(urlParameters));
			HttpResponse response = httpClient.execute(httpPostRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			StringBuilder output = new StringBuilder();
			String line;
			System.out.println("Output from Server .... \n");
			while ((line = br.readLine()) != null) {
				output.append(line);
			}
			System.out.println("Response====== " + output.toString());
			httpClient.close();
			return output.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				httpClient.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String makePostServiceCall(String serviceURI, String content) {
		CloseableHttpClient httpClient = null;
		try {
			httpClient = HttpClientBuilder.create().build();
			HttpPost httpPostRequest = new HttpPost(ApplicationConstants.SERVICE_URL + serviceURI);
			httpPostRequest.setEntity(new StringEntity(content, ContentType.APPLICATION_JSON));
			HttpResponse response = httpClient.execute(httpPostRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			httpClient.close();
			return br.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				httpClient.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String makeGetServiceCall(String serviceURI, HttpMethod methodType) {
		CloseableHttpClient httpClient = null;
		try {
			httpClient = HttpClientBuilder.create().build();
			HttpGet httpGEtRequest = new HttpGet(ApplicationConstants.SERVICE_URL + serviceURI);
			httpGEtRequest.addHeader("accept", ContentType.APPLICATION_JSON.toString());
			HttpResponse response = httpClient.execute(httpGEtRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			httpClient.close();
			return br.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				httpClient.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static ServiceCallerRest getInstance() {
		return instance;
	}
}