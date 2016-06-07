/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator.gui;
import ch.abbts.szmg.scorecalculator.Score;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author mg
 */
public class ScorePanel extends JPanel {
    
    private JPanel scorePanel;
    private JLabel title, scoreLabel, weightLabel;
    private JTextField scoreText, weightText;
    private JButton save, cancel;
    
    public ScorePanel() {
        
        // Panel erzeugen und Grösse definieren
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.addTopPanel();
        this.addCenterPanel();
        this.addBottomPanel();
        
    }
    
    private void addTopPanel(){
        // Komponenten für Notenerfassung
        title = new JLabel("Notenspiegel");
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
        ScrollPane scoreList = new ScrollPane();
        scoreList.setPreferredSize(new Dimension(600,125));
        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.X_AXIS));
        int i = 1;
        for(Score score : Gui.getMainFrame().getModule().getScores()){
            JPanel scorePanel = new JPanel();
            scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
            scorePanel.setMaximumSize(new Dimension(60, 140));
            scorePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.DARK_GRAY));
            JLabel numberLab = new JLabel(""+i);
            numberLab.setAlignmentX(CENTER_ALIGNMENT);
            numberLab.setHorizontalAlignment(SwingConstants.CENTER);
            numberLab.setMaximumSize(new Dimension(50, 30));
            scorePanel.add(numberLab);
            JLabel scoreLab = new JLabel(score.getScore()+"");
            scorePanel.add(scoreLab);
            scoreLab.setAlignmentX(CENTER_ALIGNMENT);
            scoreLab.setHorizontalAlignment(SwingConstants.CENTER);
            scoreLab.setMaximumSize(new Dimension(50, 30));
            JLabel weightLab = new JLabel(score.getWeight()+"");
            scorePanel.add(weightLab);
            weightLab.setAlignmentX(CENTER_ALIGNMENT);
            weightLab.setHorizontalAlignment(SwingConstants.CENTER);
            weightLab.setMaximumSize(new Dimension(50, 30));
            JButton deleteButton = new JButton("x");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Gui topFrame = Gui.getMainFrame();
                    topFrame.getModule().removeScore(score);
                    topFrame.setContentPane(new ScorePanel());
                    topFrame.revalidate();
                    topFrame.repaint();
                }
            });
            scorePanel.add(deleteButton);
            deleteButton.setAlignmentX(CENTER_ALIGNMENT);
            deleteButton.setMaximumSize(new Dimension(50, 30));
            scrollPanel.add(scorePanel);
            i++;
        }
        
        if(i == 1){
            scrollPanel.add(new JLabel("Keine Noten Vorhanden"));
        }
        
        scoreList.add(scrollPanel);
        centerPanel.add(scoreList);
        add(centerPanel, BorderLayout.CENTER);
        
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setMaximumSize(new Dimension(90, 140));
        sidePanel.setBackground(Color.DARK_GRAY);
        JLabel sideNumber = new JLabel("Nummer");
        sideNumber.setForeground(Color.WHITE);
        sideNumber.setBackground(Color.DARK_GRAY);
        sideNumber.setMaximumSize(new Dimension(90, 30));
        JLabel sideScore = new JLabel("Note");
        sideScore.setForeground(Color.WHITE);
        sideScore.setBackground(Color.DARK_GRAY);
        sideScore.setMaximumSize(new Dimension(90, 30));
        JLabel sideWeight = new JLabel("Gewichtung");
        sideWeight.setForeground(Color.WHITE);
        sideWeight.setBackground(Color.DARK_GRAY);
        sideWeight.setMaximumSize(new Dimension(90, 30));
        JLabel sideDelete = new JLabel("Löschen");
        sideDelete.setForeground(Color.WHITE);
        sideDelete.setBackground(Color.DARK_GRAY);
        sideDelete.setMaximumSize(new Dimension(90, 30));
        sidePanel.add(sideNumber);
        sidePanel.add(sideScore);
        sidePanel.add(sideWeight);
        sidePanel.add(sideDelete);
        add(sidePanel, BorderLayout.WEST);
        
    }
    
    private void addBottomPanel() {
        // Buttons erzeugen
        save = new JButton("Speichern");
        save.setBackground(Color.orange);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double score = Double.parseDouble(scoreText.getText());
                    int weight = Integer.parseInt(weightText.getText());
                    Gui topFrame = Gui.getMainFrame();
                    topFrame.getModule().addScore(score, weight);
                    topFrame.setContentPane(new ScorePanel());
                    topFrame.revalidate();
                    topFrame.repaint();
                }catch(NumberFormatException nfe){
                    //show an Error
                }
            }
        });
        cancel = new JButton("Zurück");
        cancel.setBackground(Color.orange);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui topFrame = Gui.getMainFrame();
                topFrame.setContentPane(new ModulPanel());
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
