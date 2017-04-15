package nz.ac.aut.ense701.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackPanel extends JPanel {
        ImageIcon icon,gif2,gif3,gif4,gif5,gif6;  
        Image img;
        JLabel JLgif2,JLgif3,JLgif4,JLgif5,JLgif6;

        public BackPanel() {  
            //read the image from the folder 
            icon=new ImageIcon(getClass().getResource("/images/background/introdutionBg.jpg"));
            img=icon.getImage();
            
            
            gif2 = new ImageIcon(getClass().getResource("/images/gifs/gif2.gif"));
            JLgif2 = new JLabel();
            JLgif2.setIcon(gif2);
            JLgif2.setBounds(100,10,159,116);
            
            gif3 = new ImageIcon(getClass().getResource("/images/gifs/gif3.gif"));
            JLgif3 = new JLabel();
            JLgif3.setIcon(gif3);
            JLgif3.setBounds(50,250,120,158);
            
            gif4 = new ImageIcon(getClass().getResource("/images/gifs/gif4.gif"));
            JLgif4 = new JLabel();
            JLgif4.setIcon(gif4);
            JLgif4.setBounds(200,180,159,116);
            
            gif5 = new ImageIcon(getClass().getResource("/images/gifs/gif5.gif"));
            JLgif5 = new JLabel();
            JLgif5.setIcon(gif5);
            JLgif5.setBounds(740,100,280,217);
            
            gif6 = new ImageIcon(getClass().getResource("/images/gifs/gif6.gif"));
            JLgif6 = new JLabel();
            JLgif6.setIcon(gif6);
            JLgif6.setBounds(50,500,231,254);
            

            
            this.setLayout(null);
            this.add(JLgif2);
            this.add(JLgif3);
            this.add(JLgif4);
            this.add(JLgif5);
            this.add(JLgif6);
            
        } 
        
        public BackPanel(String bgname){
        	icon=new ImageIcon(getClass().getResource("/images/background/"+bgname+".jpg"));
            img=icon.getImage();
        }


        
        public void paintComponent(Graphics g) {  
            super.paintComponent(g);   
            g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);  
        }  
      
 }
