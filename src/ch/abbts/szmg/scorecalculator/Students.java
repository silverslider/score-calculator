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
 * Initialisierung von Studenten ist nur über die statische Methode getInstance möglich. 
 * Es kann nur ein Students Objekt zur gleichen Zeit existieren. 
 * Ist serialisierbar. 
 * @author Simon Zobrist
 */
public class Students implements Serializable {
    private static Students instance; 
    private ArrayList<Student> students;

    private Students() {
        students = new ArrayList<>();
    }
    /**
     * Instanziert ein Objekt vom Typ Students. Es kann nur ein Objekt Students erzeugt werden. 
     * Dient als Zugriff zur Notenberechnungs- und -verwaltungsstruktur. 
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
    /**
     * Gibt einen Studenten nach ArrayList of Student index zurück. 
     * @param index int ArrayList Index des zu übergebenden Studenten. 
     * @return Student Gibt ein Studentenobjekt zurück. 
     */
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
    /**
     * Fügt den übergebenen Studenten der ArrayList of Student hinzu. 
     * @param student Student Nimmt das Studentenobjekt entgegen welches gespeichert werden soll. 
     */
    public void addStudent(Student student) {
        students.add(student);
    }
    /**
     * Löscht den übergebenen Studenten aus der Studentensammlung (ArrayList of Student). 
     * @param student Student Zu löschender Student. 
     */
    public void removeStudent(Student student){
        students.remove(student);
    }
    /**
     * Setzt das Students Objekt. 
     * Wird zum Laden der serialisierten Objekte verwendet. 
     * @param students Students 
     */
    public static void setStudents(Students students) {
        instance = students;
    }
    /**
     * Gibt die Studentensammlung zurück. 
     * @return ArrayList of Student 
     */
    public ArrayList<Student> getStudents(){
        return students;
    }
    /**
     * Löscht alle Studenten und die darin enthaltenen Semester, Module und Noten
     * indem das Students Objekt zurückgesetzt wird. 
     */
    public static void removeStudents() {
        instance = null;
    }
}
