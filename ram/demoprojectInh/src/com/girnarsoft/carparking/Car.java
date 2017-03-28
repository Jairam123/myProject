package com.girnarsoft.carparking;

public class Car {
	
	String name ;
	
	String number;
	


	public Car(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public StringBuilder validateCar()
	{
		StringBuilder errorMsg = new StringBuilder();
		if(this.getName() == null || this.getName().equals(""))
		{
			errorMsg.append("Please enter valid car name \n");
		}
		
		if(this.getNumber() == null || this.equals("") ||  this.getNumber().length() != 4)
		{
			errorMsg.append("Please enter valid four digit  car number \n");
		}
		return errorMsg;
	}
	
}
