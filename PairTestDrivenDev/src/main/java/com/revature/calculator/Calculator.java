package com.revature.calculator;

public class Calculator {

	public Calculator() {
	}

	public Double add(String toAdd) throws CalculatorException {
		double sum = 0.0;
		if(toAdd==null) {
			
			return 0.0;
		}
		if (!toAdd.equals("")) {
			// split the string toAdd on a , delimiter
			String[] numbers = toAdd.split(",");
			if(numbers.length>=2) {
				throw new CalculatorException("too many args");
			}
			for (String number : numbers) {
				// parse the values as Doubles
				sum += Double.parseDouble(number);
			}

			// return their sum
			System.out.println(sum);
			return sum;
		}
		return sum;

	}
}