/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.util.ArrayList;

/**
 *
 * @author szobrist
 */
public class Students {
    private ArrayList<Student> students;

    private Students() {
        students = new ArrayList<Student>();
    }
    public Student getStudent(String nameOfStudent) {
        Student ret = null;
        for(Student tempStudent : students) {
            if(tempStudent.getName().equals(nameOfStudent)) {
                ret = tempStudent; 
            }
        }
        return ret;
    }
    public void addStudent(String name, String preName) {
        students.add(new Student(name, preName));
    }
}
