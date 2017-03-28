package com.girnarsoft.hospital1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * through this class Validation we are validating strings
 * name,mobilenumber,age,date,disease
 * @author Jairam
 *
 */

public class Validation {
	
	Scanner scanner = new Scanner(System.in);
	private final String nameExpression = "[a-zA-z]+";
	private final String nameExpression2 = "[a-zA-z]+ [a-zA-z]+";
	private final String phoneNumberExpression = "[0-9]{10}";
	private final String ageExpression = "[0-9]{2}";
	private final String dataExp = "\\d+";
	Pattern p;
	Matcher match;
	/**
	 * through this method we are validating name string
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
				System.out.println(HospitalConstants.SORRY_YOUR_ENTERING_WRONG_INPUT_PLEASE_ENTER_AGAIN);
			continue Outer;
		}
	}

	/**
	 * through this method we validating string phonenumber
	 * @return phonenumber
	 */
	public String getPhoneNumberAftervalidation(){
		String phonenumber;
		Outer: while (true) {
			System.out.println(HospitalConstants.PLEASE_ENTER_PHONE_NUMBER);
			phonenumber = scanner.nextLine();
			p = Pattern.compile(phoneNumberExpression);
			match = p.matcher(phonenumber);

			if (match.matches()) {
                return phonenumber;
							} else {
				System.out.println(HospitalConstants.OOPS_YOUR_ENTERING_WRONG_MOBILE_NUMBER);
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
			System.out.println(HospitalConstants.PLEASE_ENTER_AGE);
			age = scanner.nextLine();
			p = Pattern.compile(ageExpression);
			match = p.matcher(age);
			if (match.matches()) {
				return age;
			} else {
				System.out.println(HospitalConstants.OOPS_YOUR_ENTERING_WRONG_AGE);
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
		SimpleDateFormat dateFormat = new SimpleDateFormat(HospitalConstants.DATE_FORMAT);
		dateFormat.format(admissionDate);
		System.out.println("Date:" + admissionDate.toString());
		return admissionDate;
	}

	public String getDataAftervalidation() 
	{
	        while (true) {
		    System.out.println(HospitalConstants.SIR_YOUR_PATIENT_ID_PLEASE);
		    String data =scanner.nextLine();
			p = Pattern.compile(dataExp);
			match = p.matcher(data);
			if (match.matches()) {
				return data;
			} else {
				System.out.println(HospitalConstants.OOPS_YOUR_ENTERING_WRONG_ID);
				continue;
			}
				
			
		}
	}

}
