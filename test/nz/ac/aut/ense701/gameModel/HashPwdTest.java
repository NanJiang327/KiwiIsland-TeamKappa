package nz.ac.aut.ense701.gameModel;

import static org.junit.Assert.*;

import org.junit.Test;

import nz.ac.aut.ense701.userinfo.Hashing;

public class HashPwdTest {
	public HashPwdTest(){
		
	}
	/*
	 * Test of  generatePassword method of class Hashing.
	 */
	@Test
	public void testHashedPwd(){
		String pwd = "123123";
		String hashedPwd = "";
		String expResult = "4297F44B13955235245B2497399D7A93";
		hashedPwd = Hashing.generatePassword(pwd);
		assertEquals(expResult,hashedPwd);
		
	}

}
