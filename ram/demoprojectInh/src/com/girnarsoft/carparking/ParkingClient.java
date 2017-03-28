package com.girnarsoft.carparking;

import java.util.Scanner;




/**
 * This class can be used for any parking client which gives all parking
 * facilites <p>
 * @author  Nirmal Agrawal
 * @since   V2.0
 */

public class ParkingClient {

	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		ParkingClient bigBazzar = new ParkingClient();
		Parking bigBazzarParking = new Parking();
		bigBazzar.openParking(bigBazzarParking);

	}

	public void openParking(Parking parking) {

		while (true) {

			serviceMsg();
			Integer choice = scanner.nextInt();
			switch (choice) {
			case 1:
				parkCar(parking);
				break;
			case 2:
				exitCar(parking);
				break;
			case 3:
				parking.showParking();
				break;
			default:
				System.out.println("Please enter Valid choice.");
				break;
			}
		}

	}

	public void exitCar(Parking parking) {
		System.out.println("Please provide your parking number : ");
		Integer parkingNo = scanner.nextInt();
		parking.exitCarFromParking(parkingNo);
	}

	public void serviceMsg() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("How can i help you today ?");
		System.out.println("Press 1 for parking your car");
		System.out.println("Press 2 for exit your car from parking");
		System.out.println("Press 3 for parking status");
		System.out.println("----------------------------------");
		System.out.println("");
	}

	 /**
     * this mehtod will be used for car parking .
     *
     * @param  parking :  this is the parking object in which car's will be parked .
     *         
     */
	public Boolean parkCar(Parking parking) {
		Car car = getCarDetails();
		if (car != null) {
			Integer parkingNo = parking.parkCar(car);
			if (parkingNo != null) {
				System.out.println("Congratulation's Your car has been parked at parking id : " + parkingNo);
				System.out.println("");
				return true;
			} else {

				System.out.println("Sorry For inconvinance , parking is full . Please try after some time");
				System.out.println("");
				return false;
			}
		}

		return false;
	}

	public Car getCarDetails() {

		for(int count = 1;count <= 3 ;count++) {
			System.out.println("Please enter your car details");
			System.out.println("Please enter car number");
			System.out.println();
			String carNumber = scanner.next();
			System.out.println("Please enter car name");
			System.out.println();
			String carName = scanner.next();
			Car car = new Car(carName, carNumber);
			StringBuilder errorMsg = car.validateCar();
			if (errorMsg != null && errorMsg.length() != 0) {
					System.out.println(errorMsg);
					continue;
			} else {
				return car;
			}
		}
		System.out.println("You are not entering correct deatils , please visit later");
		return null;

	}

}
