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
public class SemesterPanel extends JPanel {
    
    private JPanel semesterPanel;
    private JTextField semester;
    private JButton save, cancel;
    
    public SemesterPanel() {
        
        // Panel erzeugen und Grösse definieren
        semesterPanel = new JPanel();
        semesterPanel.setBackground(Color.DARK_GRAY);
        semesterPanel.setPreferredSize(new Dimension (800,400));
        add(semesterPanel);
        
    }
    
}
