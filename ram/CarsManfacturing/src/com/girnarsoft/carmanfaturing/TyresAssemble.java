package com.girnarsoft.carmanfaturing;
import java.io.PrintWriter;
/**
 * TyresAssemble is user define Thread(process) to assemble TyresAssemble in car
 * @author Jairam
 *
 */
public class TyresAssemble implements Runnable{

PrintWriter printWriter;
String carname;
	public TyresAssemble(PrintWriter printWriter,String carname) {
		this.printWriter = printWriter;
		this.carname = carname;
	}
	public synchronized void run(){	
		printWriter.println(Cars_Constants.TYRES_ARE_ASSEMBLED);
		printWriter.flush();
	}

}
