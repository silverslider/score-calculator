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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        
        students.add(new Student("Muster", "Max"));
        
        System.out.println(students.get(0).getName());
    }   
}
