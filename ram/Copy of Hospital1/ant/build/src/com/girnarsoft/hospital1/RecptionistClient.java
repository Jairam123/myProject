package com.girnarsoft.hospital1;

import java.sql.SQLException;
import java.util.Scanner;

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
	private Dao dao;
    private Scanner scanner;
    

	public RecptionistClient() {
        patientServices =new PatientServices();
		doctorServices = new DoctorServices();
		validation = new Validation();
		scanner = new Scanner(System.in);
		dao=new Dao();
	}

	/**
	 * here we started main method
	 * 
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		RecptionistClient apolloRecptionist = new RecptionistClient();
		apolloRecptionist.process();
	}
	

	private void process() throws ClassNotFoundException, SQLException {

		
		//int patientID;
		//patientID = patientServices.start();
		doctorServices.doctors();
		int pID;
		while (true) {
			serviceMsg();
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				patientServices.addPatient();
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
				 try{
				    PatientDetails patient=dao.showSpecficpatientDetails(pID);
				    doctorServices.assignDoctorToPatient(pID, patient);
				   }catch(NullPointerException e){System.out.println(HospitalConstants.WITH_THIS_ID_THIER_WAS_NO_PATIENT);}
				    
				    break;
		  			
			case "7":return;
				//patientServices.exit(patientServices);
				

			default:
				    System.out.println("Invalid enter");
			}
		}
	}
	public void serviceMsg()
	{
		System.out.println(HospitalConstants.WELCOME_MSG);
		System.out.println(HospitalConstants.UNDER_LINE);
		System.out.println(HospitalConstants.MENU_CHOICE);
		System.out.println(HospitalConstants.MENU_LIST);
		System.out.println(HospitalConstants.UNDER_LINE);
	}
}
