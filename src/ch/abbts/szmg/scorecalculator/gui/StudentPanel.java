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
public class StudentPanel extends JPanel {
    
    private JPanel studentPanel;
    private JTextField preName, lastName;
    private JButton save, cancel;
    
    
    public StudentPanel() {
        
        // Panel erzeugen und Grösse definieren
        studentPanel = new JPanel();
        studentPanel.setBackground(Color.DARK_GRAY);
        studentPanel.setPreferredSize(new Dimension (800,400));
        add(studentPanel);
        
    }
    
    
}
