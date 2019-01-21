package com.revature.sesi.utility;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class IndustryUtilityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreateSignedJsonWebTokenWithEmailSubject() {
		assertNotNull(IndustryUtility.createSignedJsonWebTokenWithEmailSubject("john.doe@example.com"));
	}

	@Test
	public void testGetEmailSubjectFromSignedJsonWebToken() {
		String secretEmail = IndustryUtility.generateRandomString(30);
		String testJws = IndustryUtility.createSignedJsonWebTokenWithEmailSubject(secretEmail);
		assertEquals(secretEmail, IndustryUtility.getEmailSubjectFromSignedJsonWebToken(testJws));
	}

}
