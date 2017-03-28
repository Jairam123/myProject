package com.girnarsoft.multithreading;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {

		int factorial = 1;
		try {
			int number = Integer.parseInt(args[0]);
			for (int i = 1; i <= number; i++) {
				factorial = factorial * i;
			}
			System.out.println("Factorial:" + factorial);
		} catch (NumberFormatException e) {
			System.out.println("Sorry you most enter only Integers");
		}
	}

}
