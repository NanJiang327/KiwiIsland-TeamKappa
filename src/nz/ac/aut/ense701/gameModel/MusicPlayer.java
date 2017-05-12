package nz.ac.aut.ense701.gameModel;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JOptionPane;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicPlayer {

private Player player;

private InputStream path;
private BufferedInputStream BIS;
private boolean canResume;
private int total;
private int stopped;
private boolean valid;

	public MusicPlayer(){
	    player = null;
	    valid = false;
	    BIS = null;
	    path = null;
	    total = 0;
	    stopped = 0;
	    canResume = false;
	}

	public boolean canResume(){
		return canResume;
	}
	
	public void setPath(InputStream path)
	{
		this.path = path;
	}
	public void pause(){
	    try{
	    stopped = path.available();
	    player.close();
	    BIS = null;
	    player = null;
	    if(valid) canResume = true;
	    }catch(Exception e){
	
	    }
	}
	
	public void stop() {
		if(player!=null){
			player.close();
		}
	}
	
	public void resume() {
	    if(!canResume) return;
	    if(total-stopped>0){
	    	canResume = false;
	    	play(total - stopped);
	    }
	}	
	
	public boolean play(int pos){
	    valid = true;
	    canResume = false;
	    try{
	    total = path.available();
	    if(pos > -1) path.skip(pos);
	    BIS = new BufferedInputStream(path);
	    player = new Player(BIS);
	    new Thread(
	            new Runnable(){
	                public void run(){
	                    try{
	                        player.play();
	                   
	                    }catch(Exception e){
	                        JOptionPane.showMessageDialog(null, "Error playing mp3 file");
	                        valid = false;
	                    }
	                }
	            }
	    ).start();
	 
	    }catch(Exception e){
	        JOptionPane.showMessageDialog(null, "Error playing mp3 file");
	        valid = false;
	    }
	    return valid;
	}
	
	
}
	
