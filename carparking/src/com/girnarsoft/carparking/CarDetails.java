package com.girnarsoft.carparking;
/**
 * cardetails class is used to save the details of car like car name ,car number
 * @author JayaramS
 *
 */
public class CarDetails {
	private String carname;
	 private String carnumber;
    /**
     * cardetails constructor used to take and car details
     * @param carname
     * @param carnumber
     */
	public CarDetails(String carname, String carnumber) {
		this.setCarname(carname);
		this.setCarnumber(carnumber);
	}
	/**
	 *getcarnumber method return carnumber from cardetails class
	 * @return carnumber
	 */
	public String getCarnumber() {
		return carnumber;
	}
  /**
   * This method is used to assign a value to carnumber of cardetails class
   * @param carnumber
   */
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
 /**
  * getcarname method return carname from cardetails class
  * @return carname
  */
	public String getCarname() {
		return carname;
	}
	/**
	 * This method is used to assign a value to carname of cardetails class
	 * @param carname
	 */
	public void setCarname(String carname) {
		this.carname = carname;
	}
}
