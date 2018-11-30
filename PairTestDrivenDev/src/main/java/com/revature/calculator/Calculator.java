package com.revature.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			Pattern p = Pattern.compile("[0-9]|.");
			Matcher m = p.matcher(toAdd);
			if (numbers.length > 2) {
				throw new CalculatorException("Too many arguments!");
			}else if (m.find() == false) { //regular expression catching numbers and the decimal point
				throw new CalculatorException("message");
			}
			
			for (String number : numbers) {
				// parse the values as Doubles
				sum += Double.parseDouble(number);
			}
		}
		// return their sum
		return sum;
	}
}
