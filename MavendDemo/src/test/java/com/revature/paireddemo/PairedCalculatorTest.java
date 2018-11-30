package com.revature.paireddemo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;


public class PairedCalculatorTest {

		private PairedCalculator c;

		@Before
		public void setCalculator() {
			this.c = new PairedCalculator();
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

		//@Test

		/*public void emptyStringReturnsZero() {
			assertEquals(0, c.add(""), .001); // floating-point assertions require an offset
			}
		
		
		@Test
		public void twoNumbersReturnsSum() {
			try {
				
			}
			assertEquals(28.2,c.add("12.9,15.3"),.001);
		}
		*/
		@Test
		public void nullAdd() {
			try {
			assertEquals(0.0,c.add(null),.001);
			fail ("Expected a CalculatoException to be thrown");
		} catch (CalculatorException m) {
			System.out.println("Too many arguments");
		}
		}
		
		@Test(expected = CalculatorException.class)
		public void tooManyArguments() {
			try {
				assertEquals(28.3,c.add("12.9,15.3,0.1"),.001);
				fail ("Expected an CalculatorException to be thrown");
			} catch (CalculatorException m) {
				System.out.println("Too many arguments");
			}
		}

	}

