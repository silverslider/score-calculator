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
import sun.font.TextLabel;

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
        this.addtopPanel();
        this.addCenterPanel();
        this.addBottomPanel();
    }
    private void addtopPanel(){
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
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.add(title);
        //Sub Panel pro Zeile
        JPanel topSubPanel1 = new JPanel(new FlowLayout());
        topSubPanel1.setBackground(Color.DARK_GRAY);
        topSubPanel1.add(preNameLabel);
        topSubPanel1.add(preNameText);
        JPanel topSubPanel2 = new JPanel(new FlowLayout());
        topSubPanel2.setBackground(Color.DARK_GRAY);
        topSubPanel2.add(nameLabel);
        topSubPanel2.add(nameText);
        // Panels zuordnen
        topPanel.add(topSubPanel1);
        topPanel.add(topSubPanel2);
        add(topPanel, BorderLayout.NORTH);
    }    
    private void addCenterPanel() {
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBackground(Color.DARK_GRAY);

        
        ScrollPane studentList = new ScrollPane();
        JLabel[] text = new JLabel[100];
        
        //studentList.add(text);
        //centerPanel.add(text);
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
