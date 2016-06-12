/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Definiert Student. 
 * Erzeugt Semester und weist diese dem jeweiligen Studenten zu. 
 * Ist serialisierbar. Wird von Person abgeleitet. 
 * @author Simon Zobrist
 */
public class Student extends Person implements Serializable{
    private ArrayList<Semester> semesters;
    /**
     * Erzeugt einen Studenten mit Vor- und Nachname. 
     * @param name String Nachname des Studenten. 
     * @param preName String Vorname des Studenten. 
     */
    public Student(String name, String preName) {
        super(name, preName);
        this.semesters = new ArrayList<Semester>();
    }
    /**
     * Errechnet den Notenschnitt des Studenten anhand aller Semesternoten. 
     * Gibt den Gesamtnotenschnitt des Studenten zurück. 
     * @return double Notendurchschnitt (arithmetisches Mittel) aller Semesternoten. 
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
    /**
     * Fügt dem Studenten ein neues Semester hinzu. 
     * Erwartet Name und Beschreibung des Semesters. 
     * @param name String Name des Semesters
     * @param description String Beschreibung des Semesters. 
     */
    public void addSemester(String name, String description) {
        semesters.add(new Semester(name, description));
    }
    /**
     * Fügt dem Studenten ein neues Semester hinzu. 
     * Erwartet das anzulegende Semesterobjekt.
     * @param semester Semester Semesterobjekt
     */
    public void addSemester(Semester semester) {
        semesters.add(semester);
    }
    /**
     * Gibt ein Semester aufgrund des ArrayList index zurück. 
     * Erwartet den ArrayList index des Semesters. 
     * @param index int ArrayList of Semester Index des Semesters
     * @return Semester
     */
    public Semester getSemester(int index) {
        Semester tempSemester = null;
        if (index < semesters.size()) {
            tempSemester = semesters.get(index);
        }
        return tempSemester;
    }
    /**
     * Gibt ein Semester anhand des übergebenen Semesters zurück. 
     * @param semester Semester 
     * @return Semester
     */
    public Semester getSemester(Semester semester) {
        Semester tempSemester = null;
        for(Semester element : semesters) {
            if(semesters.equals(element)) {
                tempSemester = element;
            }
        }
        return tempSemester;
    }
    /**
     * Gibt die Semestersammlung (ArrayList of Semester) zurück. 
     * @return ArrayList of Semester
     */
    public ArrayList<Semester> getSemesters() {
        return semesters;
    }
    /**
     * Löscht das übergebene Semesterobjekt aus der Semester ArrayList. 
     * @param semester Semester Erwartet das zu löschende Semesterobjekt. 
     */
    public void removeSemester(Semester semester){
        semesters.remove(semester);
    }  
    
}
