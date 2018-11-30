package com.revature.calculator;

import java.util.regex.Pattern;

public class Calculator {

	public Calculator() {
	}
	
	public double add(String toAdd) throws CalculatorException {
		Double sum = 0.0;
		int count = 0;
		if(toAdd == null) {
			return 0;
		}
		if(Pattern.matches("[0-9],", toAdd)) {
			throw new CalculatorException();
		}
		try {
		if(!toAdd.equals("")) {
		//split the string toAdd on a , delimiter
		String[] numbers = toAdd.split(",");
		for(String number : numbers) {
		//parse the values as Doubles
			sum += Double.parseDouble(number);
			count++;
			if(count > 2) {
				throw new CalculatorException();
			}
		}
		//return their sum
		}
		return sum;
		}catch(Exception e)
        {
			
			throw new CalculatorException();
            //System.out.println("An error occurred: '{0}'" + e);
            //return 0;
        }
	}

}
