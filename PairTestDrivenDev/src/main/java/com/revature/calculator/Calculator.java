package com.revature.calculator;

public class Calculator {

	public Calculator() {
	}

	public Double add(String toAdd) throws CalculatorException {
		Double sum = 0.0;
		boolean containsLetters = false;
		if (toAdd != null) {
			if (!toAdd.equals("")) {
				// split the string toAdd on a , delimiter
				String[] numbers = toAdd.split(",");
				// System.out.println(numbers.length);
				if (numbers.length == 2) {
					for (String number1 : numbers) {
						System.out.println(number1);
						if (number1.contains("[A-Za-z!]+")) {
							System.out.println(number1);
							containsLetters = true;
						}
					}
					for (String number : numbers) {
						// parse the values as Doubles
						sum += Double.parseDouble(number);
					}
				} else if (containsLetters) {
					throw new CalculatorException();
				} else {
					throw new CalculatorException();
				}
			}
		}
		return sum;
	}
}
