package com.revature.paireddemo;

public class PairedCalculator {
	
	public PairedCalculator() {
		}

		public Double add(String toAdd) throws CalculatorException
		{
			Double sum = 0.0;
			if (toAdd == null) {
				return 0.0;
				}
			
			if (!toAdd.equals("")) {
				// split the string toAdd on a , delimiter
				String[] numbers = toAdd.split(",");
				for (String number : numbers) {
					// parse the values as Doubles
					sum += Double.parseDouble(number);
				
				}
			}
			// return their sum
			return sum;
		}
	
	}


