/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator.gui;
import ch.abbts.szmg.scorecalculator.Students;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author mg
 */
public class ModulPanel extends JPanel {
    
    private JLabel title, scoreLabel, weightLabel;
    private JTextField scoreText, weightText;
    private JButton save, cancel;
    
    public ModulPanel() {
        initModulPanel();
    }
    private void initModulPanel() {
        // Panel erzeugen und Grösse definieren
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.addCenterPanel();
        this.addBottomPanel();
        }
    private void addCenterPanel(){
        // Komponenten für Notenerfassung
        title = new JLabel("Fach");
        title.setForeground(Color.RED);
        scoreLabel = new JLabel("Note");
        scoreLabel.setForeground(Color.WHITE);
        weightLabel = new JLabel("Gewicht");
        weightLabel.setForeground(Color.WHITE);
        scoreText = new JTextField(10);
        weightText = new JTextField(10);
        
        // Panel für Erfassungsmaske
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBackground(Color.DARK_GRAY);
        centerPanel.add(title);
        centerPanel.add(scoreLabel);
        centerPanel.add(scoreText);
        centerPanel.add(weightLabel);
        centerPanel.add(weightText);
        add(centerPanel, BorderLayout.CENTER);
    }    

        private void addBottomPanel() {
        // Buttons erzeugen
        save = new JButton("Speichern");
        save.setBackground(Color.orange);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int score =  Integer.parseInt(scoreText.getText());
                int weight = Integer.parseInt(weightText.getText());
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
                topFrame.setContentPane(new SemesterPanel());
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
