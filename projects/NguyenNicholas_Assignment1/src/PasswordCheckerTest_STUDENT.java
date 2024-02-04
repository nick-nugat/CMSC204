
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Nicholas Nguyen
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		String[] p = {
				"406245nfsadfJ#",
				"nicky1062fn",
				"22610Bh",
				"dsa;lkfjdsakl;jd",
				"!!fdhsahdjf!1",
				"batter20515t",
				"*NCD2iXMaqKE6t",
				"9WP@og78LBZ*dV",
				"operate-catfish-extortion",
				"3e^@$ESz8nT&gA"
		};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("501cgnaerq#A"));
			assertTrue("Did not throw lengthException", true);
		} catch(LengthException e){
			fail("Throws LengthException");
		} catch(Exception e){
			assertTrue("Threw another exception", true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("123456asdfasdf"));
			fail("Did not throw NoUpperAlphaException");
		} catch(NoUpperAlphaException e) {
			assertTrue("Threw a NoUpperAlphaException",true);
		} catch(Exception e) {
			fail("Threw some other exception besides NoUpperAlphaException");
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("aghdkjferwklaj14234#2"));
			assertTrue("Did not throw NoLowerAlphaException", true);
		} catch(NoLowerAlphaException e) {
			fail("Threw a NoLowerAlphaException");
		} catch(Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", true);
		}
	}
	/**
	 * Test if the password is weak
	 * Throws a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		try{
			assertTrue(PasswordCheckerUtility.isWeakPassword("ghkei25dx"));
			fail("Didn't throw WeakPasswordException");
		} catch(WeakPasswordException e){
			assertTrue("Threw WeakPasswordException", true);
		} catch(Exception e){
			fail("Threw other exception");
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("63dkxcma;eldkfj#aazZ"));
			fail("Did not throw an InvalidSequenceException");
		} catch(InvalidSequenceException e) {
			assertTrue("Successfully threw an InvalidSequenceException",true);
		}
		catch(Exception e) {
			fail("Threw some other exception besides an InvalidSequenceException");
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {

	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		fail("Not implemented by student yet");
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		fail("Not implemented by student yet");
	}
	
}
