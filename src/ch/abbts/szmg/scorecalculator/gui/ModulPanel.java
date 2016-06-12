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
 * Panel zur Verwaltung der Module
 * @author Marc Guidicelli
 */
public class ModulPanel extends JPanel {
    
    private JLabel title, nameLabel, descriptionLabel, instructorLabel;
    private JTextField nameText, descriptionText, instructorText;
    private JButton save, cancel;
    
    public ModulPanel() {
        initModulPanel();
    }
    //Initialisiseren des ModulPanels
    private void initModulPanel() {
        // Panel erzeugen
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.addTopPanel();
        this.addCenterPanel();
        this.addBottomPanel();
    }
    /*
     * Hinzufügen des TopPanels
     */
    private void addTopPanel(){
        //Panel für den North Bereich        
        title = new JLabel("Student: " + Gui.getMainFrame().getStudent().getFullName() + " im Semester " + Gui.getMainFrame().getSemester().getName());
        title.setForeground(Color.RED);
        nameLabel = new JLabel("Name");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setPreferredSize(new Dimension(80, 20));
        nameText = new JTextField(50);
        descriptionLabel = new JLabel("Beschreibung");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setPreferredSize(new Dimension(80, 20));
        descriptionText = new JTextField(50);
        instructorLabel = new JLabel("Dozent");
        instructorLabel.setForeground(Color.WHITE);
        instructorLabel.setPreferredSize(new Dimension(80, 20));
        instructorText = new JTextField(50);
        
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
        JPanel topSubPanel3 = new JPanel(new FlowLayout());
        topSubPanel3.setBackground(Color.DARK_GRAY);
        topSubPanel3.add(instructorLabel);
        topSubPanel3.add(instructorText);
        topPanel.add(topSubPanel1);
        topPanel.add(topSubPanel2);
        topPanel.add(topSubPanel3);
        add(topPanel, BorderLayout.NORTH);
    }
    /*
     * Hinzufügen des CenterPanels
     */
    private void addCenterPanel() {
        // Panel für den Center Bereich
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBackground(Color.DARK_GRAY);   
        ScrollPane modulList = new ScrollPane();
        modulList.setPreferredSize(new Dimension((nameText.getPreferredSize().width+ 85),200));
        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
        
        //Pro Modul ein Panel dem Scrollpanel hinzufügen inkl. Buttons mit Actionlistener
        for(Module module : Gui.getMainFrame().getSemester().getModules()){
            JPanel modulPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            modulPanel.setMaximumSize(new Dimension(nameText.getPreferredSize().width +85, 40));
            JLabel modulLabel = new JLabel(module.getName());
            modulLabel.setPreferredSize(new Dimension((nameText.getPreferredSize().width-200), 20));
            JButton moduleButton = new JButton("Noten");
            moduleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Gui topFrame = Gui.getMainFrame();
                    topFrame.setModule(module);
                    topFrame.setContentPane(new ScorePanel());
                    topFrame.revalidate();
                    topFrame.repaint();
                }
            });
            
            JButton showButton = new JButton("Anzeigen");
            showButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ScoreList(module);
                }
            });
            
            JButton deleteButton = new JButton("Löschen");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Gui topFrame = Gui.getMainFrame();
                    topFrame.getSemester().removeModule(module);
                    topFrame.setContentPane(new ModulPanel());
                    topFrame.revalidate();
                    topFrame.repaint();
                }
            });
            
            modulPanel.add(modulLabel);
            modulPanel.add(moduleButton);
            modulPanel.add(showButton);
            modulPanel.add(deleteButton);
            modulPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
            scrollPanel.add(modulPanel);
        }
        
        modulList.add(scrollPanel);
        centerPanel.add(modulList);
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
                if(!nameText.getText().equals("")){
                    Gui topFrame = Gui.getMainFrame();
                    Module module = new Module(nameText.getText(), descriptionText.getText(), instructorText.getText());
                    topFrame.getSemester().addModule(module);
                    topFrame.setContentPane(new ModulPanel());
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
                // MainFrame holen,  neues SemesterPanel erzeugen und einklinken.
                Gui topFrame = Gui.getMainFrame();
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
