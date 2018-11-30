package com.revature.demo;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitProcedureTest {
	
	@Test
	public void testCase1() {
		System.out.println("in testCase1");
	}
	
	@Ignore //This will no longer run
	@Test
	public void testCase2() {
		System.out.println("in testCase2");
		fail();
	}
	
	/*
	 * executes after all tests, should be static
	 */
	
	@AfterClass
	public static void AfterAllTests() {
		System.out.println("in afterAllTests");
	}
	
	
	/*
	 * executes before all tests, should be static 
	 * because they execute before anything else
	 */
	
	@BeforeClass
	public static void beforeAllTests() {
		System.out.println("in beforeAllTests");
	}
	
	
	/*
	 * executes before each test
	 */
	
	@Before
	public void beforeTests() {
		System.out.println("in beforeTests");
	}
	
	/*
	 * executes after each test
	 */
	
	@After
	public void afterTests() {
		System.out.println("in afterTests");
	}
	
}
