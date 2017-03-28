
package com.girnarsoft.carparking;

import java.util.Scanner;
 /**
  *  Valletparking class application is user interface here user can access
  *  parking services like park ,exit the car
  *  @author Jayaram
  *
  */
public class ValletParking {
	/**
	 * here main method begins
	 * @param args
	 */
	
   public static void main(String[] args) {
		
        ParkingServices parkingservices = new ParkingServices();
		
        while (true) {
			
			System.out.println("Please your enter choice  \n 1.Check the availablity \n 2.To Park Your Car \n 3.To Take Your Car \n 4.Terminate");
			Scanner scanner = new Scanner(System.in);
			String choice = scanner.nextLine();
			
		    switch (choice) 
		 {     
		      
			case "1":
				     parkingservices.checkAvailability();
					 break;
			case "2":
				     parkingservices.park();
			     break;
			case "3": 
				     parkingservices.exit();
				    break;
			case "4":return;
			default:System.out.println("Please enter a valid choice\n" );

			}

		}

	}

}
