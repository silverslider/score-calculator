/*
 * Die Applikation ScoreCalculator ist eine Notenberechnungssoftware. 
 * Mit ScoreCalculator können Studenten erfasst und deren Noten verwaltet werden. 
 * Es können Studenten, Semester, Fächer und Noten erfasst und der jeweilige Notenschnitt berechnet werden. 
 * Ausserdem kann einem Fasch jeweils ein Dozent zugewiesen werden. 
 */
package ch.abbts.szmg.scorecalculator;

import java.io.IOException;

/**
 * Main Klasse. Dient dem Programmstart. 
 * @author Simon Zobrist
 */
public class ScoreCalculator {
    /**
     * Startet das Programm Score Calculator. 
     */
    public static void main(String[] args) throws IOException {
        StudentsCmd commandline = new StudentsCmd();
        commandline.startCmd();
        
    }
}
