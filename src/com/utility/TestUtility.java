package com.utility;

import java.util.ArrayList;

import lib.ExcelDataConfig;

public class TestUtility {
	static ExcelDataConfig reader;
	
	public static ArrayList<Object[]> getDataEcel(){
		ArrayList<Object[]>myData = new ArrayList<Object[]>();
	
	try {
		reader = new ExcelDataConfig("D:\\Selenium\\FrameworkPractice\\DataDrivenFrameWork\\testData\\testData.xlsx");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	for(int rowNum=2;rowNum<=reader.getRowCount("RegistrationData");rowNum++)
	{
		String firstName = reader.getCellData("RegistrationData", "firstname", rowNum);
		System.out.println(firstName);
		String lastName = reader.getCellData("RegistrationData", "lastname", rowNum);
		System.out.println(lastName);
		String address1 = reader.getCellData("RegistrationData", "address1", rowNum);
		System.out.println(address1);
		String address2 = reader.getCellData("RegistrationData", "address2", rowNum);
		System.out.println(address2);
		String city = reader.getCellData("RegistrationData", "city", rowNum);
		System.out.println(city);
		String state = reader.getCellData("RegistrationData", "state", rowNum);
		System.out.println(state);
		String postalcode = reader.getCellData("RegistrationData", "postalcode", rowNum);
		System.out.println(postalcode);
		String email = reader.getCellData("RegistrationData", "email", rowNum);
		System.out.println(email);
		 Object ob[]  = {firstName,lastName,address1,address2,city,state,postalcode,email};
		
		myData.add(ob);
	}
	return myData;

}
}
