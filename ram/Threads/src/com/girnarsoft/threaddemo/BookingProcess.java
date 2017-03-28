package com.girnarsoft.threaddemo;

import java.util.Scanner;

class BookingSelectingMovie implements Runnable  {
  Scanner scan =new Scanner(System.in);
	public void run() {
		System.out.println(" Villan \n Dilwale \n Dangal \n Saala Khadoos\n Hunger Games");
		System.out.println("Please Enter Movie Name You Want Go:");
		System.out.println("your selected movie was:"+scan.next());
		}
}	

 class BookingSelectingShow implements Runnable  {
	  Scanner scan =new Scanner(System.in);
		public void run() {
			System.out.println("Morning Show \n Matine Show \n First Show \n Second Show");
			System.out.println("Please Enter Show");
			System.out.println("your selected show was:"+scan.next());
}
 }
 class BookingSelectingSeats implements Runnable  {
	  Scanner scan =new Scanner(System.in);
		public void run() {
			System.out.println("Please Enter No of Seats Required");
	         System.out.println("No of seats Selected:"+scan.nextLine());
			}
	}	

 class BookingPaymentProcess implements Runnable  {
		public void run() {
			System.out.println("your Payment completed");	
			}
	}	
 class BookingTicketEmail implements Runnable  {
		public void run() {
			System.out.println("Email is Delivered to your register mail");
			}
}
 class BookingTicketSms implements Runnable  {
		public void run() {
			System.out.println("SMS is Delivered to your register number");
			}
}
 

