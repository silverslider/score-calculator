/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

/**
 *
 * @author braymann
 */
public class ScoreCalculator {
    public ScoreCalculator() {
        startCmd();
    }

    /**
     * Startet das Programm. Dient in der Testphase als Testklasse bis ein UserInterface zugefügt wurde. 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ScoreCalculator Notenrechner = new ScoreCalculator();    
    }
    private void startCmd() {
        Students.getInstance().addStudent("Müller", "Mike");
        System.out.println(Students.getInstance().getStudent(0).getName());
        Students.getInstance().getStudent(0).addSemester("WS 2015", "Wintersemester 2015");
        System.out.println(Students.getInstance().getStudent(0).getSemester(0).getName());
        Students.getInstance().getStudent(0).getSemester(0).addModule("MAT", "Mathe");
        System.out.println(Students.getInstance().getStudent(0).getSemester(0).getModule(0).getName());
        
    }
}
