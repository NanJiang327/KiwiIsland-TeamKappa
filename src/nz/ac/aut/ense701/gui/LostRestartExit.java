/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.GameState;

/**
 *
 * @author dyd2298
 */
public class LostRestartExit {

    private Game game;
    private GameState GameState;
    private MainPage MainPage;
    private JPanel gameStatePanel;
    private JFrame gameStateFrame;

    /**
     * Creates new form LostRestartExit
     */
    public LostRestartExit(Game game) {
    	gameStateFrame = new JFrame();
        initComponents();
        gameStateFrame.setLocationRelativeTo(null);
        // this.pack();
        gameStateFrame.setSize(250, 300);
        int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 250) / 2;
    	int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 200) / 2;
    	gameStateFrame.setLocation(w, h);
        gameStateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameStateFrame.setResizable(false);
        gameStateFrame.setVisible(true);
        gameStateFrame.setTitle("Game State");
        this.game = game;
        this.GameState = game.getState();
        gameStateFrame.setVisible(true);
        writeMessage();
    }

    private void writeMessage() {
        if (GameState == GameState.LOST) {

            dispMsg.setText(""+ game.getLoseMessage());
            dispMsg.setForeground(new java.awt.Color(0, 0, 0));
            dispMsg.setFont(new java.awt.Font("Tandysoft", 1, 12));
            dispMsg.setOpaque(false);

        } else if (GameState == GameState.WON) {
            dispMsg.setText("" + game.getWinMessage());
            dispMsg.setForeground(new java.awt.Color(0, 0, 0));
            dispMsg.setFont(new java.awt.Font("Tandysoft", 1, 16));
            dispMsg.setOpaque(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPageButton = new javax.swing.JButton("Main Page");
        RestartButton = new javax.swing.JButton("Restart");
        Exit = new javax.swing.JButton("Exit");
        NewGame = new javax.swing.JButton("Reset Game");
        dispMsg = new JTextArea();
        dispMsg = new JTextArea(20,30);
        dispMsg.setLineWrap(true);
        dispMsg.setWrapStyleWord(true);
        dispMsg.setTabSize(4);
        dispMsg.setBackground(Color.white);
        dispMsg.setEditable(false);
        dispMsg.setFont(new  java.awt.Font("Dialog",   1,   30));
        gameStatePanel  = new JPanel();

    
        MainPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainPageButtonActionPerformed(evt);
            }
        });


        RestartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartButtonActionPerformed(evt);
            }
        });

        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });
        gameStatePanel.setLayout(new GridLayout(5, 1));
        gameStatePanel.add(dispMsg);
        gameStatePanel.add(MainPageButton);
        gameStatePanel.add(RestartButton);
        gameStatePanel.add(NewGame);
        gameStatePanel.add(Exit);
        gameStateFrame.add(gameStatePanel);

    }

    private void MainPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainPageButtonActionPerformed
        // TODO add your handling code here:
    	gameStateFrame.dispose();

        MainPage = new MainPage(game.getPlayerName());

    }//GEN-LAST:event_MainPageButtonActionPerformed

    private void RestartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartButtonActionPerformed
        // TODO add your handling code here:
    	gameStateFrame.dispose();
        String player = game.getPlayerName();
        String bgm = game.getBgm();
        String gameCharacter = game.getGameCharacter();
        Game newGame = new Game(player, bgm, gameCharacter);
        // create the GUI for the game
        final KiwiCountUI gui = new KiwiCountUI(newGame);
        Thread newThread = new Thread(gui);
        newThread.start();
        gui.requestFocus();
        // make the GUI visible
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui.setVisible(true);
            }
        });
    }//GEN-LAST:event_RestartButtonActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(2);
    }//GEN-LAST:event_ExitActionPerformed

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
        // TODO add your handling code here:
    	gameStateFrame.dispose();
        String player = game.getPlayerName();

        // create the GUI for the game
        new StartPage(player);


    }//GEN-LAST:event_NewGameActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton MainPageButton;
    private javax.swing.JButton NewGame;
    private javax.swing.JButton RestartButton;
    private javax.swing.JTextArea dispMsg;
    // End of variables declaration//GEN-END:variables
}
