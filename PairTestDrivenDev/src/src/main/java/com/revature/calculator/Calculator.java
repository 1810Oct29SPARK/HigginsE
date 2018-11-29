package com.revature.calculator;

public class Calculator {

	public Calculator() {
	}

	public Double add(String toAdd) {
		Double sum = 0.0;
		if (toAdd == null) {
			sum = 0.0;
		} else if (!toAdd.equals("")) {
			// split the string toAdd on a , delimiter
			String[] numbers = toAdd.split(",");
			for (String number : numbers) { // augmented for loop whaaaa
				// parse the values as Doubles
				sum += Double.parseDouble(number);
				if (numbers.length > 2) {
					try {
						
					}
				}
			}
		}

		// return their sum
		return sum;
	}

}
