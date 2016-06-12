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
 * Ist serialisierbar. 
 * @author Simon Zobrist
 */
public class Module implements Serializable {
    private String name, description, instructorName;
    private ArrayList<Score> scores; 
    /**
     * Es kann ein Modul erzeugt werden. 
     * Das Modul (Schulfach) enthält: 
     * - einen Namen, 
     * - eine Beschreibung, 
     * - den Namen des Dozenten 
     * @param name String Name des Moduls
     * @param description String Beschreibung des Moduls
     * @param instructorName  String Name des Dozenten
     */
    public Module(String name, String description, String instructorName) {
        this.scores = new ArrayList<Score>();
        this.name = name; 
        this.description = description; 
        this.instructorName = instructorName;
    }
    /**
     * Gibt den Namen des Moduls zurück. 
     * @return String Name des Moduls. 
     */
    public String getName() {
        return name; 
    }
    /** 
     * Erzeugt eine neue Note mit Gewichtung. 
     * @param score double Notenwert zwischen 1 und 6. 
     * @param weight int Gewichtung der Note von 1 bis 100%. 
     */
    public void addScore(double score, int weight) {
        scores.add(new Score(score, weight)); 
    }
    /**
     * Gibt den Notenwert einer Note zurück. 
     * @param index int Erwartet den Index der Note aus der Noten-ArrayList
     * @return Score Gibt das Notenobjekt zurück. 
     */
    public Score getScore(int index) {
        Score tempScore = null;
        if (index < scores.size()) {
            tempScore = scores.get(index);
        }
        return tempScore;
    }
    /**
     * Gibt die ArrayList mit den Noten des Moduls zurück. 
     * @return ArrayList Objekttyp Score 
     */
    public ArrayList<Score> getScores() {
        return scores;
    }
    /**
     * Löscht das mitgegebene Noten Objekt aus der Noten ArrayList des Moduls. 
     * @param score Score Erwartet das zu löschende Notenobjekt. 
     */
    public void removeScore(Score score){
        scores.remove(score);
    }    
    /** 
     * Berechnet den Notenschnitt eines Moduls und gibt den Notendurchschnitt zurück. 
     * Es werden erfasste Notenwerte und Gewichtungen berücksichtigt. 
     * @return double Notenschnitt Modul gerundet auf Zehntel. 
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
    /**
     * Gibt die Beschreibung des Moduls zurück. 
     * @return String Beschreibung
     */
    public String getDescription() {
        return description;
    }
    /**
     * Gibt den Namen des Dozenten zurück. 
     * @return String Name des Dozenten. 
     */
    public String getInstructor() {
        return instructorName;
    }
}
