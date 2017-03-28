package com.girnarsoft.threaddemo;

import java.util.Scanner;

//creating thread using runnable interface
public class SimpleExampleForCreatingThread {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Myclass myclass=new Myclass();
		Thread thread=new Thread(myclass);
		thread.setName("Jairam");
		System.out.println("thread priority:"+thread.getPriority());//To get the priority of thread
		System.out.println("Set new priority to thread");
		int setNewPriority=scan.nextInt();
		thread.setPriority(setNewPriority);//To set the new priority for thread
		System.out.println("thread name:"+thread.getName());//To get name of the Thread
		thread.start();//here we are call the start method to invoke the thread
		if(thread.isAlive())
		{
			System.out.println("I am alive");
		}
		for(int i=1;i<10;i++)
		{
			System.out.println("I am in main thread:"+i);
		}
		

		System.out.println("thread priority:"+thread.getPriority());//To get the priority of thread
		System.out.println("current thread:"+Thread.currentThread());//To known the current thread
		System.out.println("activecount of thread:"+thread.activeCount());
        System.out.println("Maxpriority="+Thread.MAX_PRIORITY);
        System.out.println("Minpriority="+Thread.MIN_PRIORITY);
        System.out.println("normpriority="+Thread.NORM_PRIORITY);
        
	}

}
