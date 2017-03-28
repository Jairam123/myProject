package com.girnarsoft.carmanfaturing;
import java.io.PrintWriter;
/**
 *  MusicSystem is user define Thread(process) to assemble  MusicSystem in car
 * @author Jairam
 *
 */

public class MusicSystem implements Runnable{

PrintWriter printWriter;
String carname;
public MusicSystem(PrintWriter printWriter , String carname) {
	this.printWriter = printWriter;
	this.carname = carname;
}
	public synchronized void run() {
		printWriter.println(Cars_Constants.MUSIC_SYSTEM_ASSEMBLED);
		printWriter.flush();
	}
}
