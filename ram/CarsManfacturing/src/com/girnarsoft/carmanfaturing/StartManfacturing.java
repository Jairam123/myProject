package com.girnarsoft.carmanfaturing;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * StartManfacturing is a User thread(process) used to star process the first & second process 
 * @author Jairam
 *
 */
public class StartManfacturing implements Runnable {
	
	String carname;

	public StartManfacturing(String carname) {

		this.carname = carname;
	}
	public void run() {
		try {
			PrintWriter printWriter = new PrintWriter(new FileWriter(carname + ".txt"));
			printWriter.println(carname + Cars_Constants.CAR_MANFACTURING_BEGINS);
			Thread firstProcess = new Thread(new FirstProcess(printWriter, carname));
			firstProcess.start();
			firstProcess.join();
			Thread secondProcess = new Thread(new SecondProcess(printWriter, carname));
			secondProcess.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
