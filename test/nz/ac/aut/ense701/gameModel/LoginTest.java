package nz.ac.aut.ense701.gameModel;

import static org.junit.Assert.*;

import java.io.IOException;
import nz.ac.aut.ense701.userinfo.Userinfo;

import org.junit.Test;

import nz.ac.aut.ense701.userinfo.Hashing;

public class LoginTest {
	private Userinfo userinfo;
	
	public LoginTest(){
		
	}
	/*
	 * Test of verify method of UserInfo
	 */
	@Test
	public void checkVerify() throws IOException{
		Boolean verified = true;
		String username = "j499521010";
		String pwd  = "123123";
		String hashedPwd = Hashing.generatePassword(pwd);
	    userinfo.verify(username, hashedPwd);
	    assertEquals(userinfo.isVerified(),verified);
	   
	}

}
