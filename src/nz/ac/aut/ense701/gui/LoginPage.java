package nz.ac.aut.ense701.gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import nz.ac.aut.ense701.userinfo.Userinfo;

  
public class LoginPage{  
  
	private BackPanel loginPanel;
	private Userinfo user;
	private JFrame LoginFrame;
    private JButton JbLogin,JbRegister;  
    private JTextField JTUsername;  
    private JPasswordField JPwd;  
    private JLabel JLUsername,JLPwd; 
    private String pwd,username,usernameFormat,pwdFormat; 
    private boolean success = false;
      

    public LoginPage()  
    {  
    	user = new Userinfo();
    	LoginFrame = new JFrame();
    	int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 1036) / 2;
    	int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2;
    	LoginFrame.setLocation(w, h);
    	//Read the images
    	ImageIcon loginIcon = new ImageIcon(getClass().getResource("/images/icon/Login.png"));
    	ImageIcon RegisterIcon = new ImageIcon(getClass().getResource("/images/icon/Register.png"));
        //Create login button 
        JbLogin=new JButton();
        JbLogin.setBounds(450, 600, 150, 50);
        JbLogin.setIcon(loginIcon);
        JbLogin.addActionListener(new java.awt.event.ActionListener() {
        	@Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					verify();
				} catch(FileNotFoundException e)
                {
		            System.err.println("Unable to find data file");
		        }
		        catch(IOException e)
		        {
		            System.err.println("Problem encountered processing file.");
		        }
                if(success){
                	LoginFrame.dispose();
                    new MainPage(username);
                	
                }
            }
        });
        //Create cancel button       
        JbRegister=new JButton();
        JbRegister.setIcon(RegisterIcon);
        JbRegister.setBounds(450, 660, 150, 50);
        JbRegister.addActionListener(new java.awt.event.ActionListener() {
        	@Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//close the register page
                LoginFrame.dispose();
                new RegisterPage();
            }
        });
        
        //Set up the username textfield and position
        JTUsername=new JTextField(10);  
        JTUsername.setBounds(475,400,200,25);
        
        //Set up the password textfield and position
        JPwd=new JPasswordField(10);
        JPwd.setBounds(475,450,200,25);
          
        //Set up the username label and position
        JLUsername=new JLabel("Username:"); 
        JLUsername.setFont(new  java.awt.Font("Dialog",   1,   20));
        JLUsername.setForeground(Color.cyan);
        JLUsername.setBounds(350,400,200,25);
        
        //Set up password label and postion.
        JLPwd=new JLabel("Password:");
        JLPwd.setBounds(350,450,200,25);
        JLPwd.setFont(new  java.awt.Font("Dialog",   1,   20));
        JLPwd.setForeground(Color.cyan);
        
        //Create a new panel and add elements into the panel  
        loginPanel=new BackPanel();
        loginPanel.setLayout(null);
        loginPanel.add(JbLogin);
        loginPanel.add(JbRegister);
        loginPanel.add(JTUsername);
        loginPanel.add(JLUsername);
        loginPanel.add(JPwd);
        loginPanel.add(JLPwd);
        
        
          
        LoginFrame.add(loginPanel);  
        LoginFrame.setResizable(false);
        LoginFrame.setTitle("Login Page");  
        LoginFrame.setSize(1036, 800);  
        LoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        LoginFrame.setVisible(true);  
    } 
    
    public void verify() throws IOException{
    	//the username format
    	usernameFormat = "[a-zA-Z0-9_]{5,15}";
    	//the password format.
    	pwdFormat = "[a-zA-Z0-9]{5,15}";
    	
    	username = JTUsername.getText().toString();
    	char[] pass= JPwd.getPassword();
    	pwd = String.valueOf(pass);
    	
    	Pattern userPattern = Pattern.compile(usernameFormat);
    	Pattern pwdPattern = Pattern.compile(pwdFormat);
    	
    	//Set usernmae, password pattern
    	Matcher usernameMatcher = userPattern.matcher(username);
    	Matcher pwdMatcher = pwdPattern.matcher(pwd);
    	
    	if(usernameMatcher.matches())
    	{
    		if(pwdMatcher.matches())
    		{
    				user.verify(username, pwd);
    				if(user.isLoginFound())
    				{
    					if(user.isVerified())
    					{
    						success = true;
    						JOptionPane.showMessageDialog(null, "Welcome back! User "+username+"");
    					}
    					else
    					{
        					JOptionPane.showMessageDialog(null, "Password or Username is wrong","Error!", JOptionPane.ERROR_MESSAGE);
        		    		JTUsername.setText("");
        		    		JPwd.setText("");
        		    		JTUsername.requestFocus();
    					}	
    	              
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null, "This username doesn't exist.","Error!", JOptionPane.ERROR_MESSAGE);
    		    		JTUsername.setText("");
    		    		JPwd.setText("");
    		    		JTUsername.requestFocus();
    				}
    				
    				
    			}else{
    				JOptionPane.showMessageDialog(null, "The password can only have numbers and letters, the length of password is between 5 to 15.","Error", JOptionPane.ERROR_MESSAGE);
    				JTUsername.setText("");
    	    		JPwd.setText("");
    	    		JTUsername.requestFocus();
    			}
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null, "The username can only have numbers,letters and _,the length of username is between 5 to 15", "Error!", JOptionPane.ERROR_MESSAGE);
    		JTUsername.setText("");
    		JPwd.setText("");
    		JTUsername.requestFocus();
    	}
    }
  
}  
