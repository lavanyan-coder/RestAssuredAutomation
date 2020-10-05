package com.restassured.test;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC3_GET_Request {
	
	@Test
	public void getDetails() {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		
	Response response =	httpRequest.request(Method.GET, "/api/users/2");
	String responseBody = response.getBody().asString();
	System.out.println("The response body is :"+responseBody);
	
	//capture details of headers from response
String responseHeader =	response.header("Content-Type");
System.out.println("The header is : "+responseHeader);
	
	//get list of headers and values --- Method_1
	List<Header> headers =	response.getHeaders().asList();
	HashMap<String,String> allHeaders = new HashMap<String,String>();
	for(int i=0;i<headers.size();i++) {
		allHeaders.put(headers.get(i).getName(), headers.get(i).getValue());
		
	}
	
	System.out.println("The header count is : "+headers.size());
	System.out.println("The list of all headers is : "+allHeaders+" "+"\n");
	
	//get list of headers and values --- Method_2
	Headers allHeaders_1 =	response.headers();
	System.out.println("the header count is: "+allHeaders_1.size());
	
	for(Header headers_1:allHeaders_1)
	{
		
		System.out.println(headers_1.getName()+"------->"+headers_1.getValue());
	}
	
	}
	
	

}
