/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author mg
 */
public class SemesterPanel extends JPanel {

    private JLabel title, nameLabel, descriptionLabel;
    private JTextField nameText, descriptionText;
    private JButton save, cancel;
    
    public SemesterPanel() {
        initSemesterPanel();
    }
    private void initSemesterPanel() {
        // Panel erzeugen und Grösse definieren
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.addCenterPanel();
        this.addBottomPanel();
    }
    private void addCenterPanel(){
        title = new JLabel("Semester");
        title.setForeground(Color.RED);
        nameLabel = new JLabel("Name");
        nameLabel.setForeground(Color.WHITE);
        nameText = new JTextField(50);
        descriptionLabel = new JLabel("Beschreibung");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionText = new JTextField(50);
        // Panel für Erfassungsmaske
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBackground(Color.DARK_GRAY);
        centerPanel.add(title);
        centerPanel.add(nameLabel);
        centerPanel.add(nameText);
        centerPanel.add(descriptionLabel);
        centerPanel.add(descriptionText);
        add(centerPanel, BorderLayout.CENTER);
    }    

    public void addBottomPanel() {
        // Buttons erzeugen
        save = new JButton("Speichern");
        save.setBackground(Color.orange);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String description = descriptionText.getText();
                
                JFrame topFrame = Gui.getMainFrame();
                topFrame.setContentPane(new ModulPanel());
                topFrame.revalidate();
                topFrame.repaint();
            }
        });
        cancel = new JButton("Zurück");
        cancel.setBackground(Color.orange);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = Gui.getMainFrame();
                topFrame.setContentPane(new StudentPanel());
                topFrame.revalidate();
                topFrame.repaint();
            }
        });        
        //Panel für Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(cancel);
        bottomPanel.add(save);
        add(bottomPanel, BorderLayout.SOUTH);        
    }
}
