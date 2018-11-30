package com.revature.calculator;

public class Calculator {

	public Calculator() throws Exception  {
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
//				try {
//					System.out.println("success");
//				} catch (CalculatorException ce) {
//					ce.printStackTrace();
//				}
			}

		}

		// return their sum
		return sum;
	}

	public class CalculatorException extends Exception {
		public CalculatorException(String arg0, String arg1, String arg2) {
			super();
			System.out.println("more than 2 arguments");
		}
		public CalculatorException(Throwable arg0, Throwable arg1, Throwable arg2) {
			super(arg0);
		}
	}

}
