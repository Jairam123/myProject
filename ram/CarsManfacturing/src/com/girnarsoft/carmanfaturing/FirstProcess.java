package com.girnarsoft.carmanfaturing;

import java.io.PrintWriter;

/**
 * SecondProcess is user defined process used to first process in car assembling
 * and start to process engine and Tyres for car
 * 
 * @author Jairam
 *
 */
public class FirstProcess implements Runnable {

	
	PrintWriter printWrite;
	String carname;

	public FirstProcess(PrintWriter printWrite, String carname) {
		this.printWrite = printWrite;
		this.carname = carname;

	}

	public void run() {

		printWrite.println(Cars_Constants.FISRT_PROCESS_BEGINS + carname);
		Thread engineAssemble = new Thread(new EngineAssemble(printWrite, carname));
		Thread tyresAssemble = new Thread(new TyresAssemble(printWrite, carname));

		tyresAssemble.start();
		try {
			tyresAssemble.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		engineAssemble.start();
		try {
			  engineAssemble.sleep(1000);
			  tyresAssemble.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
