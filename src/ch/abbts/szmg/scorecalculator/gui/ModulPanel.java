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
public class ModulPanel extends JPanel {
    
    private JLabel title, scoreLabel, weightLabel;
    private JTextField scoreText, weightText;
    private JButton save, cancel;
    private Score score;
    
    public ModulPanel() {
        initModulPanel();
    }
    private void initModulPanel() {
        // Panel erzeugen und Grösse definieren
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.addTopPanel();
        this.addCenterPanel();
        this.addBottomPanel();
        }
    private void addTopPanel(){
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
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.add(title);
        // Sub Panel pro Zeile
        JPanel topSubPanel1 = new JPanel(new FlowLayout());
        topSubPanel1.setBackground(Color.DARK_GRAY);
        topSubPanel1.add(scoreLabel);
        topSubPanel1.add(scoreText);
        JPanel topSubPanel2 = new JPanel(new FlowLayout());
        topSubPanel2.setBackground(Color.DARK_GRAY);
        topSubPanel2.add(weightLabel);
        topSubPanel2.add(weightText);
        topPanel.add(topSubPanel1);
        topPanel.add(topSubPanel2);
        add(topPanel, BorderLayout.NORTH);
    }    
    private void addCenterPanel() {
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBackground(Color.DARK_GRAY);
        JLabel text = new JLabel("Hier kommt deine Liste hinein");
        text.setForeground(Color.BLUE);
        centerPanel.add(text);
        add(centerPanel, BorderLayout.CENTER);
    }

        private void addBottomPanel() {
        // Buttons erzeugen
        save = new JButton("Speichern");
        save.setBackground(Color.orange);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                score = new Score(Double.parseDouble(scoreText.getText()), Integer.parseInt(weightText.getText()));
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
