package nz.ac.aut.ense701.gameModel;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import nz.ac.aut.ense701.userinfo.Hashing;

public class LoginTest {
	public LoginTest(){
		
	}
	/*
	 * Test of verify method of UserInfo
	 */
	@Test
	public void checkVerify() throws IOException{
		Boolean verified = false;
		String username = "j499521010";
		String pwd  = "123123";
		String hashedPwd = Hashing.generatePassword(pwd);
		FileReader fr = new FileReader("UserInfo.txt");
	    BufferedReader br = new BufferedReader(fr);
	    String str = null;
	    while((str = br.readLine()) != null)
	    {
	        if(str.equals(username))
	        {
	            str = br.readLine();
	            if(str.equals(hashedPwd))
	            {
	                verified = true;
	            }
	            else
	            {
	            	verified = false;
	            }
	        }
	    }
	    Boolean expResult = true;
	    assertEquals(expResult,verified);
	}

}
