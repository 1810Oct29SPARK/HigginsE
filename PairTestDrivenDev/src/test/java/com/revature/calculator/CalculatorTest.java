package com.revature.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class CalculatorTest {
	
	private Calculator c;
	
	@Before
	public void setCalculator() throws Exception {
		this.c = new Calculator();
	}
	
	/*
	 * TDD
	 * red-green refactoring
	 * start with the req, write test, build code to match
	 * 
	 * Calculator requirements:
	 * (Calculator class) (computes Double values of comma-separated string)
	 * 1. calling add("") returns Double value of 0
	 * 2. calling add() with two comma-separated values returns the sum of those values
	 * 3. calling add() with null returns zero
	 * 4. calling add() with > 2 arguments throws CalculatorException
	 * 5. calling add() with incorrect characters (anything but , and Doubles throws CalculatorException)
	 */
	
	@Test
	public void emptyStringReturnsZero() {
		try {
			assertEquals(0, c.add(""), .001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //floating-point assertions require an offset
	}
	
	@Test
	public void twoNumbersReturnsSum() {
		try {
			assertEquals(28.2, c.add("12.9,15.3"), .001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void nullReturnsZero() {
		try {
			assertEquals(0, c.add(null), .001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void moreThanTwoArguments() {
		try {
			assertEquals("more than 2 arguments", c.add("4.5,5.4,6.7"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void nonNumericals() {
		try {
			assertEquals("numbers only plz", c.add("4.3,c.v"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
