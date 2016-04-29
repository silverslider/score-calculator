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
        ArrayList<Module> faecher = new ArrayList<Module>();
        
        faecher.add(new Module("MAT", "Mathe"));
        
        faecher.get(0).newScore(6, 100);
        faecher.get(0).newScore(4.5, 60);
        faecher.get(0).newScore(4, 30);
        faecher.get(0).newScore(3.5, 80);
        faecher.get(0).newScore(5.3, 100);
        
        System.out.println("Fach. " +faecher.get(0).getName() + "\nNote: " + faecher.get(0).getAverage());
    }
    
}
