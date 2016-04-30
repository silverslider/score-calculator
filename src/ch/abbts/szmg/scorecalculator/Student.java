/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.util.ArrayList;

/**
 * Definiert Student. 
 * Erzeugt Semester und weist diese dem jeweiligen Studenten zu. 
 * @author szobrist
 */
public class Student extends Person {
    private ArrayList<Semester> semesters;
    
    public Student(String name, String preName) {
        super(name, preName);
        this.semesters = new ArrayList<Semester>();
    }
    /**
     * Errechnet Notenschnitt des Studenten. 
     * Gibt den Gesamtnotenschnitt des Studenten zurück. 
     * @return Notendurchschnitt (arithmetisches Mittel) aller Semester. 
     */
    public double getAverage() {
        double average, sum = 0;
        for(Semester tempSemester : semesters) {
            if(tempSemester != null) {
                sum += tempSemester.getAverage();
            }
        }
        average = Math.round((sum / semesters.size()) * 10) / 10.0;
        return average;
    }

    
}
