package com.girnarsoft.hospital1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * through this class PatientServices we perform operatins for add,update,delete
 * 
 * @author jairam
 *
 */

public class PatientServices {

    private	Validation validation;
	private int patientID;
	private int doctorID;
	private Dao dao;
	private HashMap<Integer, PatientDetails> patientMap = new HashMap<>();
	Scanner scanner;
	Pattern p;
	Matcher match;
	public PatientServices() {
		validation=new Validation();
		dao=new Dao();
		scanner = new Scanner(System.in);
	}
	
	/**
	 * through this method we can add patientdetails into hashmap
	 * 
	 * @param patientID
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void addPatient() throws ClassNotFoundException, SQLException {

		String name;
		String mobileNumber;
		int age;
		Date date;
		String disease;
		String input = "yes";
		System.out.println("=======================================");
		System.out.println("You need to pay registration fee 200");
		System.out.println("Do you wish to continue say yes");
		System.out.println("=======================================");
		String output = scanner.nextLine();
		if (output.equals(input)) {
			System.out.println("Please enter name:");
			name = validation.getAfterValidation();
			mobileNumber = validation.getPhoneNumberAftervalidation();
			age = Integer.parseInt(validation.getAgeAftervalidation());
			System.out.println("Please Enter disease");
			disease = validation.getAfterValidation();
			date = validation.getDate();
			System.out.println();
			patientID = getPatientMap().size() + 1;
			PatientDetails patientdetails = new PatientDetails(name, mobileNumber, age, disease, date);
	       dao.addPatientDetailsIntoDataBase(patientdetails);
		} else
			System.out.println("Thank for Visiting Our Hospital");

	}

	/**
	 * through this method we can update patientdetails
	 * 
	 * @param patientID
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */

	public void update(int patientID,PatientServices patientServices) throws ClassNotFoundException, SQLException {
       while(true) {
		System.out.println(HospitalConstants.MENU_CHOICE);
		System.out.println(HospitalConstants.MENU_LIST1);
		PatientDetails patient = getPatientMap().get(patientID);
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			    System.out.println(HospitalConstants.PLEASE_ENTER_NAME);
				String rename = validation.getAfterValidation();
				dao.updatePatientName(patientID,rename);
				System.out.println("name update");
       			break;
		case "2":
				String mobilenumber = validation.getPhoneNumberAftervalidation();
				dao.updatePatientNumber(patientID, mobilenumber);
				break;

		case "3":
				String age = validation.getAgeAftervalidation();
				int ageInInt = Integer.parseInt(age);
				dao.updatePatientAge(patientID, ageInInt);
      			break;
	  case "4":return;
	  default:System.out.println(HospitalConstants.WRONG_CHOICE);
		 }
       }
	}

	/**
	 * through this method we can delete patientdetails it will also remove from
	 * the file
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void deletePatient() throws ClassNotFoundException, SQLException {
		System.out.println(HospitalConstants.SIR_YOUR_PATIENT_ID_PLEASE);
		int patientID = scanner.nextInt();
		dao.toDeletePatient(patientID);
		
	}

	/**
	 * through this method we can known about patient lists
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void showPatientList()  {

		try{
		
		ResultSet resultSet = dao.showPatientListFromDb();
		while(resultSet.next()){
		System.out.println("PatientId:"+resultSet.getInt("id"));
		System.out.println("Name:"+resultSet.getString("name"));
		System.out.println("mobileNumber:"+resultSet.getString("mobilenumber"));
		System.out.println("AdmissionDate:"+resultSet.getString("admission_date"));
		System.out.println("Age:"+resultSet.getInt("age"));
		System.out.println("Disease:"+resultSet.getString("disease"));
		
		
		}
	}catch(Exception e){System.out.println("data processing is down");}
}

	/**
	 * through this method we can get old patient details
	 * 
	 * @return patientID
	 */
	/*public int start() {

		fileprocess.readPatientDataFromFile();
		getPatientMap().putAll(fileprocess.getPatientMap1());
		patientID = getPatientMap().size();
		if (patientID == 0)
			return 1;
		else
			return patientID;
	}*/

	public HashMap<Integer, PatientDetails> getPatientMap() {
		return patientMap;
	}

	public void setPatientMap(HashMap<Integer, PatientDetails> patientMap) {
		this.patientMap = patientMap;
	}

	/*public void exit(PatientServices patientServices) {
        
		fileprocess.writeDataIntofile(patientServices);

	}*/

}
