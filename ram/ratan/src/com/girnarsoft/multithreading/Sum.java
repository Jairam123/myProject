package com.girnarsoft.multithreading;

public class Sum {

	public static void main(String[] args) {
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int num3 = Integer.parseInt(args[2]);
			int sum;
			sum = num1 + num2 + num3;
			System.out.println("SUM:" + sum);
		} catch (NumberFormatException e) {
			System.out.println("Sorry you most enter only Integers");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("you must enter 3 Integers");
		}

	}
}
