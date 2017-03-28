package com.girnarsoft.multithreading;

public class ThreadDemo {

	public static void main(String[] args) {
		MyclassExample1 t1=new MyclassExample1();
		MyclassExample2 t2=new MyclassExample2();
		MyclassExample3 t3=new MyclassExample3();
		t1.start();
		t2.start();
		t3.start();
		
			}
}