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
	 private JRadioButton JRBSmall,JRBNormall,JRBBig, JRBBgm1,JRBBgm2,JRBBgm3,JRBCdv,JRBCmario,JRBCbm;
	 private ButtonGroup bgGroup,bsGroup,charGroup;
	 private JLabel bgLabel,boardsizeLabel,charcterLabel;
	 private String gameBgm = "1";
	 
	 public StartPage(final String username){
		 startFrame = new JFrame();
		 startPanel = new BackPanel("StartBg");
		 
	     int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 1036) / 2;
	     int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2;
	     startFrame.setLocation(w, h);
	     
	     //get images
	     ImageIcon startIcon = new ImageIcon(getClass().getResource("/images/icon/start.png"));
	     ImageIcon CancelIcon = new ImageIcon(getClass().getResource("/images/icon/Cancel.png"));
	     
	     //set labels
	     boardsizeLabel =new JLabel("Choose board size.(TODO for next sprint)",JLabel.CENTER);
	     boardsizeLabel.setFont(new Font("Dialog",1,20));
	     boardsizeLabel.setBounds(0,0,1036,25);
	     
	     charcterLabel =new JLabel("Choose your character.(TODO for next sprint)",JLabel.CENTER);
	     charcterLabel.setFont(new Font("Dialog",1,20));
	     charcterLabel.setBounds(0,380,1036,25);

	     bgLabel =new JLabel("Choose the background music.",JLabel.CENTER);
	     bgLabel.setFont(new Font("Dialog",1,20));
	     bgLabel.setBounds(0,200,1036,25);
	     
	     //Create start button       
	     JbStart = new JButton();
	     JbStart.setIcon(startIcon);
	     JbStart.setBounds(450, 600, 150, 50);
	     JbStart.addActionListener(new java.awt.event.ActionListener() {
	     @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	// create the game object
	    	 //startFrame.dispose();
	         final Game game = new Game(username,gameBgm);
	         // create the GUI for the game
	         final KiwiCountUI  gui  = new KiwiCountUI(game);
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
	      JbCancel.setBounds(450, 660, 150, 50);
	      JbCancel.addActionListener(new java.awt.event.ActionListener() {
	      @Override
	      public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	  	startFrame.dispose();
	    	  	new MainPage(username);;
	          }
	      });
	      
	      //set board size buttons
	      JRBSmall = new JRadioButton("Small (8x8)");
	      JRBSmall.setBounds(475,45,150,40);
	      JRBSmall.setOpaque(false);
	      JRBSmall.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}	    	  
	      });
	      
	      JRBNormall = new JRadioButton("Normall (10x10)");
	      JRBNormall.setBounds(475,85,150,40);
	      JRBNormall.setOpaque(false);
	      JRBNormall.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}	    	  
	      });
	      
	      JRBBig = new JRadioButton("Big (12x12)");
	      JRBBig.setBounds(475,125,150,40);
	      JRBBig.setOpaque(false);
	      JRBBig.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}	    	  
	      });
	      
	      //set background radio buttons
	      JRBBgm1 = new JRadioButton("Fight");
	      JRBBgm1.setBounds(475,230,90,35);
	      JRBBgm1.setOpaque(false);
	      JRBBgm1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameBgm = "1";
			}	    	  
	      });
	
	      
	      JRBBgm2 = new JRadioButton("Happy");
	      JRBBgm2.setBounds(475,265,90,35);
	      JRBBgm2.setOpaque(false);
	      JRBBgm2.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					gameBgm = "2";
				}	    	  
		      });
	      
	      JRBBgm3 = new JRadioButton("Relax");
	      JRBBgm3.setBounds(475,300,90,35);
	      JRBBgm3.setOpaque(false);
	      JRBBgm3.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					gameBgm = "3";
				}	    	  
		      });
	      
	      //set up character buttons
	      JRBCdv = new JRadioButton("Male");
	      JRBCdv.setBounds(550,400,100,50);
	      JRBCdv.setOpaque(false);
	      JRBCdv.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}	    	  
	      });
	      
	      JRBCmario = new JRadioButton("Female");
	      JRBCmario.setBounds(550,450,100,50);
	      JRBCmario.setOpaque(false);
	      JRBCmario.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}	    	  
	      });
	      
	      JRBCbm = new JRadioButton("Animal");
	      JRBCbm.setBounds(550,500,100,50);
	      JRBCbm.setOpaque(false);
	      JRBCbm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}	    	  
	      });
	      
	      bsGroup = new ButtonGroup();
	      bsGroup.add(JRBSmall);
	      bsGroup.add(JRBNormall);
	      bsGroup.add(JRBBig);
	      
	      bgGroup = new ButtonGroup();
	      bgGroup.add(JRBBgm1);
	      bgGroup.add(JRBBgm2);
	      bgGroup.add(JRBBgm3);
	      
	      charGroup = new ButtonGroup();
	      charGroup.add(JRBCdv);
	      charGroup.add(JRBCmario);
	      charGroup.add(JRBCbm);
	      
	     startPanel.setLayout(null);
	     startPanel.add(boardsizeLabel);
	     startPanel.add(JRBSmall);
	     startPanel.add(JRBNormall);
	     startPanel.add(JRBBig);
	     startPanel.add(bgLabel);
	     startPanel.add(JRBBgm1);
	     startPanel.add(JRBBgm2);
	     startPanel.add(JRBBgm3);
	     startPanel.add(charcterLabel);
	     startPanel.add(JRBCdv);
	     startPanel.add(JRBCmario);
	     startPanel.add(JRBCbm);
	     startPanel.add(JbStart);
	     startPanel.add(JbCancel);     
	       
	     startFrame.add(startPanel);
	     startFrame.setResizable(false);
	     startFrame.setTitle("Kiwi Island");  
	     startFrame.setSize(1036, 800);  
	     startFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
	     startFrame.setVisible(true);  
		 
	 }

}
