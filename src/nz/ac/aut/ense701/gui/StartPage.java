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
	 private JRadioButton JRBSmall,JRBNormall,JRBBig, JRBBgAnimal,JRBBgFruit,JRBBgNature,JRBBgMinions,JRBCdv,JRBCmario,JRBCbm;
	 private ButtonGroup bgGroup,bsGroup,charGroup;
	 private JLabel bgLabel,boardsizeLabel,charcterLabel;
	 private String gameBG = "Animal";
	 
	 public StartPage(){
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

	     bgLabel =new JLabel("Choose the background.",JLabel.CENTER);
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
	    	 startFrame.dispose();
	         final Game game = new Game();
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
	    	  	new IntroductionPage();
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
	      JRBBgAnimal = new JRadioButton("Animal");
	      JRBBgAnimal.setBounds(475,230,90,35);
	      JRBBgAnimal.setOpaque(false);
	      JRBBgAnimal.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameBG = "Animal";
			}	    	  
	      });
	      
	      JRBBgFruit = new JRadioButton("Fruit");
	      JRBBgFruit.setBounds(475,265,90,35);
	      JRBBgFruit.setOpaque(false);
	      JRBBgFruit.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					gameBG = "Fruit";
				}	    	  
		      });
	      
	      JRBBgNature = new JRadioButton("Nature");
	      JRBBgNature.setBounds(475,300,90,35);
	      JRBBgNature.setOpaque(false);
	      JRBBgNature.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					gameBG = "Nature";
				}	    	  
		      });
	      
	      JRBBgMinions = new JRadioButton("Minions");
	      JRBBgMinions.setBounds(475,335,90,35);
	      JRBBgMinions.setOpaque(false);
	      JRBBgMinions.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					gameBG = "Minions";
				}	    	  
		      });
	      
	      //set up character buttons
	      JRBCdv = new JRadioButton("Death Vader");
	      JRBCdv.setBounds(550,400,100,50);
	      JRBCdv.setOpaque(false);
	      JRBCdv.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}	    	  
	      });
	      
	      JRBCmario = new JRadioButton("Mario");
	      JRBCmario.setBounds(550,450,100,50);
	      JRBCmario.setOpaque(false);
	      JRBCmario.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}	    	  
	      });
	      
	      JRBCbm = new JRadioButton("Bat man");
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
	      bgGroup.add(JRBBgAnimal);
	      bgGroup.add(JRBBgFruit);
	      bgGroup.add(JRBBgNature);
	      bgGroup.add(JRBBgMinions);
	      
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
	     startPanel.add(JRBBgAnimal);
	     startPanel.add(JRBBgFruit);
	     startPanel.add(JRBBgNature);
	     startPanel.add(JRBBgMinions);
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

	public String getGameBG() {
		return gameBG;
	}

	public void setGameBG(String gameBG) {
		this.gameBG = gameBG;
	}
}
