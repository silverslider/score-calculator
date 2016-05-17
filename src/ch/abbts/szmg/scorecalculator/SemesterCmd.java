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
class SemesterCmd {
    private final String[] semesterMenu = new String[] {"Fach hinzufügen", "Fächer anzeigen", "Zurück"};
    KeyboardReader keyboard = new KeyboardReader();
    private int option;
    private final int indexStud, indexSem;
    
    public SemesterCmd(int indexStudent, int indexSemester) {
        indexStud = indexStudent;
        indexSem = indexSemester;
    }
    public void startCmd() {
        do {
            showSemesterMenu();
            option = keyboard.readInt();
            switch(option) {
                case 0: 
                    System.out.print("Name: \t\t");
                    String name = keyboard.readString();
                    System.out.print("Beschreibung: \t");
                    String discription = keyboard.readString();
                    Students.getInstance().getStudent(indexStud).getSemester(indexSem).addModule(name, discription);
                    break;
                case 1: 
                    System.out.println("------------ Fach auswählen ------------");
                    for (int i = 0; Students.getInstance().getStudent(indexStud).getSemester(indexSem).getModule(i) != null; i++) {
                        System.out.println(i + " " + Students.getInstance().getStudent(indexStud).getSemester(indexSem).getModule(i).getName());
                    }
                    int indexMod = keyboard.readInt();
                    ModuleCmd cmd = new ModuleCmd(indexStud, indexSem, indexMod);
                    cmd.startCmd();
                    break;
                case 2:
                    System.out.println("Programm wird beendet. ");
                    break; 
                default: 
                    System.out.println("Menu nicht verfügbar! \nGeben Sie eine gültige Zahl ein! \nBeenden Sie mit " + (semesterMenu.length-1));
            }
        } while (option != semesterMenu.length-1);
    }
    private void showSemesterMenu() {
        int i=0;
        System.out.println("------------ Semester ------------");
        for (String tempMenu : semesterMenu) {
        System.out.println(i + " " + tempMenu);
        i++;
        }
        System.out.println(" ");
    }
}
