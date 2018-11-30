package com.revature.calculator;

public class Calculator {

	public Calculator() {
	}

	public Double add(String toAdd) throws CalculatorException {
		Double sum = 0.0;
		if (toAdd == null) {
			return 0.0;
		}
		
		else if (!toAdd.equals("")) {
			// if input contains invalid characters 
			String input = toAdd;
			for (int i = 0; i < input.length; i++) {
				if (input.charAt(i).matches(["\\^,.[0-9]"])) {
					throw new CalculatorException("Invalid characters");
				}
			}
			
			// split the string toAdd on a , delimiter
			String[] numbers = toAdd.split(",");
			
			
			if (numbers.length > 2) {
				throw new CalculatorException("Too many numbers!");
			}
			// for each number if it contains anything other than commas or Doubles, throw Exception
			
			for (int i = 0; i < numbers.length; i++) {
				for (int j = 0; j <num.length(); j++) { 
					
			}
			for (String number : numbers) {
				// parse the values as Doubles
				sum += Double.parseDouble(number);
			}
			
		}
		
		
		// return their sum
		return sum;
	}
	
	}}
