/*
 * Die Applikation ScoreCalculator ist eine Notenverwaltungssoftware. 
 * Mit ScoreCalculator können Studenten erfasst und deren Noten pro Semester und Modul verwaltet werden. 
 * Es können Studenten, Semester, Fächer und Noten erfasst und der jeweilige Notenschnitt berechnet werden. 
 * Ausserdem kann einem Fach jeweils ein Dozent zugewiesen werden. 
 */
package ch.abbts.szmg.scorecalculator;
import ch.abbts.szmg.scorecalculator.gui.*;

/**
 * Main Klasse. Dient dem Programmstart. 
 * @author Simon Zobrist
 */
public class ScoreCalculator {
    /**
     * Startet das Programm Score Calculator. 
     * @param args
     */
    public static void main(String[] args) {        
        new Gui();
    }
}
