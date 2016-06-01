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
public class ModulPanel extends JPanel {
    
    private JPanel modulPanel;
    private JTextField modul;
    
    public ModulPanel() {
        
        // Panel erzeugen und Grösse definieren
        modulPanel = new JPanel();
        modulPanel.setBackground(Color.DARK_GRAY);
        modulPanel.setPreferredSize(new Dimension (800,400));
        add(modulPanel);
    }
    
}
