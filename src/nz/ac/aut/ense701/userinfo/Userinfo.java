package nz.ac.aut.ense701.userinfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Userinfo {

    private boolean found;
    private boolean loginFound;
    private boolean verified;
    private String hashedPwd;

	public void checkUser(String username) throws IOException{
		found = false;
		FileReader fr = new FileReader("UserInfo.txt");
	    BufferedReader br = new BufferedReader(fr);
	    String str = null;
	    while((str = br.readLine()) != null)
	    {
	        if(str.equals(username))
	        {
	        	found = true;
	        	break;
	        }
	    }	
	}
	
	public void insertToFile(String username,String pwd) throws IOException{
		hashedPwd = Hashing.generatePassword(pwd);
		FileWriter filewriter = new FileWriter("UserInfo.txt",true);
        BufferedWriter out = new BufferedWriter(filewriter);  
        out.write(""+username+"\n"+hashedPwd+"");
        out.newLine();
        out.flush();  
        out.close();  
		
	}
	
	public void verify(String username,String pwd) throws IOException{
			loginFound = false;
			hashedPwd = Hashing.generatePassword(pwd);
			FileReader fr = new FileReader("UserInfo.txt");
		    BufferedReader br = new BufferedReader(fr);
		    String str = null;
		    while((str = br.readLine()) != null)
		    {
		        if(str.equals(username))
		        {
		        	loginFound = true;
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
	}

	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}	
	
	
	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public boolean isLoginFound() {
		return loginFound;
	}

	public void setLoginFound(boolean loginFound) {
		this.loginFound = loginFound;
	}
	
}
			  


