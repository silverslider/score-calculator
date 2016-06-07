/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator.gui;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
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
        JLabel picturePanel = new JLabel(new ImageIcon(raupe));
        add(picturePanel, BorderLayout.WEST);
        JLabel titel = new JLabel();
        titel.setFont(new Font("Arial", Font.ITALIC, 48));
        titel.setForeground(Color.WHITE);
        titel.setText("Notenverwaltung");
        JLabel titel2 = new JLabel();
        titel2.setFont(new Font("Arial", Font.ITALIC, 24));
        titel2.setForeground(Color.WHITE);
        titel2.setText("designed by Caterpillarware...");
        centerPanel.add(titel);
        centerPanel.add(titel2);
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
