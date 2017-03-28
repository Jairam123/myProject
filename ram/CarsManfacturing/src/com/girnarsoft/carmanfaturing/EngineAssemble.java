package com.girnarsoft.carmanfaturing;
import java.io.PrintWriter;
/**
 * EngineAssemble is user define Thread(process) to assemble engine in car and start threads(processes) break & coolant & mainEngine
 * @author Jairam
 *
 */

public class EngineAssemble implements Runnable {
 
PrintWriter printWriter;
 String carname;
	public EngineAssemble(PrintWriter printWriter,String carname){
		this.printWriter = printWriter;
		this.carname = carname;
	}
	public void run() {
		printWriter.println(Cars_Constants.ENGINE_ASSEMBLING_BEGINS_FOR+carname);
		Thread breaks = new Thread(new Breaks(printWriter, carname));
		Thread coolant = new Thread(new Coolant(printWriter, carname));
		Thread mainEngine = new Thread(new MainEngine(printWriter, carname));
		breaks.start();
		coolant.start();
		mainEngine.start();
	}

}
