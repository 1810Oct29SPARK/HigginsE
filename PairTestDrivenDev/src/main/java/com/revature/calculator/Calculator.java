package com.revature.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public Calculator() {
		super();
	}

	public Double add(String toAdd) throws CalculatorException {
		
		Double sum = 0.0;
		
		String regex = "[^0-9\\.,]";
		
		if (toAdd != null && !toAdd.equals("")) {
			
			// find illegal characters
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(toAdd);
			if (m.find()) {
				throw new CalculatorException();
			}
			
			// split the string toAdd on a , delimiter
			String[] numbers = toAdd.split(",");
			
			// count the number of inputs
			int counter = 0;
			
			// loop to calculate the sum
			for (String str: numbers) {
				if (counter > 1) {
					continue;
				}
				sum += Double.parseDouble(str.trim());
				++counter;
			}
		}
		
		return sum;
	}

}
