package com.restassured.datadriven;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restassured.utils.GetExcelData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DDD_add_new_employees {
	@Test(dataProvider="getTestData")
	public void add_new_employees(String empName,String salary,String age)
	
	{
		
		//specify uri
				RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
				RequestSpecification httpRequest = RestAssured.given();
				
				
				//create json payload
				JSONObject requestParams = new JSONObject();
				
				requestParams.put("name", empName);
				requestParams.put("salary", salary);
				requestParams.put("age", age);
				
				//attach header
				httpRequest.header("Content-Type", "application/json");
				
				//attach data to request
				httpRequest.body(requestParams.toJSONString());
				
				//create post request
				Response response = httpRequest.request(Method.POST,"/create");
				
				//response body.should convert response to string to get this
				String responseBody = response.getBody().asString();
						
						
				System.out.println("The response body received is: "+responseBody);
		
	}

	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = GetExcelData.getDataFromExcel();
	Iterator<Object[]>	it = testData.iterator();
		return it;
	}
}
