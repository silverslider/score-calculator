/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.util.ArrayList;

/**
 * Es können Studenten erzeugt und verwaltet werden. 
 * @author szobrist
 */
public class Students {
    private ArrayList<Student> students;
    static boolean status = false; 

    public Students() {
        status = true;
        students = new ArrayList<Student>();
    }
    /**
     * Instanziert ein Objekt vom Typ Students. Es kann nur ein Objekt Students erzeugt werden. 
     * Dient als Zugriff zur Notenberechnungsstruktur. 
     */
    /* Für Testphase deaktiviert. Garantiert danach den Zugriff auf Students Klasse damit nur ein Objekt dieses Typs erzeugt werden kann. 
    public static void createStudents() {
        if (status == false) {
            Students allStudents = new Students();
        }
    } */
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
    /**
     * Erzeugt ein Objekt des Typs Student. 
     * @param name Nachname des Studenten. 
     * @param preName Vorname des Studenten. 
     */
    public void addStudent(String name, String preName) {
        students.add(new Student(name, preName));
    }
}
