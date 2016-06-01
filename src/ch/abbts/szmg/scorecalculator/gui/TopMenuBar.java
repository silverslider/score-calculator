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
        
        // Menübar erzeugen
        menuBar = new JMenuBar();
        
        // Menü Datei
        menu = new JMenu("Datei");
        menuBar.add(menu);
        
        // Menüeintrag Datei -> Neu
        menuItem = new JMenuItem("Neu");
        menu.add(menuItem);
        
        Closer listener = new Closer();
        menuItem.addActionListener(listener);
                
        // Menüeintrag Datei -> schliessen
        menuItem = new JMenuItem("Schliessen");
        menu.add(menuItem);
        
        menuItem.addActionListener(listener);
                
        // Menü Bearbeiten
        menu = new JMenu("Bearbeiten");
        menuBar.add(menu);
        
        add(menuBar);
    }
    
    // Actionlistener für schliessen
    class Closer implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    // windowslistener für schliessen
    class MyWindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    
}
