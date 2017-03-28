package com.girnarsoft.hospital.services;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.girnarsoft.hospital.dto.DoctorDetails;
import com.girnarsoft.hospital.dto.PatientDetails;

/**
 * through class DoctorServices we can know doctorslist and assign doctor
 * 
 * @author gspl
 *
 */
public class DoctorServices {

	Scanner scanner = new Scanner(System.in);
	PatientServices patientServices = new PatientServices();
    HashMap<Integer, DoctorDetails> doctorMap = new HashMap<>();
	Validation validation = new Validation();
	int tokenID ;
	int doctorID;

	/**
	 * In this method we are created 3 doctors od different specialisation and
	 * also putting those doctor details in doctormap
	 */
	public void doctors() {
		
		DoctorDetails doctordetails = new DoctorDetails("Jairam", "Ophthamologist", 500);
		doctorID = doctorMap.size() + 1;
		doctorMap.put(doctorID, doctordetails);
		DoctorDetails doctordetails1 = new DoctorDetails("John", "Cardologist", 600);
		doctorID++;
		doctorMap.put(doctorID, doctordetails1);
		DoctorDetails doctordetails2 = new DoctorDetails("Ram", "Oncologist", 700);
		doctorID++;
		doctorMap.put(doctorID, doctordetails2);

	}

	public void showDoctorsList() {

		for (Map.Entry<Integer, DoctorDetails> docEntry : doctorMap.entrySet()) {
			System.out.println("DoctorID:" + docEntry.getKey() + "||DoctorName:" + docEntry.getValue().getName()
					+ "||SpecialisationIN:" + docEntry.getValue().getSpecialisationIN() + "||Consultancy"
					+ docEntry.getValue().getConsultancyFee());
		}
	}


	public void assignDoctorToPatient(int patientID, PatientServices patientServices) {

		System.out.println(patientID);
		PatientDetails patient = patientServices.getPatientMap().get(patientID);
		
		if (patientServices.getPatientMap().containsKey(patientID)) {

		    if (patient.getDisease().equalsIgnoreCase("eye")){
				DoctorDetails doc = doctorMap.get(1);
				System.out.println("DoctorName:" + doc.getName() + "||SpecialisationIN:" + doc.getSpecialisationIN()
						+ "||ConsultancyFee:" + doc.getConsultancyFee());
				consultancyFee(patientID, patientServices,1);
				System.out.println("PatientName:" + patient.getName());
			} else if (patient.getDisease().equalsIgnoreCase("cancer")) {
				DoctorDetails doc = doctorMap.get(3);
				System.out.println("DoctorName:" + doc.getName() + "||SpecialisationIN:" + doc.getSpecialisationIN()
						+ "||ConsultancyFee:" + doc.getConsultancyFee());
				consultancyFee(patientID, patientServices,3);
				System.out.println("PatientName:" + patient.getName());
			} else if (patient.getDisease().equalsIgnoreCase("heart")) {
				DoctorDetails doc = doctorMap.get(2);
				System.out.println("DoctorName:" + doc.getName() + "||SpecialisationIN:" + doc.getSpecialisationIN()
						+ "||ConsultancyFee:" + doc.getConsultancyFee());
				consultancyFee(patientID, patientServices,2);
				System.out.println("PatientName:" + patient.getName());

			} else
				System.out.println("For your disease we have no doctors sorry");
		} else
			System.out.println("With this ID thier was no patient");

	}


	public void consultancyFee(int patientID, PatientServices patientServices,int doctorID) {
		PatientDetails patient = patientServices.getPatientMap().get(patientID);
		Date date = patient.getDate();
		long dateTime = date.getTime();
		long todayTime = date.getTime();

		long diff = todayTime - dateTime;
		diff = (((diff / 1000) / 60) / 60) / 24;

		if (diff < 1 || diff > 7) {

			DoctorDetails doc = doctorMap.get(doctorID);
			System.out.println("you need pay consultancy Fee of" + doc.getConsultancyFee());

			System.out.println("tokenID:" + (tokenID += 1));

		} else {
			System.out.println("You need not pay for consultancy");
			System.out.println("tokenID:" + (tokenID += 1));
		}
	}
}
