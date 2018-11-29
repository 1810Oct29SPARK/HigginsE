package com.revature.calculator;

public class Calculator {

	public Calculator() {
		super();
	}

	public Double add(String toAdd) {
		
		Double sum = 0.0;
		
		if (toAdd != null && !toAdd.equals("")) {
			
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
