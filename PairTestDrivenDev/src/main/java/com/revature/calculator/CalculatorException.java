package com.revature.calculator;

public class CalculatorException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculatorException() {
	}
	
	public CalculatorException(String arg){
		super(arg);
	}
	
	public CalculatorException(Throwable cause){
		super(cause);
	}
	
	
}
