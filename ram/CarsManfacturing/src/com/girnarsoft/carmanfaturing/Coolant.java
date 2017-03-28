package com.girnarsoft.carmanfaturing;

import java.io.PrintWriter;

public class Coolant implements Runnable {
	
	PrintWriter printWriter;
	String carname;

	public Coolant(PrintWriter printWriter, String carname) {
		this.printWriter = printWriter;
		this.carname = carname;
	}

	public synchronized void run() {
		printWriter.println(Cars_Constants.COOLANT_ASSEMBLED);
		printWriter.flush();
	}

}
