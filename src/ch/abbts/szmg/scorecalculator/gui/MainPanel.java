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
 * Hauptansicht welche beim erzeugen des Frames geladen wird.
 * @author Marc Guidicelli
 */
public class MainPanel extends JPanel {
    
    private JLabel title;
    private JButton student;
    
    public MainPanel() {
        initMainPanel();
    }
    /*
     * Methode zum initialisiseren des mainPanels
     */
    private void initMainPanel() {
        // Panel für ContentPane erzeugen
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.addtopPanel();
        this.addCenterPanel();
        this.addBottomPanel();
    }
    /*
     * Hinzufügen des TopPanels
     */
    private void addtopPanel() {
        //Subpanel für den North Bereich
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(Color.DARK_GRAY);
        title = new JLabel("Main");
        title.setForeground(Color.RED);
        add(topPanel, BorderLayout.NORTH);
    }
    /*
     * Hinzufügen des CenterPanels
     */
    private void addCenterPanel(){
        // Panel für die Haupseite im Center
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBackground(Color.DARK_GRAY);
        ImageIcon bigRaupe = new ImageIcon("raupe.jpg");
        Image raupe = bigRaupe.getImage().getScaledInstance(270, 300, java.awt.Image.SCALE_SMOOTH);
        JLabel pitureLabel = new JLabel(new ImageIcon(raupe));
        JLabel titel = new JLabel("Notenverwaltung");
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
    /*
     * Hinzufügen des BottomPanels
     */
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
