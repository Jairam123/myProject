package com.girnarsoft.multithreading;

 class MyclassExample1  extends Thread {
	public void run(){ 
		A.msg("jai");
	}
}
 class MyclassExample2  extends Thread {
	public void run(){ 
		A.msg("ram");
	}
}
 class MyclassExample3  extends Thread {
	public void run(){ 
		A.msg("mani");
	}
}
