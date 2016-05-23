/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.io.Serializable;

/**
 * Definiert Noten. 
 * @author szobrist
 */
public class Score implements Serializable {
    private double score; 
    private int weight; 
    
    public Score(double score, int weight) {
        this.score = score; 
        this.weight = weight; 
    }
    /**
     * Gibt Notenwert zurück. 
     * @return Notenwert. 
     */
    public double getScore() {
        return score;
    }
    /**
     * Setzt den bestehenden Notenwert. 
     * @param score Notenwert von 1.0 bis 6.0
     */
    public void setScore(double score) {
        if (score >=1 && score <= 6) {
            this.score = score; 
        }
    }
    /**
     * Gibt die Gewichtung einer Note zurück. 
     * @return Gewichtung der Note. 
     */
    public int getWeight() {
        return weight; 
    }
    /**
     * Setzt die Gewichtung einer Note zwischen 1 und 100%
     * @param weight Gewichtung der Note. 
     */
    public void setWeight(int weight) {
        if (weight >=1 && weight <= 100) {
            this.weight = weight; 
        }
    }
}
