package com.revature.calculator;

import java.util.regex.Pattern;

public class Calculator {

	public Calculator() {
	}

	/*
	 * public void toAdd() throws CalculatorException { }
	 */
	public Double add(String toAdd) throws CalculatorException {
		Double sum = 0.0;

		if (toAdd == null) {
			return 0.0;
		}
		
		try {
			if (!toAdd.equals("")) {
				// split the string toAdd on a , delimiter
				String[] numbers = toAdd.split(",");
				
				if (numbers.length == 2) {
					for (String number : numbers) {
						try {
							// parse the values as Doubles
							sum += Double.parseDouble(number);
						} catch (NumberFormatException n) {
							System.out.println("Value,");
							throw new CalculatorException();
						}
					}
				} else {
					System.out.println("#Args,");
					throw new CalculatorException();
				}
			}
		} catch (Exception e) {
			System.out.println("Empty,");
			throw new CalculatorException();
		}

		// return their sum
		return sum;
	}
}