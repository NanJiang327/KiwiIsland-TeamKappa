package nz.ac.aut.ense701.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RankPanel { 
	private JPanel rankPanel;
	private JButton smallBoardBtn,normalBoardBtn,bigBoardBtn,backBtn;
	private JTable rankTable;
	private DefaultTableModel tableModel;
	private JFrame rankFrame;
	private Object[][] data;
	private JScrollPane JSP;
	public RankPanel() throws IOException{
	    rankFrame = new JFrame();
	    int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 1036) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2;
		rankFrame.setLocation(w, h);
		Container contentPane = rankFrame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		//Create the instruction panel
	    rankPanel = new JPanel();
	    rankPanel.setLayout(new GridLayout(1, 4));
	    String[] columnNames = {"Name","Time (Minutes : Seconds)"};
	    tableModel = new DefaultTableModel(data,columnNames);
	    rankTable = new JTable(tableModel);
	    rankTable.setRowSelectionAllowed (false);
	    rankTable.setColumnSelectionAllowed(false);
	    rankTable.setShowGrid (false);
	    rankTable.setRowHeight (35);
	    rankTable.setFont(new  java.awt.Font("Dialog",   0,   30));
	    rankTable.getTableHeader().setFont(new java.awt.Font("Dialog",   0,   30));
	    rankTable.getTableHeader().setBackground(Color.CYAN);
	    readFileToMap("normalHistory");
	    JSP = new JScrollPane(rankTable);

	    smallBoardBtn = new JButton("Normal Board");
	    smallBoardBtn.addActionListener(new java.awt.event.ActionListener(){
	    	@Override
	    	public void actionPerformed(java.awt.event.ActionEvent evt){
	    			tableModel.setRowCount(0);
	    			try {
						readFileToMap("normalHistory");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           	}
	    });
	    normalBoardBtn = new JButton("Small Board");
	    normalBoardBtn.addActionListener(new java.awt.event.ActionListener(){
	    	@Override
	    	public void actionPerformed(java.awt.event.ActionEvent evt){
	    		tableModel.setRowCount(0);
	    		try {
					readFileToMap("smallHistory");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
	    });
	    bigBoardBtn = new JButton("Big Board");
	    bigBoardBtn.addActionListener(new java.awt.event.ActionListener(){
	    	@Override
	    	public void actionPerformed(java.awt.event.ActionEvent evt){
	    		tableModel.setRowCount(0);
	    		try {
					readFileToMap("bigHistory");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
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
	    contentPane.add(JSP, BorderLayout.CENTER);
	    
	
	    rankFrame.setResizable(false);
	    rankFrame.setTitle("Instruction Page");  
	    rankFrame.setSize(1036, 800);  
	    rankFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
	    rankFrame.setVisible(true);  
	}
	
	public void readFileToMap(String fileName) throws IOException{
		FileReader fr = new FileReader(""+fileName+".txt");
	    BufferedReader br = new BufferedReader(fr);
	    String str = null;
	    HashMap<String, String> map = new HashMap<String, String>();
	    while((str = br.readLine()) != null)
	    {
	    	String time = br.readLine();
	    	String newStr = time.replace("."," : ");
	    	System.out.println(newStr+"");
	    	map.put(str, newStr);
	    }
	    
	   
         List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            @Override
            public int compare(Entry<String, String> o1,
                    Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
            
        });
        int i = 0;
        for(Map.Entry<String,String> mapping:list){
        	i++;
        	String[] newRow = {mapping.getKey(),mapping.getValue()};
        	tableModel.addRow(newRow);
        	if(i>10){
        		break;
        	}
         }
	    
	}
	
}
	
	

