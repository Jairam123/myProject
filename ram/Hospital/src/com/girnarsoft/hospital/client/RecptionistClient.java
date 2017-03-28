package com.girnarsoft.hospital.client;

import java.util.Scanner;

import com.girnarsoft.hospital.services.DoctorServices;
import com.girnarsoft.hospital.services.PatientServices;
import com.girnarsoft.hospital.services.Validation;
/**
 * Through RecptionistClient we can add,update,delete,assingdoctor
 * 
 * @author Jairam
 *
 */

public class RecptionistClient {
	private  PatientServices patientServices;
	private  DoctorServices doctorServices;
	private  Validation validation;
    private Scanner scanner;

	public RecptionistClient() {
        patientServices =new PatientServices();
		doctorServices = new DoctorServices();
		validation = new Validation();
		scanner = new Scanner(System.in);
	}

	/**
	 * here we started main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		RecptionistClient apolloRecptionist = new RecptionistClient();
		apolloRecptionist.process();
	}
	

	private void process() {

		
		int patientID;
		patientID = patientServices.start();
		doctorServices.doctors();
		int pID;
		while (true) {
			serviceMsg();
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				patientServices.addPatient(patientID, patientServices);
				break;
			case "2":
				int id=Integer.parseInt(validation.getDataAftervalidation());
				patientServices.update(id,patientServices);
				break;
			case "3":
				patientServices.deletePatient();
				break;
			case "4":
				 patientServices.showPatientList();
				 break;
			case "5":
			      doctorServices.showDoctorsList();
			      break;
			case "6":
				  pID= Integer.parseInt(validation.getDataAftervalidation());
				 doctorServices.assignDoctorToPatient(pID, patientServices);
				 break;
		  			
			case "7":
				patientServices.exit(patientServices);
				return;

			default:
				System.out.println("Invalid enter");
			}
		}
	}
	public void serviceMsg()
	{
		System.out.println("Welcome to Receptionist Client Service");
		System.out.println("=======================================");
		System.out.println("Please press your press:");
		System.out.println("1.Add Patient\n2.Update \n3.Delete\n4.ShowPatientList\n5.ShowDoctorList\n6.Assingdoctor\n7.Exit");
		System.out.println("=======================================");
	}
}
