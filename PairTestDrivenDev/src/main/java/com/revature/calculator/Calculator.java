package com.revature.calculator;

public class Calculator {

	public Calculator() {
	}

	public Double add(String toAdd) throws CalculatorException {
		double sum = 0.0;
		if (toAdd == null) {

			return 0.0;
		}

		if (!toAdd.equals("")) {
			// split the string toAdd on a , delimiter
			String[] numbers = toAdd.split(",");
//			for (String number : numbers) {
//				if (number == "%"|| number== "@"|| number=="$") {
//					throw new CalculatorException("incorrect characters");
//				}
//			}
//			if(numbers.length>=2) {
//				throw new CalculatorException("too many args");
//			}
			for (String number : numbers) {
				// parse the values as Doubles

				try {
					sum += Double.parseDouble(number);

				} catch (CalculatorException m) {
					throw new CalculatorException();
				}
			}

			// return their sum
			System.out.println(sum);
			return sum;
		}
		return sum;

	}
}