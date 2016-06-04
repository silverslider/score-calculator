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
        initMainPanel();
    }
    private void initMainPanel() {
        // Panel erzeugen und Grösse definieren
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.addBottomPanel();
    }
    private void addBottomPanel() {
        // Buttons erzeugen
        student = new JButton("Student hinzufügen");
        student.setBackground(Color.orange);
        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = Gui.getMainFrame();
                topFrame.setContentPane(new StudentPanel());
                topFrame.revalidate();
                topFrame.repaint();
            }
        });
        
        //Panel für Button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(student);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
