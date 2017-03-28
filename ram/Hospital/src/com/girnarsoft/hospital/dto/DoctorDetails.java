package com.girnarsoft.hospital.dto;

/**
 * Through this class DoctorDetails we are created patientdetails variable
 * 
 * @author Jairam
 *
 */

public class DoctorDetails {
	private String name;
	private String specialisationIN;
	private int consultancyFee;

	public DoctorDetails(String name, String specialisationIN, int consultancyFee) {
		this.setName(name);
		this.setSpecialisationIN(specialisationIN);
		this.setConsultancyFee(consultancyFee);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialisationIN() {
		return specialisationIN;
	}

	public void setSpecialisationIN(String specialisationIN) {
		this.specialisationIN = specialisationIN;
	}

	public int getConsultancyFee() {
		return consultancyFee;
	}

	public void setConsultancyFee(int consultancyFee) {
		this.consultancyFee = consultancyFee;
	}
}
