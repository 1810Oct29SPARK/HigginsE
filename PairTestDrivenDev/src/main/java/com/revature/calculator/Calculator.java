package com.revature.calculator;

public class Calculator {

	public Calculator() {
	}

	public Double add(String toAdd) throws CalculatorException {
		Double sum = 0.0;
		if (toAdd == null) {
			return 0.0;
		}
		
		String[] numbers = toAdd.split(",");
		System.out.println(numbers);
		
		
		if (!toAdd.equals("")) {
			// if input contains invalid characters 
			for (int i = 0; i < numbers.length; i++) {
				String number = numbers[i];
				if (!number.contains(".")) {
					throw new CalculatorException("Not a double");
				}
				if (number.contains("[^0-9.]")) {
					throw new CalculatorException("Invalid characters");
				}
			}
		}
			
			
			
			if (numbers.length > 2) {
				throw new CalculatorException("Too many numbers!");
			}
			// for each number if it contains anything other than commas or Doubles, throw Exception
			
			for (int i = 0; i < numbers.length; i++) {
				for (int j = 0; j <numbers.length; j++) { 
					
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
