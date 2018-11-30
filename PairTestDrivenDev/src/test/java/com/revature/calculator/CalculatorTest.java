package com.revature.calculator;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

	private Calculator c;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@BeforeClass
	public static void startMsg() {
		System.out.println("Calculator Test Starting...");
	}
	
	@AfterClass
	public static void endMsg() {
		System.out.println("Calculator Test Ends.");
	}

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
		assertEquals(0, c.add(""), .001); // floating-point assertions require an offset
	}
	
	@Test
	public void twoNumbersReturnsSum() {
		assertEquals(28.2, c.add("12.9,15.3"), .001);
	}
	
	@Test
	public void nullReturnsZero() {
		assertEquals(0, c.add(null), .001);
	}
	@Test
	public void moreThanTwoInputs() {
		assertEquals(4.9, c.add("3.2,1.7,4555.09"), .001);
	}
	
	@Test
	public void incorrectCharacters() {
		expectedException.expect(CalculatorException.class);
		c.add("3.5, %, 8.9&, !");
	}

}
