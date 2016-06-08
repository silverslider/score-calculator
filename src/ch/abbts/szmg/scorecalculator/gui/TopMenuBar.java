/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator.gui;
import ch.abbts.szmg.scorecalculator.Students;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                Students.removeStudents();
            }
        });
        
        // Menüeintrag Datei -> Speichern
        menuItem = new JMenuItem("Speichern");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
                    oos.writeUnshared(Students.getInstance());
                    oos.flush();
                    oos.close();
                    JOptionPane.showMessageDialog(null, "Daten gespeichert");
                } catch (IOException ex) {
                    Logger.getLogger(TopMenuBar.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Speichern fehlgeschlagen");
                }
            }
        });
        // Menüeintrag Datei -> Laden
        menuItem = new JMenuItem("Laden");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
                    Students.setStudents((Students) ois.readObject());
                    ois.close();
                    JOptionPane.showMessageDialog(null, "Daten geladen");
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(TopMenuBar.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Laden fehlgeschlagen");
                }
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
                JFrame topFrame = Gui.getMainFrame();
                topFrame.setContentPane(new StudentPanel());
                topFrame.revalidate();
                topFrame.repaint();
            }
        });
        
        add(menuBar);
    }
}
