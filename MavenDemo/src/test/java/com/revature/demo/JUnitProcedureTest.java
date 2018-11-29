package com.revature.demo;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

//@Ignore will ignore the entire class
public class JUnitProcedureTest {
	
	//executes before anything happens
	@BeforeClass
	public static void beforeAllTests() {
		System.out.println("in beforeAllTests");
	}
	
	/*
	 * executes before each test
	 * can be placed anywhere all up in that code, and it'll still 
	 */
	@Before
	public void beforeTests() {
		System.out.println("in beforeTests");
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
	
	@After
	public void afterTests() {
		System.out.println("in afterTests");
	}

	//executes after everything happens
	@AfterClass
	public static void afterAllTests() {
		System.out.println("in afterAllTests");
	}
}
