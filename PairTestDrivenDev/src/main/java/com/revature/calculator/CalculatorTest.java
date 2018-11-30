package com.revature.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
	
	@Test
	public void emptyStringReturnsZero() {
		try {
			assertEquals(0.0, c.add(""), .001);
		} catch (CalculatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		} // floating-point assertions require an offset
	}
	
	@Test
	public void twoNumbersReturnsSum() {
		try {
			assertEquals(28.2,c.add("12.9,15.3"),.001);
		} catch (CalculatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void nullReturnsZero() {
		try {
			assertEquals(0.0, c.add(null),.001);
		} catch (CalculatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void tooManyArgues() {
        try {
            assertEquals(28.3,c.add("12.9,15.3,0.1"),.001);
        } catch (CalculatorException m) {
            m.printStackTrace();
        }
      
	}
	
	@Test
	public void wrongCharacters() {
		try {
			c.add("44,55,@");
		} catch (CalculatorException m) {
			m.printStackTrace();
		}
	}

}
