package com.girnarsoft.customercomplaintsystem.dto;

import java.sql.Date;

public class CustomerDetails {
  private int complaintId;
  private String customerName;
  private String mobileNumber;
  private String email;
  private String comments;
  private Date date;

public CustomerDetails(String mobileNumber, String customerName, String email, String comments, Date date ,int complaintId) {

	this.mobileNumber = mobileNumber;
	this.customerName = customerName;
	this.email = email;
	this.comments = comments;
	this.date = date;
	this.complaintId=complaintId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getComplaintId() {
	return complaintId;
}
public void setComplaintId(int complaintId) {
	this.complaintId = complaintId;
}
}
