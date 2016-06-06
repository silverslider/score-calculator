/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Definiert Module (Fächer). Erzeugt Noten. 
 * @author szobrist
 */
public class Module implements Serializable {
    private String name;
    private String description; 
    private ArrayList<Score> scores; 
    
    public Module(String name, String description) {
        this.scores = new ArrayList<Score>();
        this.name = name; 
        this.description = description; 
    }
    /**
     * Gibt den Namen des Moduls zurück. 
     * @return Name des Moduls. 
     */
    public String getName() {
        return name; 
    }
    /** 
     * Erzeugt eine neue Note mit Gewichtung. 
     * @param score Notenwert zwischen 1 und 6. 
     * @param weight Gewichtung der Note von 1 bis 100%. 
     */
    public void addScore(double score, int weight) {
        scores.add(new Score(score, weight)); 
    }
    public Score getScore(int index) {
        Score tempScore = null;
        if (index < scores.size()) {
            tempScore = scores.get(index);
        }
        return tempScore;
    }
    public ArrayList<Score> getScores() {
        return scores;
    }
    /** 
     * Berechnet den Notenschnitt eines Moduls und gibt den Notenschnitt zurück. 
     * @return Notenschnitt Modul. 
     */
    public double getAverage() {
        double average, sumXiFi = 0, sumFi = 0;
        for(Score tempScore : scores) {
            if(tempScore != null) {
                sumXiFi += tempScore.getScore() * tempScore.getWeight();
                sumFi += tempScore.getWeight();
            }
        }
        average = Math.round((sumXiFi / sumFi) * 10) / 10.0;
        return average; 
    }
}
