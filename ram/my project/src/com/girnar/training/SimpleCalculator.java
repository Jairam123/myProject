package com.girnar.training;

public class SimpleCalculator extends BaseCalculator {

	private static int operationCounter = 0;

	public void performCalculator(int number1, int number2, String operation) {

		switch (operation) {
		case "+":
			System.out.println(number1 + number2);
			break;
		case "-":
			System.out.println(number1 - number2);
			break;
		case "*":
			System.out.println(number1 * number2);
			break;
		case "/":
			System.out.println(number1 / number2);
			break;

		}
	}

	public int getCounter() {
		return operationCounter;

	}

}
