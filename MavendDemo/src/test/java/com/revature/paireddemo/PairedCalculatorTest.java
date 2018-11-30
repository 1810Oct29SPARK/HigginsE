package com.revature.paireddemo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
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
		}
		catch (CalculatorException m) {
			fail();
		}
		}

		
		@Test
		public void tooManyArguments() {
			try {
				assertEquals(46.6,c.add("12.9,15.3,0.1,18.3"),.001);
				
			} catch (CalculatorException m) {
				m.printStackTrace();;
			}
		}
		/*public void badCharacters() {
			try {
				assertEquals(28.2,c.add())
			}
		}*/
	}

