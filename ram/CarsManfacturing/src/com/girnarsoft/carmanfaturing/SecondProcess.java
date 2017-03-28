package com.girnarsoft.carmanfaturing;

import java.io.PrintWriter;

/**
 * SecondProcess is user defined process used to start second process in car
 * assembling and interior & coloring
 * 
 * @author Jairam
 *
 */

public class SecondProcess implements Runnable {

	
	PrintWriter printWriter;
	String carname;

	public SecondProcess(PrintWriter printWriter, String carname) {
		this.printWriter = printWriter;
		this.carname = carname;

	}

	public void run() {
		printWriter.println(Cars_Constants.SECOND_PROCESS_BEGINS + carname);
		Thread interior = new Thread(new Interior(printWriter, carname));
		Thread coloring = new Thread(new Coloring(printWriter, carname));
		coloring.start();
		try {
			coloring.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interior.start();
		try {
			interior.sleep(1000);
			coloring.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
