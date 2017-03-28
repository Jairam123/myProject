package com.girnarsoft.carmanfaturing;
import java.io.PrintWriter;
/**
 * MainEngine is user define Thread(process) to assemble MainEngine in car
 * @author Jairam
 *
 */
public class MainEngine implements Runnable{

PrintWriter printWriter;
String carname;
public MainEngine(PrintWriter printWriter ,String carname) {
	this.printWriter = printWriter;
	this.carname = carname;
	
}
	public synchronized void run() {
		
		 printWriter.println(Cars_Constants.MAIN_ENGINE_IS_ASSEMBLED);
		 printWriter.flush();
	}

}
