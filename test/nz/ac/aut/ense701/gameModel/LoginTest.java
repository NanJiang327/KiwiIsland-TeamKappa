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
	public void checkIfSuccess() throws IOException{
		userinfo = new Userinfo();
		Boolean verified = true;
		String username = "j234567";
		String pwd  = "123123";
	    userinfo.verify(username, pwd);
	    assertEquals(userinfo.isVerified(),verified);
	   
	}
	
	@Test
	public void checkIffail() throws IOException{
		userinfo = new Userinfo();
		Boolean verified = false;
		String username = "j234567";
		String pwd  = "12312323";
	    userinfo.verify(username, pwd);
	    assertEquals(userinfo.isVerified(),verified);
	   
	}


}
