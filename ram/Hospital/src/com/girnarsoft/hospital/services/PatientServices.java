package com.girnarsoft.hospital.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.girnarsoft.hospital.dto.PatientDetails;
import com.girnarsoft.hospital.files.FileProcess;
/**
 * through this class PatientServices we perform operatins for add,update,delete
 * 
 * @author jairam
 *
 */

public class PatientServices {

    private	Validation validation;
    private	FileProcess fileprocess;
	private int patientID;
	private HashMap<Integer, PatientDetails> patientMap = new HashMap<>();
	Scanner scanner;
	Pattern p;
	Matcher match;
	public PatientServices() {
		validation=new Validation();
		fileprocess = new FileProcess();
		scanner = new Scanner(System.in);
	}
	
	/**
	 * through this method we can add patientdetails into hashmap
	 * 
	 * @param patientID
	 */
	public void addPatient(int patientID, PatientServices patientServices) {

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
			mobileNumber = validation.getPhoneNumberAftervalidation(patientServices);
			age = Integer.parseInt(validation.getAgeAftervalidation());
			System.out.println("Please Enter disease");
			disease = validation.getAfterValidation();
			date = validation.getDate();
			System.out.println();
			patientID = getPatientMap().size() + 1;
			PatientDetails patientdetails = new PatientDetails(name, mobileNumber, age, disease, date);
			getPatientMap().put(patientID, patientdetails);
			System.out.println("PatientId:" + patientID);
			System.out.println("PatientName:" + patientdetails.getName() + "\nPatient MobileNumber"
					+ patientdetails.getMobilenumber() + "\nPatient Age:" + patientdetails.getAge() + "\nAdmissionDate:"
					+ patientdetails.getDate() + "\npatientdisease:" + patientdetails.getDisease());

		} else
			System.out.println("Thank for Visiting Our Hospital");

	}

	/**
	 * through this method we can update patientdetails
	 * 
	 * @param patientID
	 */

	public void update(int patientID,PatientServices patientServices) {
       while(true) {
		System.out.println("Please  enter your choice \n1.Name\n2.Mobile number \n3.age\n4.Do you wish to goto main menu ");
		PatientDetails patient = getPatientMap().get(patientID);
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			Outer: while (true) {
				System.out.println("please enter rename");
				String rename = validation.getAfterValidation();
				if (getPatientMap().containsKey(patientID)) {
					if (!(rename.equals(patient.getName()))) {
						patient.setName(rename);
						System.out.println("Name Updated");
						break;
					} else {
						System.out.println("your entering same name ");
						continue Outer;
					}
				} else {
					System.out.println("Sorry with this ID thier was no patient");
					break;

				}
			}
			break;
		case "2":
			Outer: while (true) {
				//System.out.println("please enter mobilenumber");
				String mobilenumber = validation.getPhoneNumberAftervalidation(patientServices);
				if (getPatientMap().containsKey(patientID)) {
					if (!(mobilenumber.equals(patient.getMobilenumber()))) {
						patient.setMobilenumber(mobilenumber);
						System.out.println("mobilenumber Updated");
						break;
					} else {
						System.out.println("your entering same mobilenumber ");
						continue Outer;
					}
				} else {
					System.out.println("Sorry with this ID thier was no patient");
					return;
				}
			}
			break;

		case "3":
			Outer: while (true) {
				//System.out.println("please enter Age");
				String age = validation.getAgeAftervalidation();
				int ageInInt = Integer.parseInt(age);
				if (getPatientMap().containsKey(patientID)) {
					if (ageInInt != patient.getAge()) {
						patient.setAge(ageInInt);
						System.out.println("Age Updated");
						break;
					} else {
						System.out.println("your entering same Age ");
						continue Outer;
					}
				} else {
					System.out.println("Sorry with this ID thier was no patient");
					return;
				}
			}
			break;
	  case "4":return;
	  default:System.out.println("Oops! your entering wrong input");
		 }
       }
	}

	/**
	 * through this method we can delete patientdetails it will also remove from
	 * the file
	 */
	public void deletePatient() {
		System.out.println("Sir,could tell us your patientID please");
		int patientID = scanner.nextInt();
		if (getPatientMap().containsKey(patientID)) {
			PatientDetails patient = getPatientMap().remove(patientID);
			System.out.println("PatientName:" + patient.getName() + " |deleted");
		}
	}

	/**
	 * through this method we can add patientdetails list
	 */
	public void showPatientList() {

		for (Map.Entry<Integer, PatientDetails> patientEntry : getPatientMap().entrySet()) {
			System.out.println(
					"PatientID:" + patientEntry.getKey() + "||PatientName:" + patientEntry.getValue().getName()+"||Patient MobileNumber:"
					+patientEntry.getValue().getMobilenumber()+"||Patient Age:"+patientEntry.getValue().getAge()+"||Patient Disease:"+patientEntry.getValue().getDisease()
					+"||Admission Date:"+patientEntry.getValue().getDate());
		}

	}

	/**
	 * through this method we can get old patient details
	 * 
	 * @return patientID
	 */
	public int start() {

		fileprocess.readPatientDataFromFile();
		getPatientMap().putAll(fileprocess.getPatientMap1());
		patientID = getPatientMap().size();
		if (patientID == 0)
			return 1;
		else
			return patientID;
	}

	public HashMap<Integer, PatientDetails> getPatientMap() {
		return patientMap;
	}

	public void setPatientMap(HashMap<Integer, PatientDetails> patientMap) {
		this.patientMap = patientMap;
	}

	public void exit(PatientServices patientServices) {
        
		fileprocess.writeDataIntofile(patientServices);

	}

}
