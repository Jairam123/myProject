package com.girnarsoft.carmanfaturing;
import java.io.PrintWriter;
/**
 * SeatsAssembly is user define Thread(process) to assemble SeatsAssemble in car
 * @author Jairam
 *
 */
 
public class SeatsAssembly implements Runnable {

PrintWriter printWriter;
String carname;
public SeatsAssembly(PrintWriter printWriter , String carname) {
	this.printWriter = printWriter;
	this.carname = carname;
}
	public void run() {
		printWriter.println(Cars_Constants.SEATS_ARE_ASSEMBLED);
		printWriter.flush();
	}
	

}
