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
public class Gui extends JFrame {

    private MainPanel mainPanel;
    private TopMenuBar topMenuBar;
    private int frameWidth = 800;
    private int frameHeight = 400;
    
    // Konstruktor für Gui    
    public Gui() { 
                
        // MainFrame generieren: Titel, Position und gösse setzen
        setTitle("Score calculator");
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();
        setLocation((screenWidth-frameWidth)/2, (screenHeight-frameHeight)/2);
        setSize(frameWidth,frameHeight);
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Stellt sicher, dass sauber beendet wird.
        
        topMenuBar = new TopMenuBar();
        mainPanel = new MainPanel();
        
        add(topMenuBar);
        setJMenuBar(topMenuBar);
        
        add(mainPanel, BorderLayout.NORTH);
        
        setVisible(true);
        
    } // End Constructor
        
}
