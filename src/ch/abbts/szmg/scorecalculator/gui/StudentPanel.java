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
 * Panel zur Verwaltung der Studenten
 * @author Marc Guidicelli
 */
public class StudentPanel extends JPanel {
    
    private JLabel title, preNameLabel, nameLabel;
    private JTextField preNameText, nameText;
    private JButton save, cancel;
    private Student student;
    
    private JPanel scrollPanel;
    
    // Konstruktor für StudentPanel
    public StudentPanel() {
        initStudentPanel();
    }
    
    // StudentPanel initialisieren
    private void initStudentPanel() {
        // Panel erzeugen
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.addtopPanel();
        this.addCenterPanel();
        this.addBottomPanel();
    }
    /*
     * Hinzufügen des TopPanels 
     */
    private void addtopPanel(){
        // GUI Komponenten erzeugen
        title = new JLabel("Student hinzufügen");
        title.setForeground(Color.RED);
        
        preNameLabel = new JLabel("Vorname");
        preNameLabel.setPreferredSize(new Dimension(80, 20));
        preNameLabel.setForeground(Color.WHITE);
        preNameText = new JTextField(50);
        nameLabel = new JLabel("Name");
        nameLabel.setPreferredSize(new Dimension(80, 20));
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
    /*
     * Hinzufügen des CenterPanels 
     */
    private void addCenterPanel() {
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBackground(Color.DARK_GRAY);   
        ScrollPane studentList = new ScrollPane();
        studentList.setPreferredSize(new Dimension((nameText.getPreferredSize().width+ 85),200));
        scrollPanel = new JPanel();
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
        

             
        for(Student student : Students.getInstance().getStudents()){
            JPanel studentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            studentPanel.setMaximumSize(new Dimension(nameText.getPreferredSize().width +85, 40));
            JLabel studentLabel = new JLabel(student.getFullName());
            studentLabel.setPreferredSize(new Dimension((nameText.getPreferredSize().width-200), 20));
            JButton semesterButton = new JButton("Semester");
            semesterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Gui topFrame = Gui.getMainFrame();
                    topFrame.setStudent(student);
                    topFrame.setContentPane(new SemesterPanel());
                    topFrame.revalidate();
                    topFrame.repaint();
                }
            });
            JButton showButton = new JButton("Anzeigen");
            showButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ScoreList(student);
                }
            });
            JButton deleteButton = new JButton("Löschen");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Students.getInstance().removeStudent(student);
                    JFrame topFrame = Gui.getMainFrame();
                    topFrame.setContentPane(new StudentPanel());
                    topFrame.revalidate();
                    topFrame.repaint();
                }
            });
            studentPanel.add(studentLabel);
            studentPanel.add(semesterButton);
            studentPanel.add(showButton);
            studentPanel.add(deleteButton);
            studentPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
            scrollPanel.add(studentPanel);
        }
        
        studentList.add(scrollPanel);
        centerPanel.add(studentList);
        add(centerPanel, BorderLayout.CENTER);
    }
    /* 
     * Hinzufügen des BottomPanels
     */
    private void addBottomPanel() {
        // Buttons erzeugen
        save = new JButton("Speichern");
        save.setBackground(Color.orange);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!preNameText.getText().equals("") && !nameText.getText().equals("")){
                    
                    // Student erzeugen und speichern
                    student = new Student(preNameText.getText(), nameText.getText());
                    Students.getInstance().addStudent(student);
                    
                    // Semester Panel laden
                    JFrame topFrame = Gui.getMainFrame();
                    topFrame.setContentPane(new StudentPanel());
                    topFrame.revalidate();
                    topFrame.repaint();
                }
            }
        });
        cancel = new JButton("Zurück");
        cancel.setBackground(Color.orange);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // MainFrame holen,  neues MainPanel erzeugen und einklinken.
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
