package com.revature.demo;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitProcedureTest {
	
	/*
	 * executes before all tests
	 */
	@BeforeClass
	public static void beforeAllTests() {
		System.out.println("in beforeAllTests");
	}
	
	/*
	 * executes after all tests
	 */
	@AfterClass
	public static void afterAllTests() {
		System.out.println("in afterAllTests");
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
	@Test
	public void testCase1() {
		System.out.println("in testCase1");
	}
	
	@Ignore //this will no longer run 
	@Test
	public void testCase2() {
		System.out.println("in testCase2");
		fail();
	}

}
