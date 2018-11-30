package com.revature.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

	private Calculator c;

	@Before
	public void setCalculator() {
		this.c = new Calculator();
	}

	/*
	 * TDD: red-green refactoring start with requirement, write test, build code to
	 * match
	 * 
	 * Calculator requirements: (Calculator class) (computes Double values of
	 * comma-separated string) 
	 * 1. calling add("") returns Double value of 0 
	 * 2. calling add() with two comma-separated values returns 
	 * the sum of those values
	 * 3. calling add() with null returns zero
	 * 4. calling add() with > 2 arguments throws CalculatorException
	 * 5. calling add() with incorrect characters (anything but , and Doubles)
	 * throws CalculatorException 
	 */
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	
	@Test
	public void toManyArguments() {
		try {
			assertEquals("more than 2 arguments", c.add("4.9,6.9,4.2"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void emptyStringReturnsZero() {
		try {
			assertEquals(0, c.add(""), .001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // floating-point assertions require an offset
	}
	
	@Test
	public void twoNumbersReturnsSum() {
		try {
			assertEquals(28.2,c.add("12.9,15.3"),.001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void returnZeroIfNull() {
		try {
			assertEquals(0,c.add(null),.001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
