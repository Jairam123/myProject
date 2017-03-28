package com.girnarsoft.hospital1;

public class HospitalConstants 
{

	public static final String DATE_FORMAT = "YYYY-MM-DD HH:MM:SS";
	public static final String INSERT_INTO_PATIENTDETAILS_VALUES = "INSERT INTO patient_details VALUES(?,?,?,?,?,?,?)";
	public static final String GET_SPECIFIC_ID_PATIENTDETAILS = "SELECT id,name,mobilenumber,admission_date,disease,age FROM patient_details where id=?";
	public static final String GET_PATIENTDETAILS = "SELECT id,name,mobilenumber,admission_date,disease,age,last_visit FROM patient_details";
	public static final String DELETE_PATIENTDETAILS = "DELETE FROM patient_details WHERE ID=?";
	public static final String UPDATE_AGE = "UPDATE patient_details SET age=? WHERE id=?";
	public static final String UPDATE_MOBILENUMBER = "UPDATE patient_details SET mobilenumber=? WHERE id=?";
	public static final String OOPS_YOUR_ENTERING_WRONG_ID = "Oops! your entering wrong ID";
	public static final String SIR_YOUR_PATIENT_ID_PLEASE = "sir your patientID please";
	public static final String OOPS_YOUR_ENTERING_WRONG_AGE = "Oops! your entering wrong age";
	public static final String PLEASE_ENTER_AGE = "Please enter age:";
	public static final String OOPS_YOUR_ENTERING_WRONG_MOBILE_NUMBER = "Oops!your entering wrong mobile number";
	public static final String PLEASE_ENTER_PHONE_NUMBER = "Please enter phoneNumber:";
	public static final String UPDATE_NAME = "UPDATE patient_details SET name=? WHERE id=?";
	public static final String SORRY_YOUR_ENTERING_WRONG_INPUT_PLEASE_ENTER_AGAIN = "Sorry your entering wrong input please enter again:";
	public static final String UNDER_LINE = "=======================================";
	public static final String WELCOME_MSG = "Welcome to Receptionist Client Service";
	public static final String MENU_CHOICE = "Please press your Choice:";
	public static final String MENU_LIST = "1.Add Patient\n2.Update \n3.Delete\n4.ShowPatientList\n5.ShowDoctorList\n6.Assingdoctor\n7.Exit";
	public static final String WITH_THIS_ID_THIER_WAS_NO_PATIENT = "with this id thier was no patient";
	public static final String PLEASE_ENTER_NAME = "please enter name";
    public static final String WRONG_CHOICE = "Oops! your entering wrong choice";
	public static final String MENU_LIST1 = "1.Name\n2.Mobile number \n3.age\n4.Do you wish to goto main menu ";
	public static final String USER_NAME = "root";
	public static final String USER_PASSWORD = "root";
	public static final String JDBC_URL = "jdbc:mysql://localhost/hospitalmanagement";
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		
}
