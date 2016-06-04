/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Es können Studenten erzeugt und verwaltet werden. 
 * @author szobrist
 */
public class Students implements Serializable {
    private static Students instance; 
    private ArrayList<Student> students;

    private Students() {
        students = new ArrayList<>();
    }
    /**
     * Instanziert ein Objekt vom Typ Students. Es kann nur ein Objekt Students erzeugt werden. 
     * Dient als Zugriff zur Notenberechnungsstruktur. 
     */
    public static Students getInstance() {
        if (instance == null) {
            instance = new Students();
        }
        return Students.instance;
    } 
    /**
     * Sucht einen Studenten über dessen Nachname, und gibt das Objekt zurück. 
     * @param nameOfStudent Nachname des Studenten. 
     * @return Objekt Student der nach Name gesucht wurde.  
     */
    public Student getStudent(String nameOfStudent) {
        Student ret = null;
        for(Student tempStudent : students) {
            if(tempStudent.getName().equals(nameOfStudent)) {
                ret = tempStudent; 
            }
        }
        return ret;
    }
    public Student getStudent(int index) {
        Student tempStudent = null;
        if (index < students.size()) {
            tempStudent = students.get(index);
        }
        return tempStudent;
    }
    /**
     * Erzeugt ein Objekt des Typs Student. 
     * @param name Nachname des Studenten. 
     * @param preName Vorname des Studenten. 
     */
    public void addStudent(String name, String preName) {
        students.add(new Student(name, preName));
    }
    public static void setStudents(Students students) {
        instance = students;
    }
    public static void removeStudents() {
        instance = null;
    }
}
