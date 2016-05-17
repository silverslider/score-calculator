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
class ModuleCmd {
    private final String[] moduleMenu = new String[] {"Note hinzufügen", "Noten anzeigen", "Zurück"};
    KeyboardReader keyboard = new KeyboardReader();
    private int option;
    private final int indexStud, indexSem, indexMod;
    

    ModuleCmd(int indexStudent, int indexSemester, int indexModule) {
        indexStud = indexStudent;
        indexSem = indexSemester;
        indexMod = indexModule; 
    }

    void startCmd() {
        do {
            showModuleMenu();
            option = keyboard.readInt();
            switch(option) {
                case 0: 
                    System.out.print("Note: \t\t");
                    double score = keyboard.readDouble();
                    System.out.print("Gewichtung: \t");
                    int weight = keyboard.readInt();
                    Students.getInstance().getStudent(indexStud).getSemester(indexSem).getModule(indexMod).addScore(score, weight);
                    break;
                case 1: 
                    System.out.println("------------ Noten ------------");
                    for (int i = 0; Students.getInstance().getStudent(indexStud).getSemester(indexSem).getModule(indexMod).getScore(i) != null; i++) {
                        System.out.println(Students.getInstance().getStudent(indexStud).getSemester(indexSem).getModule(indexMod).getScore(i).getScore());
                    }
                    break;
                case 2:
                    System.out.println("Programm wird beendet. ");
                    break; 
                default: 
                    System.out.println("Menu nicht verfügbar! \nGeben Sie eine gültige Zahl ein! \nBeenden Sie mit " + (moduleMenu.length-1));
            }
        } while (option != moduleMenu.length-1);
    }
    private void showModuleMenu() {
        int i=0;
        System.out.println("------------ Fach ------------");
        for (String tempMenu : moduleMenu) {
        System.out.println(i + " " + tempMenu);
        i++;
        }
        System.out.println(" ");
    }
}
