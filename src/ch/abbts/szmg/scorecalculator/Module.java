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
public class Module {
    private String name;
    private String description; 
    private ArrayList<Score> scores; 
    
    public Module(String name, String description) {
        this.name = name; 
        this.description = description; 
    }
    public String getName() {
        return name; 
    }
    public void newScore(double score, int weight) {
        scores.add(new Score(score, weight)); 
    }
    public double getAverage() {
        double average; 
        for(Score tempScore : scores) {
            
        }
        return average; 
    }
}
