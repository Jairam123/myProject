package com.girnarsoft.carmanfaturing;

import java.io.PrintWriter;
/**
 * Coloring is user define Thread(process) to assemble Coloring in car
 * @author Jairam
 *
 */
public class Coloring implements Runnable{

PrintWriter printWriter;
String carname;
public Coloring(PrintWriter printWriter , String carname) {
	this.printWriter = printWriter;
	this.carname = carname;
}
	public synchronized void run() {
		printWriter.println(Cars_Constants.COLORING_OF_CAR_IS_COMPLETED);
		printWriter.flush();
	}

}
