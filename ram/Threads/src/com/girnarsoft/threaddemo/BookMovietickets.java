package com.girnarsoft.threaddemo;

public class BookMovietickets {

	public static void main(String[] args) {
      
		BookingSelectingMovie bookingSelectingMovie=new BookingSelectingMovie();
		Thread t1=new Thread(bookingSelectingMovie);
		t1.start();
		try{t1.join();}catch(InterruptedException e){e.printStackTrace();}
		BookingSelectingShow bookingSelectingShow=new BookingSelectingShow();
		Thread t2=new Thread(bookingSelectingShow);
		t2.start();
		try{t2.join();}catch(InterruptedException e){e.printStackTrace();}
		BookingSelectingSeats bookingSelectingSeats=new BookingSelectingSeats();
		Thread t3= new Thread(bookingSelectingSeats);
		t3.start();
		try{t3.join();}catch(InterruptedException e){e.printStackTrace();}
		BookingPaymentProcess bookingPaymentProcess =new BookingPaymentProcess();
		Thread t4=new Thread(bookingPaymentProcess);
		t4.start();
		try{t4.join();}catch(InterruptedException e){e.printStackTrace();}
		BookingTicketEmail bookingTicketEmail =new BookingTicketEmail();
		Thread t5=new Thread(bookingTicketEmail);
		t5.start();
		BookingTicketSms bookingTicketSms=new BookingTicketSms();
		Thread t6= new Thread(bookingTicketSms);
		t6.start();
		
	}

}
