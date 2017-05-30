/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author NAN
 */
public class InstructionPanel {
    private JPanel instructionPanel;
    private JButton descriptionBtn,gameControlBtn,rulesBtn,backBtn;
    private JTextArea textField;
    private JFrame instructionFrame;
    
    public InstructionPanel(){
        instructionFrame = new JFrame();
        int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 1036) / 2;
    	int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2;
    	instructionFrame.setLocation(w, h);
    	Container contentPane = instructionFrame.getContentPane();
    	contentPane.setLayout(new BorderLayout());
    	//Create the instruction panel
        instructionPanel = new JPanel();
        instructionPanel.setLayout(new GridLayout(1, 4));
        textField = new JTextArea(20,20);
        textField.setLineWrap(true);
        textField.setWrapStyleWord(true);
        textField.setTabSize(4);
        textField.setBackground(Color.white);
        textField.setEditable(false);
        textField.setFont(new  java.awt.Font("Dialog",   1,   30));
        textField.setText("These are the objectives to accomplish in order to win the game."
        		+ "\n1.Count the Kiwis till 80% are discovered while exploring the Island."
        		+ "\n2.Trapping the remaining Predators till 80% are eliminated on the Island."
        		+ "\n3.Survive until your character have eliminated the Predators and counted the Kiwis while your character's stamina is above 1 percent.");
        
        
        descriptionBtn = new JButton("Description");
        descriptionBtn.addActionListener(new java.awt.event.ActionListener(){
        	@Override
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		textField.setText("These are the objectives to accomplish in order to win the game.\n"
                		+ "\n1.Count the Kiwis till 80% are discovered while exploring the Island."
                		+ "\n2.Trapping the remaining Predators till 80% are eliminated on the Island."
                		+ "\n3.Survive until your character have eliminated the Predators and counted the Kiwis while your character's stamina is above 1 percent.");
               	}
        });
        gameControlBtn = new JButton("Game Control");
        gameControlBtn.addActionListener(new java.awt.event.ActionListener(){
        	@Override
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		textField.setText("Keyboard and Mouse are the devices to control your character's movement."
        				+ "\n1.Using the keyboard arrow keys allows you to move your character's current position; Left Arrow to move West, "
                		+ "Up Arrow to move North, Right Arrow to move East and Down Arrow to move South."
                		+ "\n2.Using the mouse to click the desired Movement buttons i.e. West, North, East and South in the game board allows you to move your character's current position."
                		+ "\n3.Press F2 to pause the music, F1 for last song and F3 for next song."
                		+ "\n3.Press C to collect the items.");
        		
        	}
        });
        rulesBtn = new JButton("Game Rules");
        rulesBtn.addActionListener(new java.awt.event.ActionListener(){
        	@Override
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		textField.setText("The character's stamina in the game."
        				+ "\n1.Each step your character takes will deplete your stamina based on the color of the map. Hint: Different colored map has different percentage deduction on your stamina."
        				+ "\n2.When your character stamina reaches zero your character dies."
        				+ "\n3.When your character steps on different hazard either your character dies instantly or will lose stamina."
        				+ "\n4.Food would increase your character's stamina when consumed."
        				+ "\n5.Food would increase your backpack weight and size. "
        				+ "\n6.When your character's backpack size or weight reach its maximum, your character won't be able to carry any more Food and Tools."
        				+ "\n7.Tools can be used to trap Predators.");
        	}
        });
        backBtn = new JButton("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener(){
        	@Override
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		instructionFrame.dispose();
        	}
        });
        instructionPanel.add(descriptionBtn);
        instructionPanel.add(gameControlBtn);
        instructionPanel.add(rulesBtn);
        instructionPanel.add(backBtn);
        
        contentPane.add(instructionPanel, BorderLayout.NORTH);
        contentPane.add(textField, BorderLayout.CENTER);
        

        instructionFrame.setResizable(false);
        instructionFrame.setTitle("Instruction Page");  
        instructionFrame.setSize(1036, 800);  
        instructionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        instructionFrame.setVisible(true);  
    }
    
}
