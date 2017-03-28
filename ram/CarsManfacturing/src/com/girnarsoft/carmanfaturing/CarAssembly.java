package com.girnarsoft.carmanfaturing;

/**
 * The CarAssembly class code is used to star manfacturing process of car by staring Starmanfacturing
 * @author Jairam
 *
 */
public class CarAssembly {

	public static void main(String[] args) {
		String[] carname = { "HONDA", "SKODA", "BENZE", "INNOVA", "BMW", "AUDI", "MERCURY", "TOYOTA", "SUZUKI",
				"LINCOLN", "LEXAS",  "JAGUAR", "VOLVE", "BUICK", "DODGE","BENTLEY","FORD","DASTUN","NANO","LAMBORGHINI" };
		for (int i = 0; i < carname.length; i++) {
			StartManfacturing startManfacturing = new StartManfacturing(carname[i]);
			Thread Starmanfacturing = new Thread(startManfacturing);
			Starmanfacturing.start();
			
		}

	}

}
