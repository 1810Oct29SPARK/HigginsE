package com.revature.calculator;

public class Calculator {

	public Calculator() {
	}

	public Double add(String toAdd) {
		Double sum = 0.0;
		
		if (toAdd == null) {
			return 0.0;
		}
		
		else if (!toAdd.equals("")) {
			// split the string toAdd on a , delimiter
			String[] numbers = toAdd.split(",");
			for (String number : numbers) {
				// parse the values as Doubles
				sum += Double.parseDouble(number);
			}
			// return their sum
			return sum;
		}
		
		return 0.0;
	}

}
