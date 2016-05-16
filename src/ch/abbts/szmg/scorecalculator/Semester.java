/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.util.ArrayList;

/**
 * Definiert Semester. 
 * Erzeugt Module und weist diese dem Semester zu. 
 * @author szobrist
 */
public class Semester {
    private String name;
    private String description;
    private ArrayList<Module> modules;
    
    public Semester(String name, String description) {
        this.modules = new ArrayList<Module>();
        this.name = name;
        this.description = description;         
    }
    /**
     * Gibt den Namen des Semesters zurück. 
     * @return Nachname des Semesters. 
     */
    public String getName() {
        return name; 
    }
    /**
     * Erzeugt ein neues Modul (Fach). 
     * @param name Name des Moduls. 
     * @param description Beschreibung des Moduls. 
     */
    public void addModule(String name, String description) {
        modules.add(new Module(name, description));
    }
    public Module getModule(int index) {
        Module tempModule = modules.get(index);
        return tempModule;
    }
    /**
     * Berechnet den Notenschnitt aller Module. 
     * @return Notendurchschnitt aller Module. 
     */
    public double getAverage() {
        double average, sum = 0;
        for(Module tempModule : modules) {
            if(tempModule != null) {
                sum += tempModule.getAverage();
            }
        }
        average = Math.round((sum / modules.size()) * 10) / 10.0;
        return average; 
    }
}
