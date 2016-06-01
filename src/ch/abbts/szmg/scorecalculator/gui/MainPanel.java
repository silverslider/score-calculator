/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author mg
 */
public class MainPanel extends JPanel {
    
    private JButton student;
    
    public MainPanel() {
        
        // Panel erzeugen und Grösse definieren
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension (800,400));
        setLayout(new FlowLayout());
        
        // Buttons erzeugen
        student = new JButton( "Student");
        student.setBackground(Color.orange);
                       
        // Buttons zu Panel hinzufügen
        add(student);
        
        
    }
    
    class StudentActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource();
            
            if(button == student) {
                add(new StudentPanel());
            } 
        }
        
    }
    
}
