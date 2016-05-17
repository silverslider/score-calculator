/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

/**
 *
 * @author Simon
 */
public class StudentCmd {
    private final String[] studentMenu = new String[] {"Semester hinzufügen", "Semester anzeigen", "Zurück"};
    KeyboardReader keyboard = new KeyboardReader();
    private int option;
    private final int indexStud;
    
    public StudentCmd(int i) {
        indexStud = i;
    }
    public void startCmd() {
        do {
            showStudentMenu();
            option = keyboard.readInt();
            switch(option) {
                case 0: 
                    System.out.print("Name: \t\t");
                    String name = keyboard.readString();
                    System.out.print("Beschreibung: \t");
                    String discription = keyboard.readString();
                    Students.getInstance().getStudent(indexStud).addSemester(name, discription);
                    break;
                case 1: 
                    System.out.println("------------ Semester auswählen ------------");
                    for (int i = 0; Students.getInstance().getStudent(indexStud).getSemester(i) != null; i++) {
                        System.out.println(i + " " + Students.getInstance().getStudent(indexStud).getSemester(i).getName());
                    }
                    int indexSem = keyboard.readInt();
                    SemesterCmd cmd = new SemesterCmd(indexStud, indexSem);
                    cmd.startCmd();
                    break;
                case 2:
                    System.out.println("Programm wird beendet. ");
                    break; 
                default: 
                    System.out.println("Menu nicht verfügbar! \nGeben Sie eine gültige Zahl ein! \nBeenden Sie mit " + (studentMenu.length-1));
            }
        } while (option != studentMenu.length-1);
    }
    private void showStudentMenu() {
        int i=0;
        System.out.println("------------ Student ------------");
        for (String tempMenu : studentMenu) {
        System.out.println(i + " " + tempMenu);
        i++;
        }
        System.out.println(" ");
    }
    
}
