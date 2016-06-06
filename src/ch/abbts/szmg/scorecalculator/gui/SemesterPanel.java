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
    
    public SemesterPanel() {
        initSemesterPanel();
    }
    private void initSemesterPanel() {
        // Panel erzeugen und Grösse definieren
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.addTopPanel();
        this.addCenterPanel();
        this.addBottomPanel();
    }
    private void addTopPanel(){
        title = new JLabel("Semester von " + Gui.getMainFrame().getStudent().getFullName());
        title.setForeground(Color.RED);
        nameLabel = new JLabel("Name");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setPreferredSize(new Dimension(80, 20));
        nameText = new JTextField(50);
        descriptionLabel = new JLabel("Beschreibung");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setPreferredSize(new Dimension(80, 20));
        descriptionText = new JTextField(50);
        // Panel für Semester Erfassung
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.add(title);
        // Sub Panel pro Zeile
        JPanel topSubPanel1 = new JPanel(new FlowLayout());
        topSubPanel1.setBackground(Color.DARK_GRAY);
        topSubPanel1.add(nameLabel);
        topSubPanel1.add(nameText);
        JPanel topSubPanel2 = new JPanel(new FlowLayout());
        topSubPanel2.setBackground(Color.DARK_GRAY);
        topSubPanel2.add(descriptionLabel);
        topSubPanel2.add(descriptionText);
        topPanel.add(topSubPanel1);
        topPanel.add(topSubPanel2);
        add(topPanel, BorderLayout.NORTH);
    }    
    private void addCenterPanel() {
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBackground(Color.DARK_GRAY);   
        ScrollPane semesterList = new ScrollPane();
        semesterList.setPreferredSize(new Dimension((nameText.getPreferredSize().width+ 85),200));
        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
        

             
        for(Semester semester : Gui.getMainFrame().getStudent().getSemesters()){
            JPanel studentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            studentPanel.setMaximumSize(new Dimension(nameText.getPreferredSize().width +85, 40));
            JLabel studentLabel = new JLabel(semester.getName());
            studentLabel.setPreferredSize(new Dimension((nameText.getPreferredSize().width-150), 20));
            JButton showButton = new JButton("Fächer");
            showButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Gui topFrame = Gui.getMainFrame();
                    topFrame.setSemester(semester);
                    topFrame.setContentPane(new ModulPanel());
                    topFrame.revalidate();
                    topFrame.repaint();
                }
            });
            JButton deleteButton = new JButton("Löschen");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Gui.getMainFrame().getStudent().removeSemester(semester);
                    JFrame topFrame = Gui.getMainFrame();
                    topFrame.setContentPane(new SemesterPanel());
                    topFrame.revalidate();
                    topFrame.repaint();
                }
            });
            studentPanel.add(studentLabel);
            studentPanel.add(showButton);
            studentPanel.add(deleteButton);
            studentPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
            scrollPanel.add(studentPanel);
        }
        
        semesterList.add(scrollPanel);
        centerPanel.add(semesterList);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void addBottomPanel() {
        // Buttons erzeugen
        save = new JButton("Speichern");
        save.setBackground(Color.orange);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui topFrame = Gui.getMainFrame();
                Semester semester = new Semester(nameText.getText() ,descriptionText.getText());
                topFrame.setSemester(semester);
                topFrame.getStudent().addSemester(semester);
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
