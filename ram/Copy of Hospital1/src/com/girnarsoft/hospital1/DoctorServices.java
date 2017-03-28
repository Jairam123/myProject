package com.girnarsoft.hospital1;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * through class DoctorServices we can know doctorslist and assign doctor
 * @author Jairam
 *
 */
public class DoctorServices {
    private static final String TOKEN_ID = "tokenID:";
	private static final String PAY_CONSULTANCY_FEE = "you need pay consultancy Fee =";
	private static final String HEART = "heart";
	private static final String NO_DOCTORS_SORRY = "For your disease we have no doctors sorry";
	private static final String CANCER = "cancer";
	private static final String PATIENT_NAME = "PatientName:";
	private static final String EYE = "eye";
	private static final String CONSULTANCY_FEE = "Consultancy Fee";
	private static final String SPECIALISATION_IN = "SpecialisationIN:";
	private static final String DOCTOR_NAME = "DoctorName:";
	private static final String DOCTOR_ID = "DoctorID:";
	//HospitalDataBase hospitalDataBase=new HospitalDataBase();
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
			System.out.println(DOCTOR_ID + docEntry.getKey() + "||"+DOCTOR_NAME + docEntry.getValue().getName()
					+ "||"+SPECIALISATION_IN + docEntry.getValue().getSpecialisationIN() +"||"+CONSULTANCY_FEE
					+ docEntry.getValue().getConsultancyFee());
		}
	}


	public void assignDoctorToPatient(int patientID ,PatientDetails patient) throws ClassNotFoundException, SQLException {

		System.out.println(patientID);
		
		    if (patient.getDisease().equalsIgnoreCase(EYE)){
				DoctorDetails doc = doctorMap.get(1);
				System.out.println(DOCTOR_NAME+ doc.getName() +"||"+ SPECIALISATION_IN + doc.getSpecialisationIN()
						+"||"+ CONSULTANCY_FEE + doc.getConsultancyFee());
				consultancyFee(patientID, patient,1);
				System.out.println(PATIENT_NAME + patient.getName());
			} else if (patient.getDisease().equalsIgnoreCase(CANCER)) {
				DoctorDetails doc = doctorMap.get(3);
				System.out.println(DOCTOR_ID + doc.getName() +"||"+ SPECIALISATION_IN + doc.getSpecialisationIN()
						+ "||ConsultancyFee:" + doc.getConsultancyFee());
				consultancyFee(patientID, patient,3);
				System.out.println(PATIENT_NAME + patient.getName());
			} else if (patient.getDisease().equalsIgnoreCase(HEART)) {
				DoctorDetails doc = doctorMap.get(2);
				System.out.println(DOCTOR_NAME + doc.getName() + SPECIALISATION_IN + doc.getSpecialisationIN()
						+ "||ConsultancyFee:" + doc.getConsultancyFee());
				consultancyFee(patientID, patient,2);
				System.out.println(PATIENT_NAME + patient.getName());

			} else
				System.out.println(NO_DOCTORS_SORRY);

	}


	public void consultancyFee(int patientID, PatientDetails patient,int doctorID) {
		//PatientDetails patient = patientServices.getPatientMap().get(patientID);
		Date date = patient.getDate();
		Date today = new Date();
		long dateTime = date.getTime();
		long todayTime = date.getTime();

		long diff = todayTime - dateTime;
		diff = (((diff / 1000) / 60) / 60) / 24;

		if (diff < 1 || diff > 7) {
			// consultation fee

			DoctorDetails doc = doctorMap.get(doctorID);
			System.out.println(PAY_CONSULTANCY_FEE + doc.getConsultancyFee());
			System.out.println(TOKEN_ID + (tokenID += 1));
			// System.out.println();

		} else {
			// no consultation fee
			System.out.println("You need not pay for consultancy");
			System.out.println(TOKEN_ID + (tokenID += 1));
		}
	}
	
}
