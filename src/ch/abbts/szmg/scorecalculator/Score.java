/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.io.Serializable;

/**
 * Definiert Noten mit Notenwert und Gewichtung. 
 * Ist Serialisierbar. 
 * @author Simon Zobrist
 */
public class Score implements Serializable {
    private double score; 
    private int weight; 
    /**
     * Es können Schulnoten generiert werden welche eine Note und eine Gewichtung enthalten. 
     * @param score double Notenwert zwischen 1 und 6
     * @param weight int Gewichtung der Note von 1 - 100%
     */
    public Score(double score, int weight) {
        this.score = score; 
        this.weight = weight; 
    }
    /**
     * Gibt den Notenwert zurück. 
     * @return double Notenwert. 
     */
    public double getScore() {
        return score;
    }
    /**
     * Setzt einen Notenwert. 
     * @param score double Notenwert. Gültiger Zahlenbereich von 1.0 bis 6.0
     */
    public void setScore(double score) {
        if (score >=1 && score <= 6) {
            this.score = score; 
        }
    }
    /**
     * Gibt die Gewichtung einer Note zurück. 
     * @return int Gewichtung der Note. 
     */
    public int getWeight() {
        return weight; 
    }
    /**
     * Setzt die Gewichtung einer Note zwischen 1 und 100%
     * @param weight int Gewichtung der Note. Gültiger Zahlenbereich von 1 - 100
     */
    public void setWeight(int weight) {
        if (weight >=1 && weight <= 100) {
            this.weight = weight; 
        }
    }
}
