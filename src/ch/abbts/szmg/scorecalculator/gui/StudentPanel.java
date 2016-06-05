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
public class StudentPanel extends JPanel {
    
    private JLabel title, preNameLabel, nameLabel;
    private JTextField preNameText, nameText;
    private JButton save, cancel;
    private Student student;
    
    public StudentPanel() {
        initStudentPanel();
    }
    private void initStudentPanel() {
        // Panel erzeugen
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.addCenterPanel();
        this.addBottomPanel();
    }
    private void addCenterPanel(){
        // GUI Komponenten erzeugen
        title = new JLabel("Student hinzufügen");
        title.setForeground(Color.RED);
        preNameLabel = new JLabel("Vorname");
        preNameLabel.setForeground(Color.WHITE);
        preNameText = new JTextField(50);
        nameLabel = new JLabel("Name");
        nameLabel.setForeground(Color.WHITE);
        nameText = new JTextField(50);
        // Panel für Student Erfassung
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.DARK_GRAY);
        centerPanel.add(title);
        //Sub Panel pro Zeile
        JPanel centerSubPanel1 = new JPanel(new FlowLayout());
        centerSubPanel1.setBackground(Color.DARK_GRAY);
        centerSubPanel1.add(preNameLabel);
        centerSubPanel1.add(preNameText);
        JPanel centerSubPanel2 = new JPanel(new FlowLayout());
        centerSubPanel2.setBackground(Color.DARK_GRAY);
        centerSubPanel2.add(nameLabel);
        centerSubPanel2.add(nameText);
        // Panels zuordnen
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
                // Student erzeugen und speichern
                student = new Student(preNameText.getText(), nameText.getText());
                Gui.setStudent(student);
                // Semester Panel laden
                JFrame topFrame = Gui.getMainFrame();
                topFrame.setContentPane(new SemesterPanel());
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
                topFrame.setContentPane(new MainPanel());
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
