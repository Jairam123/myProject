package com.girnarsoft.hospital.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.girnarsoft.hospital.dto.PatientDetails;

/**
 * through this class Validation we are validating strings
 * name,mobilenumber,age,date,disease
 * 
 * @author Jairam
 *
 */

public class Validation {
	Scanner scanner = new Scanner(System.in);
	private final String nameExpression = "[a-zA-z]+";
	private final String nameExpression2 = "[a-zA-z]+ [a-zA-z]+";
	private final String phoneNumberExpression = "[0-9]{10}";
	private final String ageExpression = "[0-9]{2}";
	private final String dataExp = "[0-9]{1}";
	Pattern p;
	Matcher match;

	/**
	 * through this method we are validating name string
	 * 
	 * @return name
	 */
	public String getAfterValidation() {
		String name;
		Outer: while (true) {
			name = scanner.nextLine();
			p = Pattern.compile(nameExpression2);
			match = p.matcher(name);
			if (match.matches()) {
				return name;
			} else if (Pattern.compile(nameExpression).matcher(name).matches())
				return name;
			else
				System.out.println("Sorry your entering wrong input please enter again:");
			continue Outer;
		}
	}

	/**
	 * through this method we validating string phonenumber
	 * 
	 * @return phonenumber
	 */
	public String getPhoneNumberAftervalidation(PatientServices patientServices) {
		String phonenumber;
		Outer: while (true) {
			System.out.println("Please enter phoneNumber:");
			phonenumber = scanner.nextLine();
			p = Pattern.compile(phoneNumberExpression);
			match = p.matcher(phonenumber);

			if (match.matches()) {

				if (patientServices.getPatientMap().size() == 2) {
					for (Map.Entry<Integer, PatientDetails> map : patientServices.getPatientMap().entrySet()) {

						if (!(phonenumber.equalsIgnoreCase(map.getValue().getMobilenumber()))) {
							return phonenumber;
						} else {
							System.out.println("With this phone number patient already exist ");
							continue Outer;
						}
					}
				} else {
					return phonenumber;
				}
			} else {
				System.out.println("Sorry your entering wrong input");
				continue Outer;
			}

		}
	}

	/**
	 * through this method we validating integer age
	 * 
	 * @return age
	 */
	public String getAgeAftervalidation() {
		String age;
		Outer: while (true) {
			System.out.println("Please enter age:");
			age = scanner.nextLine();
			p = Pattern.compile(ageExpression);
			match = p.matcher(age);
			if (match.matches()) {
				return age;
			} else {
				System.out.println("your giving wrong input");
				continue Outer;
			}
		}
	}

	/**
	 * through this method we validating date
	 * 
	 * @return date
	 */
	public Date getDate() {

		Date admissionDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		dateFormat.format(admissionDate);
		System.out.println("Date:" + admissionDate.toString());
		return admissionDate;
	}

	public String getDataAftervalidation() 
	{
	        while (true) {
		    System.out.println("sir your patientID please");
		    String data =scanner.nextLine();
			p = Pattern.compile(dataExp);
			match = p.matcher(data);
			if (match.matches()) {
				return data;
			} else {
				System.out.println("Oops! your entering wrong input");
				continue;
			}
				
			
		}
	}

}
