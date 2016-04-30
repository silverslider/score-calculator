/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.util.ArrayList;

/**
 *
 * @author braymann
 */
public class ScoreCalulator {

    /**
     * Startet das Programm. Dient in der Testphase als Testklasse bis ein UserInterface zugefügt wurde. 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Students myStudents = new Students(); 
        myStudents.addStudent("Muster", "Monika");
        System.out.println(myStudents.getStudent("Muster").getName());
        System.out.println(myStudents.getStudent("Muster").getAverage());
    }   
}
