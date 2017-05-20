package nz.ac.aut.ense701.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RankPanel { 
	private JPanel rankPanel;
	private JButton smallBoardBtn,normalBoardBtn,bigBoardBtn,backBtn;
	private JTextArea textField;
	private JFrame rankFrame;

	public RankPanel(){
	    rankFrame = new JFrame();
	    int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 1036) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2;
		rankFrame.setLocation(w, h);
		Container contentPane = rankFrame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		//Create the instruction panel
	    rankPanel = new JPanel();
	    rankPanel.setLayout(new GridLayout(1, 4));
	    textField = new JTextArea(20,20);
	    textField.setLineWrap(true);
	    textField.setWrapStyleWord(true);
	    textField.setTabSize(4);
	    textField.setBackground(Color.white);
	    textField.setEditable(false);
	    textField.setFont(new  java.awt.Font("Dialog",   1,   30));
	    textField.setText("");
	    smallBoardBtn = new JButton("Normal Board");
	    smallBoardBtn.addActionListener(new java.awt.event.ActionListener(){
	    	@Override
	    	public void actionPerformed(java.awt.event.ActionEvent evt){
	    		textField.setText("");
	           	}
	    });
	    normalBoardBtn = new JButton("Small Board");
	    normalBoardBtn.addActionListener(new java.awt.event.ActionListener(){
	    	@Override
	    	public void actionPerformed(java.awt.event.ActionEvent evt){
	    		textField.setText("");
	    		
	    	}
	    });
	    bigBoardBtn = new JButton("Big Board");
	    bigBoardBtn.addActionListener(new java.awt.event.ActionListener(){
	    	@Override
	    	public void actionPerformed(java.awt.event.ActionEvent evt){
	    		textField.setText("");
	    	}
	    });
	    backBtn = new JButton("Back");
	    backBtn.addActionListener(new java.awt.event.ActionListener(){
	    	@Override
	    	public void actionPerformed(java.awt.event.ActionEvent evt){
	    		rankFrame.dispose();
	    	}
	    });
	    rankPanel.add(smallBoardBtn);
	    rankPanel.add(normalBoardBtn);
	    rankPanel.add(bigBoardBtn);
	    rankPanel.add(backBtn);
	    
	    contentPane.add(rankPanel, BorderLayout.NORTH);
	    contentPane.add(textField, BorderLayout.CENTER);
	    
	
	    rankFrame.setResizable(false);
	    rankFrame.setTitle("Instruction Page");  
	    rankFrame.setSize(1036, 800);  
	    rankFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
	    rankFrame.setVisible(true);  
	}
	
}
	
	

