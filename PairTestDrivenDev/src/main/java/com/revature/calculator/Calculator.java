package com.revature.calculator;

public class Calculator {

	public Calculator() {
	}

	public Double add(String toAdd) throws Exception {
		Double sum = 0.0;
		if (toAdd == null) {
			sum = 0.0;
		} else if (!toAdd.equals("")) {

			// split the string toAdd on a , delimiter
			String[] numbers = toAdd.split(",");
			for (String number : numbers) { // augmented for loop whaaaa
				// parse the values as Doubles
				sum += Double.parseDouble(number);

				// return their sum
			}
		}
		//if (numbers > 2) 
		
		return sum;

	}

	class CalculatorException extends Exception {
		public CalculatorException(String arg0, String arg1, String arg2) {
			super();
			System.out.println("more than 2 arguments");
		}

		public CalculatorException(Throwable arg0, Throwable arg1, Throwable arg2) {
			super(arg0);
		}
	}

}
