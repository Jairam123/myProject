package com.girnarsoft.threaddemo;

public class Reservation implements Runnable{

	int available=3;
	private int wanted;
	Reservation(int wanted){
		this.setWanted(wanted);
	}
	public void run() {
		//only code excuted by thread

		//System.out.println("avialable birhts="+available);
		if(available>wanted){
			String name=Thread.currentThread().getName();
		    System.out.println("Berth conformed for"+name);
			
			try {
				 Thread.sleep(60000);//for printing ticket
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			available=available-wanted;	
		}else{
			System.out.println("Their are no seats available");
		}
		
	}
	public int getWanted() {
		return wanted;
	}
	public void setWanted(int wanted) {
		this.wanted = wanted;
	}

}
