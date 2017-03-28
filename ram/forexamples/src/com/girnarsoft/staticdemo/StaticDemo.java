package com.girnarsoft.staticdemo;

public class StaticDemo {
	static int i=0;

	public static void main(String[] args) {
		System.out.println("rama sita");
	}
	
	static
	{
		i=10;
		System.out.println("jai---------"+i);
		String []s1 = new String[2];
		s1[0] = "rama";
		s1[1] = "sita";
	//	add(s1);
	}

	 static void add(String s1) {
		System.out.println(s1);
		
	}

}
