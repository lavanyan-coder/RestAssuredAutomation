package com.restassured.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC5_GET_Validate_JSON_BODY_Response {
	
	@Test
	public void get_validate_json_body()
	{
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/api/users");
	
		String responseBody =	response.getBody().asString();
		System.out.println("The response body received is: "+responseBody);
		
		
		
	JsonPath json_path =	response.jsonPath();
	System.out.println(json_path.get("email"));
	
	System.out.println(json_path.get("data"));
	}

}
