package com.girnar.training;

public abstract class BaseCalculator {

	public void calculate(int number1, int number2, String operation) {
		System.out.println("request came " + System.currentTimeMillis());
		performCalculator(number1, number2, operation);
		System.out.println("request fulfilled " + System.currentTimeMillis());
	}

	protected abstract void performCalculator(int number1, int number2, String operation);
}
