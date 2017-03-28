package com.girnarsoft.carparking;

import java.util.Scanner;

/**
 * through parkingservices class user can check availability of car,
 * park a car,exit a car
 * @author Jayaram
 *
 */
public class ParkingServices {

	private int count;// count is variable used to count how many cars parked
	private CarDetails cardetails[][] = new CarDetails[4][4];
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * 
	 * through this park method user can park his car by using cardetails array
	 * and also print parking location
	 * @return nothing
	 * 
	 */
	public void park() {
		
        System.out.println("Please enter the car name");
		String carname = scanner.nextLine();
		// OUTER is label here we used it to implement keyword continue
		OUTER: while (true) {
	    System.out.println("Please enter the car number between 8 to 11 charaters");
		String carnumber = scanner.nextLine();
		if (carnumber.length() >= 8 && carnumber.length() <= 11 && !carnumber.contains(" ")) {
			  CarDetails car = new CarDetails(carname, carnumber);
				for (int row = 0; row < cardetails.length; row++) {
					for (int coloum = 0; coloum < cardetails[0].length; coloum++) {
						if (cardetails[row][coloum] == null) {
							cardetails[row][coloum] = car;
							System.out.println("Parking ID = " + ((row * cardetails.length) + (coloum + 1)));
							setCount(getCount() + 1);
							return;
						} 
						else if (car.getCarnumber().equals(cardetails[row][coloum].getCarnumber())) {
							System.out.println("With this number Car is already parked");
							continue OUTER;
						}
					}
				}
			}
		else {
				System.out.println("Invalid carnumber");
				continue OUTER;

			}
		}
	}

	/**
	 * exit method used to take off car from parking and also prints cardetails of car exit
	 * @return nothing
	 */
	public void exit() {
		   
		    INNER:while(true){
		    System.out.println("Please Enter Parking ID");
		    int parkingNumbers = scanner.nextInt();
			parkingNumbers--;
			int row = parkingNumbers / 4;
			int column = parkingNumbers % 4;
			if(cardetails[row][column]!=null){
			
			System.out.println(
					"CARNAME:" + cardetails[row][column].getCarname() + "\nCARNUMBER: " + cardetails[row][column].getCarnumber());
			cardetails[row][column] = null;
			setCount(getCount() - 1);
			return;
			}
			else{ 
				  System.out.println("With this parking ID  no car parked");
				  continue INNER;
			    }
		   }	
	}

	/**
	 * checkAvailability method is used to known the parking available or not
	 * @return nothing
	 */
	public void checkAvailability() {
		int row = cardetails.length;
		int coloum = cardetails[0].length;
		if (getCount() == (row * coloum)) {
			System.out.println("parking is full");
		}

		else {
			System.out.println("parking available");
		}

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
