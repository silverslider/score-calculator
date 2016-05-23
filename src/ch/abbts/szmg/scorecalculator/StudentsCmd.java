/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Beinhaltet das User Interface. 
 * @author Simon Zobrist
 */
public class StudentsCmd {
    private final String[] studentsMenu = new String[] {"Student hinzufügen", "Studenten anzeigen", "Studenten speichern", "Studenten laden", "Beenden"};
    KeyboardReader keyboard = new KeyboardReader();
    private int option;

    public StudentsCmd() {
    }

    /**
     * Startet das Menu in der Konsole
     */
    public void startCmd() {
        do {
            showStudentsMenu();
            option = keyboard.readInt();
            switch(option) {
                case 0: 
                    System.out.print("Name: \t\t");
                    String name = keyboard.readString();
                    System.out.print("Vorname: \t");
                    String preName = keyboard.readString();
                    Students.getInstance().addStudent(name, preName);
                    break;
                case 1: 
                    System.out.println("------------ Student auswählen ------------");
                    for (int x = 0; Students.getInstance().getStudent(x) != null; x++) {
                        System.out.println(x + " " + Students.getInstance().getStudent(x).getName());
                    }
                    int indexStud = keyboard.readInt();
                    StudentCmd cmd = new StudentCmd(indexStud);
                    cmd.startCmd();
                    break;
                case 2:
                    try {
                        // System.out.println("Datei kann nicht gespeichert werden! \nGrund: Aktion wird nicht unterstützt.");
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
                        oos.writeUnshared(Students.getInstance());
                        oos.flush();
                        oos.close();
                    } catch (IOException ex) {
                        Logger.getLogger(StudentsCmd.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    // System.out.println("Datei kann nicht geladen werden! \nGrund: Keine Datei gespeichert.");
                    
                    try {
                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
                            Students.setStudents((Students) ois.readObject());
                            ois.close();
                            
                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(StudentsCmd.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break;
                case 4: 
                    System.out.println("Programm wird beendet. ");
                    break; 
                default: 
                    System.out.println("Menu nicht verfügbar! \nGeben Sie eine gültige Zahl ein! \nBeenden Sie mit " + (studentsMenu.length-1));
            }
        } while (option != studentsMenu.length-1);
    }
    /**
     * Zeigt dynamisch das Menu an. 
     */
    private void showStudentsMenu() {
        int m=0;
        System.out.println("------------ Hauptmenu ------------");
        for (String tempMenu : studentsMenu) {
        System.out.println(m + " " + tempMenu);
        m++;
        }
        System.out.println(" ");
    }
    /**
     * Löscht die Anzeige der Konsole
     */
    @SuppressWarnings("empty-statement")
    private static void clearConsole() {
    try {
        Robot pressbot = new Robot();
        pressbot.keyPress(17); // Holds CTRL key.
        pressbot.keyPress(76); // Holds L key.
        pressbot.keyRelease(17); // Releases CTRL key.
        pressbot.keyRelease(76); // Releases L key.
    } catch (AWTException ex) {
        System.out.println("Fehler beim löschen der Konsole!");;
    }
}
}
