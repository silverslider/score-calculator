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
    
    private JLabel title;
    private JButton student;
    
    public MainPanel() {
        initMainPanel();
    }
    private void initMainPanel() {
        // Panel erzeugen und Grösse definieren
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.addtopPanel();
        this.addCenterPanel();
        this.addBottomPanel();
    }
    private void addtopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(Color.DARK_GRAY);
        title = new JLabel("Main");
        title.setForeground(Color.RED);
        add(topPanel, BorderLayout.NORTH);
    }
    private void addCenterPanel(){
        // Panel für Erfassungsmaske
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBackground(Color.DARK_GRAY);
        ImageIcon bigRaupe = new ImageIcon("raupe.jpg");
        Image raupe = bigRaupe.getImage().getScaledInstance(270, 300, java.awt.Image.SCALE_SMOOTH);
        JLabel pitureLabel = new JLabel(new ImageIcon(raupe));
        JLabel titel = new JLabel("Studentenverwaltung");
        titel.setFont(new Font("Arial", Font.ITALIC, 48));
        titel.setForeground(Color.white);
        JLabel titel2 = new JLabel("...designed by Caterpillarware");
        titel2.setFont(new Font("Arial", Font.ITALIC, 24));
        titel2.setForeground(Color.white);
        centerPanel.add(titel);
        centerPanel.add(titel2);
        
        add(pitureLabel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }    
    private void addBottomPanel() {
        // Buttons erzeugen
        student = new JButton("Student hinzufügen");
        student.setBackground(Color.orange);
        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui topFrame = Gui.getMainFrame();
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
