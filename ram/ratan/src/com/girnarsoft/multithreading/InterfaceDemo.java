package com.girnarsoft.multithreading;
interface Interface{
	void m1();
	void m2();
	void m3();
}
public class InterfaceDemo implements Interface{

	public static void main(String[] args) {
        Interface it=new InterfaceDemo();
        it.m1();
        it.m2();
        it.m3();
        
	}

	public void m1() {
	
       System.out.println("m1 method");		
	}

	public void m2() {
     System.out.println("m2 method");		
	}

	public void m3() {
      System.out.println("m3 method");		
	}

}
