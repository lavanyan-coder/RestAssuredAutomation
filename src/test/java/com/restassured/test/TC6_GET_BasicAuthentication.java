package com.restassured.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC6_GET_BasicAuthentication {
	@Test
	public void basicAuthenticatoin() {
		
		RestAssured.baseURI = " ";
		
		//basic authentication
		PreemptiveBasicAuthScheme  authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("username");
		authScheme.setPassword("pwd");
		RestAssured.authentication = authScheme;
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/");
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
	}

}
