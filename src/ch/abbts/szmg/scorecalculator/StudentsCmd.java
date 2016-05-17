/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Simon Zobrist
 */
public class StudentsCmd {
    private final String[] studentsMenu = new String[] {"Student hinzufügen", "Studenten anzeigen", "Studenten speichern", "Studenten laden", "Beenden"};
    private final InputStreamReader InputStream = new InputStreamReader(System.in);
    private final BufferedReader br = new BufferedReader(InputStream);
    int option;

    public StudentsCmd() {
    }
    public void startCmd() throws IOException {

        do {
            showStudentsMenu();
            option = readInt();
            switch(option) {
                case 0: 
                    System.out.print("Name: \t\t");
                    String name = readString();
                    System.out.print("Vorname: \t");
                    String preName = readString();
                    Students.getInstance().addStudent(name, preName);
                    break;
                case 1: 
                    for (int i = 0; Students.getInstance().getStudent(i) != null; i++) {
                        System.out.println(i + " " + Students.getInstance().getStudent(i).getName());
                    }
                    break;
                case 2:
                    System.out.println("Datei kann nicht gespeichert werden! \nGrund: Aktion wird nicht unterstützt.");
                    break;
                case 3:
                    System.out.println("Datei kann nicht geladen werden! \nGrund: Keine Datei gespeichert.");
                    break;
                case 4: 
                    System.out.println("Programm wird beendet. ");
                    break; 
                default: 
                    System.out.println("Menu nicht verfügbar! \nGeben Sie eine gültige Zahl ein! \nBeenden Sie mit " + (studentsMenu.length-1));
            }
        } while (option != studentsMenu.length-1);
    }
    private void showStudentsMenu() {
        int i=0;
        System.out.println("------------ Menu ------------");
        for (String tempMenu : studentsMenu) {
        System.out.println(i + " " + tempMenu);
        i++;
        }
        System.out.println(" ");
    }
    private int readInt() {
        int line = -1;
        try {
            line = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Ungültige Eingabe! \nGeben Sie eine Ganzzahl ein.");
        } catch (NumberFormatException ex) {
            System.out.println("Ungültige Eingabe! \nGeben Sie eine Zahl ein.");
        }
        return line;
    }
    private String readString() {
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Ungültige Eingabe! \nGeben Sie eine Ganzzahl ein.");
        }
        return line;
    }
    @SuppressWarnings("empty-statement")
    public static void clearConsole() {
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
