package com.girnarsoft.carmanfaturing;
import java.io.PrintWriter;
/**
 * Interior is user define Thread(process) to assemble interior in car and start threads(processes) MusicSystem & SeatsAssembly
 * @author Jairam
 *
 */

public class Interior implements Runnable{

	
	PrintWriter printWriter;
	String carname;
	public Interior(PrintWriter printWriter , String carname) {
		this.printWriter = printWriter;
		this.carname =  carname;
	}
	public void run() {
		printWriter.println(Cars_Constants.INTERIOR_BEGINS+carname);
		Thread musicSystem = new Thread(new MusicSystem(printWriter, carname)); 
        Thread seatsAssembly = new Thread(new SeatsAssembly(printWriter, carname));
        musicSystem.start();
        seatsAssembly.start();
        try{
        	musicSystem.sleep(1000);
        	seatsAssembly.sleep(1000);
        }catch(InterruptedException e){
        	e.printStackTrace();
        }
	}

}
