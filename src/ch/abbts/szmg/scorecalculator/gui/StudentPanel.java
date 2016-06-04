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
public class StudentPanel extends JPanel {
    
    private JPanel studentPanel;
    private JTextField preName, lastName;
    private JButton save, cancel;
    
    public StudentPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.LIGHT_GRAY);
        cancel = new JButton("Zurück");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = Gui.getMainFrame();
                topFrame.setContentPane(new MainPanel());
                topFrame.revalidate();
                topFrame.repaint();
            }
        });
        this.add(cancel);
        
    }
    
    
}
