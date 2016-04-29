/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

/**
 *
 * @author szobrist
 */
public class Score {
    private double score; 
    private int weight; 
    
    public Score(double score, int weight) {
        this.score = score; 
        this.weight = weight; 
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        if (score >=1 && score <= 6) {
            this.score = score; 
        }
    }
    public int getWeight() {
        return weight; 
    }
    public void setWeight(int weight) {
        if (weight >=1 && weight <= 100) {
            this.weight = weight; 
        }
    }
}
