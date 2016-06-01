/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator.gui;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author mg
 */
public class ScorePanel extends JPanel {
    
    private JPanel scorePanel;
    private JTextField score;
    private JButton save, cancel;
    
    public ScorePanel() {
        
        // Panel erzeugen und Grösse definieren
        scorePanel = new JPanel();
        scorePanel.setBackground(Color.DARK_GRAY);
        scorePanel.setPreferredSize(new Dimension (800,400));
        add(scorePanel);
        
    }
    
}
