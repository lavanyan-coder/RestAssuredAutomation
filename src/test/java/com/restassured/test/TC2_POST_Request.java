package com.restassured.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC2_POST_Request {
	@Test
	public void postRequest() {
		//specify uri
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		
		
		//create json payload
		JSONObject requestParams = new JSONObject();
		requestParams.put("name:", "Sachin");
		requestParams.put("job:", "Captain");
		
		//attach header
		httpRequest.header("Content-Type", "application/json");
		
		//attach data to request
		httpRequest.body(requestParams.toJSONString());
		
		//create post request
		Response response = httpRequest.request(Method.POST,"/api/users");
		
		//response body.should convert response to string to get this
		String responseBody = response.getBody().asString();
				
				
		System.out.println("The response body received is: "+responseBody);
				
		//status code
				
		int statusCode = response.getStatusCode();
		System.out.println("The status code is: "+statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//id code
	String id =	response.jsonPath().get("id");
	System.out.println("The id created is: "+id);
		
	int id_int = response.jsonPath().getInt("id");
	System.out.println("The id created is: "+id_int);
		
	}

}
