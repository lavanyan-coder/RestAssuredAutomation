package com.restassured.utils;

import java.util.ArrayList;

import com.restassured.utils.Xls_Reader;

public class GetExcelData {

	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try 
		{
		reader = new Xls_Reader("C:\\Users\\DELL\\eclipse-workspace\\RestAssuredAutomation\\src"
				+ "\\test\\java\\com\\restassured\\data\\restassured_employee_data.xlsx");
		
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		for(int rowNum = 2; rowNum<=reader.getRowCount("Sheet1");rowNum++)
		{
			String empName = reader.getCellData("Sheet1", "Emp_Name", rowNum);
			String Salary = reader.getCellData("Sheet1", "Salary", rowNum);
			String age= reader.getCellData("Sheet1", "Age", rowNum);
			Object [] ob = {empName,Salary,age};
			myData.add(ob) ;
		}
		
	return myData;
	}
	
}
