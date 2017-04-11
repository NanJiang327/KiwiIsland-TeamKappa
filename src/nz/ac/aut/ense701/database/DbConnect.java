package nz.ac.aut.ense701.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnect {
	private String url ="jdbc:mysql://se2017db.cpm46kcfxj7j.us-west-2.rds.amazonaws.com/se2017db";
	private String user = "j499521010";
	private String dbpwd = "123.comwyxx";

    private boolean found;
    private boolean loginFound;
    private boolean verified;

	public void checkDB(String username){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			found = false;
			Connection connection = DriverManager.getConnection(url,user,dbpwd);
			System.out.println("Success connect Mysql server!"); 
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Users");
		    while (rs.next()) {
		          if(username.equals(rs.getString("Username"))){
		        	  found =true;
		        	  break;
		          }
		     }

		 }
		 catch (Exception e) {
		        System.out.print("Can't connect to server");
		        e.printStackTrace();
		        
		 }	  
	}
	
	public void insertToDb(String username,String pwd){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				Connection connection = DriverManager.getConnection(url,user,dbpwd);
				PreparedStatement ps = connection.prepareStatement("INSERT INTO Users VALUES ('"+username+"','"+pwd+"',null)");
				ps.executeUpdate();

			 }
			 catch (Exception e) {
			        System.out.print("Can't connect to server");
			        e.printStackTrace();
			        
			 }	
		
	}
	
	public void verify(String username,String pwd){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				loginFound = false;
				Connection connection = DriverManager.getConnection(url,user,dbpwd);
				System.out.println("Success connect Mysql server!"); 
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Users");
			    while (rs.next()) {
			          if(username.equals(rs.getString("Username"))){
			        	  loginFound = true;
			        	  if(pwd.equals(rs.getString("Password"))){
				    		  verified = true;
				    	  }else{
				    		  verified = false;
				    	  }
			        	  break;
			          }

			     }

			 }
			 catch (Exception e) {
			        System.out.print("Can't connect to server");
			        e.printStackTrace();     
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
			  


