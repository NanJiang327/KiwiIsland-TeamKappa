package nz.ac.aut.ense701.gui;

import java.awt.*;  
import javax.swing.*;  
  
public class LoginPage{  
  
	BackPanel loginPanel;
	JFrame loginFrame;
    JButton JbLogin,JbCancel;  
    JTextField JTUsername;  
    JPasswordField JPwd;  
    JLabel JLUsername,JLPwd;  
      

    public LoginPage()  
    {  
    	
    	JFrame LoginFrame = new JFrame();
    	int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 1036) / 2;
    	int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2;
    	LoginFrame.setLocation(w, h);
    	//Read the images
    	ImageIcon loginIcon = new ImageIcon(getClass().getResource("/images/icon/Login.png"));
    	ImageIcon CancelIcon = new ImageIcon(getClass().getResource("/images/icon/Cancel.png"));
        //Create login button 
        JbLogin=new JButton();
        JbLogin.setBounds(450, 600, 150, 50);
        JbLogin.setIcon(loginIcon);
        JbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        //Create cancel button       
        JbCancel=new JButton();
        JbCancel.setIcon(CancelIcon);
        JbCancel.setBounds(450, 660, 150, 50);
        JbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//close the register page
                LoginFrame.dispose();
                new IntroductionPage();
            }
        });
        
        //Set up the username textfield and position
        JTUsername=new JTextField(10);  
        JTUsername.setBounds(475,400,200,25);
        
        //Set up the password textfield and position
        JPwd=new JPasswordField(10);
        JPwd.setBounds(475,450,200,25);
          
        //Set up the username label and position
        JLUsername=new JLabel("Username£º"); 
        JLUsername.setFont(new  java.awt.Font("Dialog",   1,   20));
        JLUsername.setForeground(Color.cyan);
        JLUsername.setBounds(350,400,200,25);
        
        //Set up password label and postion.
        JLPwd=new JLabel("Password£º");
        JLPwd.setBounds(350,450,200,25);
        JLPwd.setFont(new  java.awt.Font("Dialog",   1,   20));
        JLPwd.setForeground(Color.cyan);
        
        //Create a new panel and add elements into the panel  
        loginPanel=new BackPanel();
        loginPanel.setLayout(null);
        loginPanel.add(JbLogin);
        loginPanel.add(JbCancel);
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
  
}  
