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
	 private JRadioButton JRBSmall,JRBNormall,JRBBig,JRBCdv,JRBCmario,JRBCbm;
	 private ButtonGroup bsGroup,charGroup;
	 private JLabel boardsizeLabel,charcterLabel;
	 private String gameBgm = "1";
         private String gameCharacter = "warrior.png"; //defaults to warrior.png
	 
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
	     boardsizeLabel =new JLabel("Choose board size.(TODO for next sprint)",JLabel.CENTER);
	     boardsizeLabel.setFont(new Font("Dialog",1,20));
	     boardsizeLabel.setBounds(0,0,768,25);
	     
	     charcterLabel =new JLabel("Choose your character.",JLabel.CENTER);
	     charcterLabel.setFont(new Font("Dialog",1,20));
	     charcterLabel.setBounds(0,180,768,25);

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
	         final Game game = new Game(username,gameBgm,gameCharacter);
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
	      JRBSmall.setBounds(349,45,150,40);
	      JRBSmall.setOpaque(false);
	      JRBSmall.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}	    	  
	      });
	      
	      JRBNormall = new JRadioButton("Normall (10x10)");
	      JRBNormall.setBounds(349,85,150,40);
	      JRBNormall.setOpaque(false);
	      JRBNormall.setSelected(true);
	      JRBNormall.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}	    	  
	      });
	      
	      JRBBig = new JRadioButton("Big (12x12)");
	      JRBBig.setBounds(349,125,150,40);
	      JRBBig.setOpaque(false);
	      JRBBig.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}	    	  
	      });
	      
	      //set up character buttons
	      JRBCdv = new JRadioButton("Warrior");
	      JRBCdv.setSelected(true);
	      JRBCdv.setBounds(349,200,100,50);
	      JRBCdv.setOpaque(false);
	      JRBCdv.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
                            gameCharacter = "warrior.png";
			}	    	  
	      });
	      
	      JRBCmario = new JRadioButton("Archer");
	      JRBCmario.setBounds(349,240,100,50);
	      JRBCmario.setOpaque(false);
	      JRBCmario.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
                            gameCharacter = "archer.png";
			}	    	  
	      });
	      
	      JRBCbm = new JRadioButton("Wizard");
	      JRBCbm.setBounds(349,280,100,50);
	      JRBCbm.setOpaque(false);
	      JRBCbm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
                            gameCharacter = "wizard.png";
			}	    	  
	      });
	      
	      bsGroup = new ButtonGroup();
	      bsGroup.add(JRBSmall);
	      bsGroup.add(JRBNormall);
	      bsGroup.add(JRBBig);
	      

	      
	      charGroup = new ButtonGroup();
	      charGroup.add(JRBCdv);
	      charGroup.add(JRBCmario);
	      charGroup.add(JRBCbm);
	      
	     startPanel.setLayout(null);
	     startPanel.add(boardsizeLabel);
	     startPanel.add(JRBSmall);
	     startPanel.add(JRBNormall);
	     startPanel.add(JRBBig);
	     startPanel.add(charcterLabel);
	     startPanel.add(JRBCdv);
	     startPanel.add(JRBCmario);
	     startPanel.add(JRBCbm);
	     startPanel.add(JbStart);
	     startPanel.add(JbCancel);     
	       
	     startFrame.add(startPanel);
	     startFrame.setResizable(false);
	     startFrame.setTitle("Kiwi Island");  
	     startFrame.setSize(768, 576);  
	     startFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
	     startFrame.setVisible(true);  
		 
	 }

}
