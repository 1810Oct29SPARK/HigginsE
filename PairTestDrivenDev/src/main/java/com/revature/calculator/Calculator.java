package com.revature.calculator;



public class Calculator {

	public Calculator() {
	}

	public Double add(String toAdd) throws CalculatorException {
		Double sum = 0.0;
		if (toAdd ==null) {
			return 0.0; 
		}
		else if (!toAdd.equals("")) {
			// split the string toAdd on a , delimiter
			String[] numbers = toAdd.split(",");
			//throw an exception if there are too many arguments
			if (numbers.length > 2) {
				throw new CalculatorException("Too many arguments!");
			}
			
			for (String number : numbers) {
				for (int i = 0; i < number.length(); i++) {
					if (Character.isDigit(number.charAt(i)) || number.indexOf('.') != -1) {
						continue;
					} else {
						throw new CalculatorException("Invalid input detected!");
					}
				}
				// parse the values as Doubles
				sum += Double.parseDouble(number);
			}
		}
		// return their sum
		return sum;
	}
}
