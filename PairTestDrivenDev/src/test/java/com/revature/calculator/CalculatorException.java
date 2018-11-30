package com.revature.calculator;

public class CalculatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculatorException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public CalculatorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CalculatorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CalculatorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	public static void tooManyArgs() {
//		System.out.println("too many args");
//	}

}
