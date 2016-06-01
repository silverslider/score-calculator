/*
 * Die Applikation ScoreCalculator ist eine Notenberechnungssoftware. 
 * Mit ScoreCalculator können Studenten erfasst und deren Noten verwaltet werden. 
 * Es können Studenten, Semester, Fächer und Noten erfasst und der jeweilige Notenschnitt berechnet werden. 
 * Ausserdem kann einem Fasch jeweils ein Dozent zugewiesen werden. 
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
        /*StudentsCmd commandline = new StudentsCmd();
        commandline.startCmd();*/
        
        new Gui();
        
    }
}
