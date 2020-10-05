package com.restassured.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC1_GET_Request {
	
	
	@Test
	public void getWeatherDetails() {
		
		//specify URI
		RestAssured.baseURI = "https://reqres.in";
		
		//request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//response object
		Response response = httpRequest.request(Method.GET, "/api/users");
		
		//response body.should convert response to string to get this
		String responseBody = response.getBody().asString();
		
		
		System.out.println("The response body received is: "+responseBody);
		
		//status code
		
		int statusCode = response.getStatusCode();
		System.out.println("The status code is: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//status line
	String statusLine = response.getStatusLine();
	System.out.println("The status line is: "+statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
