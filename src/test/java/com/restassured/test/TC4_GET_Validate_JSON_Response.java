package com.restassured.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC4_GET_Validate_JSON_Response {
	
	@Test
	public void validate_json() {
		//specify URI
				RestAssured.baseURI = "https://reqres.in";
				
				//request object
				RequestSpecification httpRequest = RestAssured.given();
				
				//response object
				Response response = httpRequest.request(Method.GET, "/api/users/2");
				
				//response body.should convert response to string to get this
				String responseBody = response.getBody().asString();
				
				
				System.out.println("The response body received is: "+responseBody);
				Assert.assertEquals(responseBody.contains("Janet_9"),true);
	}

}
