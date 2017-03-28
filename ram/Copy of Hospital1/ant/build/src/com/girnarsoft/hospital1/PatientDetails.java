package com.girnarsoft.hospital1;


import java.util.Date;
/**
 * Through this class PatientDetails we are created class with patientdetails  that was used assign values to patientdetails 
 * @author Jairam
 *
 */
public class PatientDetails {
	private String name;
	private String mobilenumber;
	private int age;
	private Date date;
	private String disease;
	public PatientDetails(String name ,String mobilenumber, int age ,String disease,Date date){
		this.setName(name);
		this.setMobilenumber(mobilenumber);
		this.setAge(age);
		this.setDate(date);
		this.setDisease(disease);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	

}
