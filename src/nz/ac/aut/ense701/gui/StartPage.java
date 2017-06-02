package nz.ac.aut.ense701.gui;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nz.ac.aut.ense701.gameModel.Game;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class StartPage {
	
	 private JFrame startFrame;
	 private BackPanel startPanel;
	 private JButton JbStart,JbCancel;
	 private JRadioButton JRBSmall,JRBNormall,JRBBig;
	 private ButtonGroup bsGroup;
	 private JLabel boardsizeLabel;
	 private String gameBgm = "1";
     private String gameCharacter = "warrior.png"; //defaults to warrior.png
     private int gameBoard = 10;

	 
	 public StartPage(final String username){
		 startFrame = new JFrame();
		 startPanel = new BackPanel("startBg1");
		 
	     int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 768) / 2;
	     int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 576) / 2;
	     startFrame.setLocation(w, h);
	     
	     //get images
	     ImageIcon startIcon = new ImageIcon(getClass().getResource("/images/icon/start.png"));
	     ImageIcon CancelIcon = new ImageIcon(getClass().getResource("/images/icon/Cancel.png"));
	     
	     //set labels
	     boardsizeLabel =new JLabel("Choose board size",JLabel.CENTER);
	     boardsizeLabel.setFont(new Font("Dialog",1,20));
	     boardsizeLabel.setBounds(0,0,768,220);
	     
	     //Create start button       
	     JbStart = new JButton();
	     JbStart.setIcon(startIcon);
	     JbStart.setBounds(309, 400, 150, 50);
	     JbStart.addActionListener(new java.awt.event.ActionListener() {
	     @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	// create the game object
	    	 //startFrame.dispose();
	    	 startFrame.dispose();
	         final Game game = new Game(username,gameBgm,gameCharacter,gameBoard);

	         // create the GUI for the game
	         final KiwiCountUI  gui  = new KiwiCountUI(game);
	         Thread newThread = new Thread(gui);
	         newThread.start();
	         gui.requestFocus();
	         // make the GUI visible
	         java.awt.EventQueue.invokeLater(new Runnable() 
	         {
	             @Override
	             public void run() 
	             {
	                 gui.setVisible(true);
	             }
	         });
	          }
	      });
	     
	     
	   
	      //create cancel button  
	      JbCancel=new JButton();
	      JbCancel.setIcon(CancelIcon);
	      JbCancel.setBounds(309, 475, 150, 50);
	      JbCancel.addActionListener(new java.awt.event.ActionListener() {
	      @Override
	      public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	  	startFrame.dispose();
	    	  	new MainPage(username);;
	          }
	      });
	      
	      //set board size buttons
	      JRBSmall = new JRadioButton("Small (8x8)");
	      JRBSmall.setBounds(349,140,150,40);
	      JRBSmall.setOpaque(false);
	      JRBSmall.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameBoard = 8;

			}	    	  
	      });
	      
	      JRBNormall = new JRadioButton("Normall (10x10)");
	      JRBNormall.setBounds(349,180,150,40);
	      JRBNormall.setOpaque(false);
	      JRBNormall.setSelected(true);
	      JRBNormall.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameBoard = 10;

			}	    	  
	      });
	      
	      JRBBig = new JRadioButton("Big (12x12)");
	      JRBBig.setBounds(349,220,150,40);
	      JRBBig.setOpaque(false);
	      JRBBig.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameBoard = 12;
			}	    	  
	      });
	      
	      
	      bsGroup = new ButtonGroup();
	      bsGroup.add(JRBSmall);
	      bsGroup.add(JRBNormall);
	      bsGroup.add(JRBBig);
	      
	     startPanel.setLayout(null);
	     startPanel.add(boardsizeLabel);
	     startPanel.add(JRBSmall);
	     startPanel.add(JRBNormall);
	     startPanel.add(JRBBig);
	     startPanel.add(JbStart);
	     startPanel.add(JbCancel);     
	       
	     startFrame.add(startPanel);
	     startFrame.setResizable(false);
	     startFrame.setTitle("Kiwi Island");  
	     startFrame.setSize(768, 576);  
	     startFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
	     startFrame.setVisible(true);  
		 
	 }
	 
	 public static void main(String[] args){
		 new StartPage("2");
	 }
}
