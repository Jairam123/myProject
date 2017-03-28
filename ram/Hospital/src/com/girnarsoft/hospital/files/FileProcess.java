package com.girnarsoft.hospital.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.girnarsoft.hospital.dto.PatientDetails;
import com.girnarsoft.hospital.services.PatientServices;

/**
 * through this class FileProcess we are reading,writing,updating,deleting
 * patinet details
 * 
 * @author Jairam
 *
 */

public class FileProcess {
	private int patientID = 0;
	private String patientName;
	private String mobileNumber;
	private int age;
	private String disease;
	private Date date;
	private String line;
	private HashMap<Integer, PatientDetails> patientMap1 = new HashMap<>();
	SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * through this method we are writing file
	 * 
	 * @param patient
	 * @param patientID
	 */
	public void writeDataIntofile(PatientServices patientServices) {

		try {
			// creating file and also object
			File file = new File("PatientsList.txt");
			// create an object of print writer for writing to a file into doctorslist(file)
			PrintWriter printWriter = new PrintWriter(new FileWriter(file));
			for (Map.Entry<Integer, PatientDetails> map : patientServices.getPatientMap().entrySet()) {
				printWriter.println(map.getKey() + "/" + map.getValue().getName() + "/"
						+ map.getValue().getMobilenumber() + "/" + map.getValue().getAge() + "/"
						+ map.getValue().getDisease() + "/" + dateFormate.format(map.getValue().getDate()));
			}
			printWriter.close();
		} catch (IOException ioexception) {
			System.out.println("Error in read/write of file");
		}

	}

	/**
	 * through this method we are reading file
	 */
	public void readPatientDataFromFile() {

		try {
			File file = new File("PatientsList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {

				patientID = Integer.parseInt(line.split("/")[0]);
				patientName = line.split("/")[1];
				mobileNumber = line.split("/")[2];
				age = Integer.parseInt(line.split("/")[3]);
				disease = line.split("/")[4];
				date = dateFormate.parse(line.substring(line.indexOf(line.split("/")[5])));
				PatientDetails patient = new PatientDetails(patientName, mobileNumber, age, disease, date);
				patientID = patientMap1.size() + 1;
				getPatientMap1().put(patientID, patient);
			}

		} catch (FileNotFoundException e) {
			System.out.println("file not found Exception");
			;
		} catch (IOException e) {
			System.out.println("error ocurred at read/write in file ");
		} catch (ParseException e) {
			e.getMessage();
		}
	}	
		

		public HashMap<Integer, PatientDetails> getPatientMap1() {
			return patientMap1;
		}

		public void setPatientMap1(HashMap<Integer, PatientDetails> patientMap1) {
			this.patientMap1 = patientMap1;
		}

		

	

	
}