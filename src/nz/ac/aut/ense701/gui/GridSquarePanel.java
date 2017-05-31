package nz.ac.aut.ense701.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.sun.javafx.scene.control.skin.LabeledText;

import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Terrain;

/*
 * Panel for representing a single GridSquare of the island on the GUI.
 * 
 * @author AS
 * @version 1.0 - created
 */

public class GridSquarePanel extends javax.swing.JPanel 
{
    private Image backgroundImage;
    
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(bgImage, 0, 0, null);
//    }
    /** 
     * Creates new GridSquarePanel.
     * @param game the game to represent
     * @param row the row to represent
     * @param column the column to represent
     */
    public GridSquarePanel(Game game, int row, int column)
    {
        this.game   = game;
        this.row    = row;
        this.column = column;
        initComponents();
    }

    /**
     * Updates the representation of the grid square panel.
     */
    public void update()
    {
        // get the GridSquare object from the world
        Terrain terrain   = game.getTerrain(row, column);
        boolean squareVisible = game.isVisible(row, column);
        boolean squareExplored = game.isExplored(row, column);
        if(game.getGameBoardSize()==8){
	        switch ( terrain )
	        {
	                case SAND     : 
	                	setBigImage("sand.png");
	                	break;
	                case FOREST   : 
	                	setBigImage("green.png");  
	                	break;
	                case WETLAND : 
	                	setBigImage("wet.png");
	                	break;
	                case SCRUB : 
	                	setBigImage("scrub.png");
	                	break;
	                case WATER    : 
	                	setBigImage("water.png");
	                	break;
	                default  : setBigImage(game.getGameCharacter()); break;
	
	        }
        }
        
        if(game.getGameBoardSize()==10){
	        switch ( terrain )
	        {
	                case SAND     : 
	                	setImage("sand.png");
	                	break;
	                case FOREST   : 
	                	setImage("green.png");  
	                	break;
	                case WETLAND : 
	                	setImage("wet.png");
	                	break;
	                case SCRUB : 
	                	setImage("scrub.png");
	                	break;
	                case WATER    : 
	                	setImage("water.png");
	                	break;
	                default  : setImage(game.getGameCharacter()); break;
	
	        }
        }
        
        if(game.getGameBoardSize()==12){
	        switch ( terrain )
	        {
	                case SAND     : 
	                	setSmallImage("sand.png");
	                	break;
	                case FOREST   : 
	                	setSmallImage("green.png");  
	                	break;
	                case WETLAND : 
	                	setSmallImage("wet.png");
	                	break;
	                case SCRUB : 
	                	setSmallImage("scrub.png");
	                	break;
	                case WATER    : 
	                	setSmallImage("water.png");
	                	break;
	                default  : setSmallImage(game.getGameCharacter()); break;
	
	        }
        }
        
        if ( squareExplored || squareVisible )
        {
            String occupantSymbol = game.getOccupantStringRepresentation(row, column);

            if(game.hasPlayer(row,column)) {
                setBackground();
            } else {
            	clearBackground();
            }
            
            //switch statements can't be used on strings in this version of JDK
            //so IF statements.
            if(game.hasPlayer(row, column)){
            	setImage(game.getGameCharacter());
            }else{
            	if(game.getGameBoardSize()==8){
		            if(occupantSymbol.contains("K")){
		            	setBigImage("kiwi.png");}
		            if(occupantSymbol.contains("F")){
		            	setBigImage("animal.png");}
		            if( occupantSymbol.contains("P")){
		            	setBigImage("predator.png");}
		            if(occupantSymbol.contains("H")){
		            	setBigImage("hole.png");
		            	}
		            if(occupantSymbol.contains("T")){
		            	setBigImage("tool.png");}
		            if(occupantSymbol.contains("E")){
		            	setBigImage("food.png");}
            	}
            	
            	if(game.getGameBoardSize()==10){
		            if(occupantSymbol.contains("K")){
		            	setImage("kiwi.png");}
		            if(occupantSymbol.contains("F")){
		            	setImage("animal.png");}
		            if( occupantSymbol.contains("P")){
		            	setImage("predator.png");}
		            if(occupantSymbol.contains("H")){
		            	setImage("hole.png");
		            	}
		            if(occupantSymbol.contains("T")){
		            	setImage("tool.png");}
		            if(occupantSymbol.contains("E")){
		            	setImage("food.png");}
            	}
            	
            	if(game.getGameBoardSize()==12){
		            if(occupantSymbol.contains("K")){
		            	setSmallImage("kiwi.png");}
		            if(occupantSymbol.contains("F")){
		            	setSmallImage("animal.png");}
		            if( occupantSymbol.contains("P")){
		            	setSmallImage("predator.png");}
		            if(occupantSymbol.contains("H")){
		            	setSmallImage("hole.png");
		            	}
		            if(occupantSymbol.contains("T")){
		            	setSmallImage("tool.png");}
		            if(occupantSymbol.contains("E")){
		            	setSmallImage("food.png");}
            	}
            }
      
            setBorder(game.hasPlayer(row,column) ? activeBorder : normalBorder);
        }
        else
        {
            lblText.setText("");
            //lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/trap.png")));
           // setBorder(normalBorder);
        }
    }
    
    
    public void clearBackground() {
    	Terrain terrain   = game.getTerrain(row, column);
    	
    	if(game.getGameBoardSize()==8){
	        switch ( terrain )
	        {
	            case SAND     : 
	            	setBigImage("sand.png");
	            	break;
	            case FOREST   : 
	            	setBigImage("green.png");  
	            	break;
	            case WETLAND : 
	            	setBigImage("wet.png");
	            	break;
	            case SCRUB : 
	            	setBigImage("scrub.png");
	            	break;
	            case WATER    : 
	            	setBigImage("water.png");
	            	break;
	            default  : setBigImage(null); break;
	        }
    	}
    	
    	if(game.getGameBoardSize()==10){
	        switch ( terrain )
	        {
	            case SAND     : 
	            	setImage("sand.png");
	            	break;
	            case FOREST   : 
	            	setImage("green.png");  
	            	break;
	            case WETLAND : 
	            	setImage("wet.png");
	            	break;
	            case SCRUB : 
	            	setImage("scrub.png");
	            	break;
	            case WATER    : 
	            	setImage("water.png");
	            	break;
	            default  : setImage(null); break;
	        }
    	}
    	
    	if(game.getGameBoardSize()==12){
	        switch ( terrain )
	        {
	            case SAND     : 
	            	setSmallImage("sand.png");
	            	break;
	            case FOREST   : 
	            	setSmallImage("green.png");  
	            	break;
	            case WETLAND : 
	            	setSmallImage("wet.png");
	            	break;
	            case SCRUB : 
	            	setSmallImage("scrub.png");
	            	break;
	            case WATER    : 
	            	setSmallImage("water.png");
	            	break;
	            default  : setSmallImage(null); break;
	        }
    	}
    }
    public void setBackground() {
        setImage(game.getGameCharacter());     
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage,0,0,null);
    }
    public void setImage(String fileName) {
        String workingDirectory = System.getProperty("user.dir");
        String basePath = (workingDirectory + File.separator + "src" + File.separator + "images" + File.separator + "icon" + File.separator);
        try {
            backgroundImage = ImageIO.read(new File(basePath + fileName));
        } catch(Exception ex) {
            System.out.println("Couldn't find file");
        }
    }
    
    public void setSmallImage(String fileName) {
        String workingDirectory = System.getProperty("user.dir");
        String basePath = (workingDirectory + File.separator + "src" + File.separator + "images" + File.separator + "iconForSmallBoard" + File.separator);
        try {
            backgroundImage = ImageIO.read(new File(basePath + fileName));
        } catch(Exception ex) {
            System.out.println("Couldn't find file");
        }
    }
    
    public void setBigImage(String fileName) {
        String workingDirectory = System.getProperty("user.dir");
        String basePath = (workingDirectory + File.separator + "src" + File.separator + "images" + File.separator + "iconForBigBoard" + File.separator);
        try {
            backgroundImage = ImageIO.read(new File(basePath + fileName));
        } catch(Exception ex) {
            System.out.println("Couldn't find file");
        }
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
 
        lblText = new javax.swing.JLabel();
        setLayout(new java.awt.BorderLayout());
       // setImage("land.png");
      //  update();
        lblText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setOpaque(true);
        add(lblText, java.awt.BorderLayout.CENTER);
        
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
    
    private Game game;
    private int row, column;
    
    private static final Border normalBorder = new LineBorder(Color.WHITE, 1);
    private static final Border activeBorder = new LineBorder(Color.WHITE, 3);
}
