package com.girnarsoft.carmanfaturing;

import java.io.PrintWriter;

public class Breaks implements Runnable{

 
PrintWriter printWriter;
  String carname;
   public Breaks(PrintWriter printWriter,String carname) {
	   this.printWriter=printWriter;
	   this.carname=carname;
}
	public synchronized void run() {
    		printWriter.println(Cars_Constants.BREAKS_ASSEMBLED);
    		printWriter.flush();
	}
	

}
