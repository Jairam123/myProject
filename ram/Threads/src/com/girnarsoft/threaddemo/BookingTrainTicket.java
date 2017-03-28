package com.girnarsoft.threaddemo;

import java.util.Scanner;

public class BookingTrainTicket {
	public static void main(String args[]) {

		System.out.println("please enter number of births required:");
		Scanner scanner = new Scanner(System.in);
		int wanted = scanner.nextInt();
		// create a object for user defined process/Reservation class
		Reservation reservation = new Reservation(wanted);
		// create a thread and attach it to reservation object of reservation
		// class
		Thread thread1 = new Thread(reservation);
		Thread thread2 = new Thread(reservation);
		//set name to thread by calling setName method
		thread1.setName("Jairam");
		thread2.setName("mani");
		// start/invoke those 2 threads by calling start method in thread class
		thread1.start();
		thread2.start();
		
				
	}

}
