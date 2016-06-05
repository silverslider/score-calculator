/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator.gui;
import ch.abbts.szmg.scorecalculator.*;
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
    private Semester semester;
    
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
        // Panel für Semester Erfassung
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.DARK_GRAY);
        centerPanel.add(title);
        // Sub Panel pro Zeile
        JPanel centerSubPanel1 = new JPanel(new FlowLayout());
        centerSubPanel1.setBackground(Color.DARK_GRAY);
        centerSubPanel1.add(nameLabel);
        centerSubPanel1.add(nameText);
        JPanel centerSubPanel2 = new JPanel(new FlowLayout());
        centerSubPanel2.setBackground(Color.DARK_GRAY);
        centerSubPanel2.add(descriptionLabel);
        centerSubPanel2.add(descriptionText);
        centerPanel.add(centerSubPanel1);
        centerPanel.add(centerSubPanel2);
        add(centerPanel, BorderLayout.CENTER);
    }    

    private void addBottomPanel() {
        // Buttons erzeugen
        save = new JButton("Speichern");
        save.setBackground(Color.orange);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                semester = new Semester(nameText.getText() ,descriptionText.getText());
                Gui.setSemester(semester);
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
