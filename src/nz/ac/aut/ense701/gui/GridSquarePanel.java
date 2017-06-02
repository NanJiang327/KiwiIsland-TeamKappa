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
            String occupantName = game.getOccupantStringName(row, column);

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
		            if(occupantName.contains("Sandwich")){
		            	setBigImage("sandwich.png");}
		            if(occupantName.contains("Muesli Bar")){
		            	setBigImage("muesli_bar.png");}
		            if( occupantName.contains("Apple")){
		            	setBigImage("apple.png");}
		            if(occupantName.contains("Orange")){
		            	setBigImage("orange_juice.png");
		            	}
		            if(occupantName.contains("Trap")){
		            	setBigImage("trap.png");}
		            if(occupantName.contains("Screwdriver")){
		            	setBigImage("screwdriver.png");}
		            if(occupantName.contains("Oystercatcher")){
		            	setBigImage("Oystercatcher.png");}
		            if(occupantName.contains("Crab")){
		            	setBigImage("crab.png");}
		            if(occupantName.contains("Fernbird")){
		            	setBigImage("Fernbird.png");}
		            if(occupantName.contains("Heron")){
		            	setBigImage("heron.png");}
		            if(occupantName.contains("Robin")){
		            	setBigImage("robin.png");}
		            if(occupantName.contains("Tui")){
		            	setBigImage("tui.png");}
		            if(occupantName.contains("Kiwi")){
		            	setBigImage("kiwi.png");}
		            if(occupantName.contains("Rat")){
		            	setBigImage("rat.png");}
		            if(occupantName.contains("Cat")){
		            	setBigImage("cat.png");}
		            if(occupantName.contains("Stota")){
		            	setBigImage("Stoat.png");}
		            if(occupantName.contains("Possum")){
		            	setBigImage("possum.png");}
		            if(occupantName.contains("Cliff")){
		            	setBigImage("cliff.png");}
		            if(occupantName.contains("Pond")){
		            	setBigImage("pond.png");}
		            if(occupantName.contains("Rock")){
		            	setBigImage("rock.png");}
		            if(occupantName.contains("Sunburn")){
		            	setBigImage("sunburn.png");}
		            if(occupantName.contains("Fall")){
		            	setBigImage("fall.png");}
		            if(occupantName.contains("Broken trap")){
		            	setBigImage("broken_trap.png");}
		            if(occupantName.contains("Kiore")){
		            	setBigImage("kiore.png");}
            	}
            	if(game.getGameBoardSize()==10){
            		if(occupantName.contains("Sandwich")){
		            	setImage("sandwich.png");}
		            if(occupantName.contains("Muesli Bar")){
		            	setImage("muesli_bar.png");}
		            if( occupantName.contains("Apple")){
		            	setImage("apple.png");}
		            if(occupantName.contains("Orange")){
		            	setImage("orange_juice.png");
		            	}
		            if(occupantName.contains("Trap")){
		            	setImage("trap.png");}
		            if(occupantName.contains("Screwdriver")){
		            	setImage("screwdriver.png");}
		            if(occupantName.contains("Oystercatcher")){
		            	setImage("Oystercatcher.png");}
		            if(occupantName.contains("Crab")){
		            	setImage("crab.png");}
		            if(occupantName.contains("Fernbird")){
		            	setImage("Fernbird.png");}
		            if(occupantName.contains("Heron")){
		            	setImage("heron.png");}
		            if(occupantName.contains("Robin")){
		            	setImage("robin.png");}
		            if(occupantName.contains("Tui")){
		            	setImage("tui.png");}
		            if(occupantName.contains("Kiwi")){
		            	setImage("kiwi.png");}
		            if(occupantName.contains("Rat")){
		            	setImage("rat.png");}
		            if(occupantName.contains("Cat")){
		            	setImage("cat.png");}
		            if(occupantName.contains("Stota")){
		            	setImage("Stoat.png");}
		            if(occupantName.contains("Possum")){
		            	setImage("possum.png");}
		            if(occupantName.contains("Cliff")){
		            	setImage("cliff.png");}
		            if(occupantName.contains("Pond")){
		            	setImage("pond.png");}
		            if(occupantName.contains("Rock")){
		            	setImage("rock.png");}
		            if(occupantName.contains("Sunburn")){
		            	setImage("sunburn.png");}
		            if(occupantName.contains("Fall")){
		            	setImage("fall.png");}
		            if(occupantName.contains("Broken trap")){
		            	setImage("broken_trap.png");}
		            if(occupantName.contains("Kiore")){
		            	setImage("kiore.png");}
            	}
            	
            	if(game.getGameBoardSize()==12){
            		if(occupantName.contains("Sandwich")){
		            	setSmallImage("sandwich.png");}
		            if(occupantName.contains("Muesli Bar")){
		            	setSmallImage("muesli_bar.png");}
		            if( occupantName.contains("Apple")){
		            	setSmallImage("apple.png");}
		            if(occupantName.contains("Orange")){
		            	setSmallImage("orange_juice.png");
		            	}
		            if(occupantName.contains("Trap")){
		            	setSmallImage("trap.png");}
		            if(occupantName.contains("Screwdriver")){
		            	setSmallImage("screwdriver.png");}
		            if(occupantName.contains("Oystercatcher")){
		            	setSmallImage("Oystercatcher.png");}
		            if(occupantName.contains("Crab")){
		            	setSmallImage("crab.png");}
		            if(occupantName.contains("Fernbird")){
		            	setSmallImage("Fernbird.png");}
		            if(occupantName.contains("Heron")){
		            	setSmallImage("heron.png");}
		            if(occupantName.contains("Robin")){
		            	setSmallImage("robin.png");}
		            if(occupantName.contains("Tui")){
		            	setSmallImage("tui.png");}
		            if(occupantName.contains("Kiwi")){
		            	setSmallImage("kiwi.png");}
		            if(occupantName.contains("Rat")){
		            	setSmallImage("rat.png");}
		            if(occupantName.contains("Cat")){
		            	setSmallImage("cat.png");}
		            if(occupantName.contains("Stota")){
		            	setSmallImage("Stoat.png");}
		            if(occupantName.contains("Possum")){
		            	setSmallImage("possum.png");}
		            if(occupantName.contains("Cliff")){
		            	setSmallImage("cliff.png");}
		            if(occupantName.contains("Pond")){
		            	setSmallImage("pond.png");}
		            if(occupantName.contains("Rock")){
		            	setSmallImage("rock.png");}
		            if(occupantName.contains("Sunburn")){
		            	setSmallImage("sunburn.png");}
		            if(occupantName.contains("Fall")){
		            	setSmallImage("fall.png");}
		            if(occupantName.contains("Broken trap")){
		            	setSmallImage("broken_trap.png");}
		            if(occupantName.contains("Kiore")){
		            	setSmallImage("kiore.png");}
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
        String basePath = (workingDirectory + File.separator + "src" + File.separator + "images" + File.separator + "iconForBigBoard" + File.separator);
        try {
            backgroundImage = ImageIO.read(new File(basePath + fileName));
        } catch(Exception ex) {
            System.out.println("Couldn't find file "+fileName+"");
        }
    }
    
    public void setBigImage(String fileName) {
        String workingDirectory = System.getProperty("user.dir");
        String basePath = (workingDirectory + File.separator + "src" + File.separator + "images" + File.separator + "iconForSmallBoard" + File.separator);
        try {
            backgroundImage = ImageIO.read(new File(basePath + fileName));
        } catch(Exception ex) {
            System.out.println("Couldn't find file "+fileName+" ");
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
