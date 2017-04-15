package nz.ac.aut.ense701.gui;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import nz.ac.aut.ense701.userinfo.Userinfo;


  
public class RegisterPage{  
  
	private BackPanel registerPanel;
	private Userinfo user;
    private JButton JbRegister,JbCancel;  
    private JTextField JTUsername;  
    private JPasswordField JPwd,JPwdCheck;  
    private JLabel JLUsername,JLPwd,JLPwdCheck; 
    private String pwd,pwdCheck,username,usernameFormat,pwdFormat;
    private JFrame registerFrame;
    private boolean success=false;



    public RegisterPage()  
    {  
    	user = new Userinfo();
    	registerFrame = new JFrame();
    	int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 1036) / 2;
    	int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2;
    	registerFrame.setLocation(w, h);

    	ImageIcon RegisterIcon = new ImageIcon(getClass().getResource("/images/icon/Register.png"));
    	ImageIcon CancelIcon = new ImageIcon(getClass().getResource("/images/icon/Cancel.png"));
        //Create register button       
        JbRegister = new JButton();
        JbRegister.setIcon(RegisterIcon);
        JbRegister.setBounds(450, 600, 150, 50);
        JbRegister.addActionListener(new java.awt.event.ActionListener() {
        	@Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					db();
            	}
					catch(FileNotFoundException e)
			        {
			            System.err.println("Unable to find data file");
			        }
			        catch(IOException e)
			        {
			            System.err.println("Problem encountered processing file.");
			        }
            	if(success){
            		registerFrame.dispose();
            		new LoginPage();
            	}
            }
        });
        
        JbCancel=new JButton();
        JbCancel.setIcon(CancelIcon);
        JbCancel.setBounds(450, 660, 150, 50);
        JbCancel.addActionListener(new java.awt.event.ActionListener() {
        	@Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//close the register page
                registerFrame.dispose();
                new LoginPage();

            }
        });
        
          
      //Set up the username textfield and position
        JTUsername=new JTextField(15);  
        JTUsername.setBounds(475,400,200,25);
        
        //Set up the password textfield and position
        JPwd=new JPasswordField(15);
        JPwd.setBounds(475,450,200,25);
        
        //Set up the confirm password textfield and position
        JPwdCheck = new JPasswordField(15);
        JPwdCheck.setBounds(475,500, 200, 25);
          
        //Set up the username label and position
        JLUsername=new JLabel("Username:"); 
        JLUsername.setFont(new  java.awt.Font("Dialog",   1,   20));
        JLUsername.setForeground(Color.cyan);
        JLUsername.setBounds(350,400,200,25);
        
        //Set up password label and position.
        JLPwd=new JLabel("Password:");
        JLPwd.setBounds(350,450,200,25);
        JLPwd.setFont(new  java.awt.Font("Dialog",   1,   20));
        JLPwd.setForeground(Color.cyan);
        
        //Set up the confirm password label and position
        JLPwdCheck=new JLabel("Confirm Password:");
        JLPwdCheck.setBounds(270,500,200,25);
        JLPwdCheck.setFont(new  java.awt.Font("Dialog",   1,   20));
        JLPwdCheck.setForeground(Color.cyan);
        
        //Create a new panel and add elements into the panel  
        registerPanel=new BackPanel();
        registerPanel.setLayout(null);
        registerPanel.add(JbRegister);
        registerPanel.add(JbCancel);
        registerPanel.add(JTUsername);
        registerPanel.add(JLUsername);
        registerPanel.add(JPwd);
        registerPanel.add(JLPwd);
        registerPanel.add(JPwdCheck);
        registerPanel.add(JLPwdCheck);

        //Set frame          
        registerFrame.add(registerPanel); 
        registerFrame.setResizable(false);
        registerFrame.setTitle("Register Page");  
        registerFrame.setSize(1036, 800);  
        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        registerFrame.setVisible(true);  
    }
    
    /*
     * This method is used to check the input format and insert data to the database
     */
    public void db() throws IOException{
    	//the username format
    	usernameFormat = "[a-zA-Z0-9_]{5,15}";
    	//the password format.
    	pwdFormat = "[a-zA-Z0-9]{5,15}";
    	
    	username = JTUsername.getText().toString();
    	char[] pass= JPwd.getPassword();
    	pwd = String.valueOf(pass);
    	
    	pwdCheck = JPwdCheck.getPassword().toString();
    	char[] passChcek= JPwdCheck.getPassword();
    	pwdCheck = String.valueOf(passChcek);
    	
    	//Compile the pattern
    	Pattern userPattern = Pattern.compile(usernameFormat);
    	Pattern pwdPattern = Pattern.compile(pwdFormat);
    	
    	//Set usernmae, password, password check matcher
    	Matcher usernameMatcher = userPattern.matcher(username);
    	Matcher pwdMatcher = pwdPattern.matcher(pwd);
    	Matcher pwdCheckMatcher = pwdPattern.matcher(pwdCheck);
    	
    	if(usernameMatcher.matches())
    	{
    		if(pwd.equals(pwdCheck))
    		{
    			if(pwdMatcher.matches()&&pwdCheckMatcher.matches()){
    				user.checkUser(username);
    				if(!user.isFound()){
    					user.insertToFile(username, pwd);
    					success = true;
    					JOptionPane.showMessageDialog(null, "Register success!\n Username:"+username+"\n Password:"+pwd+"\nDon't forget your username and password!");
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null, "This username has been used,try another one.","Error!", JOptionPane.ERROR_MESSAGE);
    		    		JTUsername.setText("");
    		    		JPwd.setText("");
    					JPwdCheck.setText("");
    					JTUsername.requestFocus();
    				}
    				
    				
    			}else{
    				JOptionPane.showMessageDialog(null, "The password can only have numbers and letters, the length of password is between 5 to 15.","Error", JOptionPane.ERROR_MESSAGE);
    				JTUsername.setText("");
    	    		JPwd.setText("");
    				JPwdCheck.setText("");
    				JTUsername.requestFocus();
    			}
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null, "The password doesn't match","Error", JOptionPane.ERROR_MESSAGE);
    			JTUsername.setText("");
        		JPwd.setText("");
    			JPwdCheck.setText("");
    			JTUsername.requestFocus();
    		} 		
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null, "The username can only have numbers,letters and _,the length of username is between 5 to 15", "Error!", JOptionPane.ERROR_MESSAGE);
    		JTUsername.setText("");
    		JPwd.setText("");
			JPwdCheck.setText("");
			JTUsername.requestFocus();
    	}
    

    }

}  
