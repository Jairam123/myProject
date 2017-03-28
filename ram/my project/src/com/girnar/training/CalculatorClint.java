package com.girnar.training;

public class CalculatorClint {
	public static void main(String[] args) {
		int number1 = 2;
		int number2 = 3;
		String operation = "*";
//		SimpleCalculator simplecal = new SimpleCalculator();
//		simplecal.calculate(number1, number2, operation);
		ScienticficCalculator scitcal = new ScienticficCalculator();
		scitcal.calculate(number1, number2, operation);
		
	}
}
