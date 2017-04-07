package nz.ac.aut.ense701.gui;


import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IntroductionPage {

	    BackPanel IntroPanel;
		JFrame IntroFrame;
	    JButton JbLogin,JbRegister;    
	    JPanel introPanel;
	    LoginPage loginPage;
	    RegisterPage registerPage;
	    
	    
	    public static void main(String[] args) {  
	        // TODO Auto-generated method stub  
	        new IntroductionPage();  
	    }  
	    public IntroductionPage()  
	    {  
	    	
	    	IntroFrame = new JFrame();
	    	int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 1036) / 2;
	    	int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2;
	    	IntroFrame.setLocation(w, h);
	        //Components 
	    	//Read the images
	    	ImageIcon loginIcon = new ImageIcon(getClass().getResource("/images/icon/Login.png"));
	    	ImageIcon RegisterIcon = new ImageIcon(getClass().getResource("/images/icon/Register.png"));
	    	//set up login button
	        JbLogin=new JButton();
	        JbLogin.setBounds(450, 600, 150, 50);
	        JbLogin.setIcon(loginIcon);
	        JbLogin.addActionListener(new java.awt.event.ActionListener() {
	        	@Override
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	loginPage = new LoginPage();
	            	IntroFrame.dispose();
	                
	            }
	        });
	        //set up register button       
	        JbRegister = new JButton();
	        JbRegister.setBounds(450, 660, 150, 50);
	        JbRegister.setIcon(RegisterIcon);
	        JbRegister.addActionListener(new java.awt.event.ActionListener() {
	        	@Override
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                registerPage = new RegisterPage();
	                IntroFrame.dispose();
	            }
	        });
	        
	        //Create the a null layout panel
	        introPanel = new BackPanel();
	        introPanel.setLayout(null);
	        //add buttons into the panel
	        introPanel.add(JbLogin);
	        introPanel.add(JbRegister);
	        
	        IntroFrame.add(introPanel);  

	        //Set frame size, title.
	        IntroFrame.setResizable(false);
	        IntroFrame.setTitle("Kiwi Island");  
	        IntroFrame.setSize(1036, 800);  
	        IntroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        IntroFrame.setVisible(true);  
	    } 
	    	  
}  



