/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator.gui;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author mg
 */
public class TopMenuBar extends JMenuBar {
    
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    
    public TopMenuBar() {
        initMenuBar();
    }    
    private void initMenuBar() {
                
        // Menübar erzeugen
        menuBar = new JMenuBar();
        
        // Menü Datei
        menu = new JMenu("Datei");
        menuBar.add(menu);
        
        // Menüeintrag Datei -> Neu
        menuItem = new JMenuItem("Neu");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hallo Neu");
            }
        });
        
        // Menüeintrag Datei -> Speichern
        menuItem = new JMenuItem("Speichern");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hallo Save");
            }
        });
        // Menüeintrag Datei -> Laden
        menuItem = new JMenuItem("Laden");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hallo Load");
            }
        });
                
        // Menüeintrag Datei -> schliessen
        menuItem = new JMenuItem("Schliessen");
        menu.add(menuItem);
        
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
                
        // Menü Aktion
        menu = new JMenu("Aktion");
        menuBar.add(menu);
        
        // Menüeintrag Aktion -> Student hinzufügen
        menuItem = new JMenuItem("Student hinzufügen");
        menu.add(menuItem);
        
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hallo Student");
            }
        });
        
        add(menuBar);
    }
}
