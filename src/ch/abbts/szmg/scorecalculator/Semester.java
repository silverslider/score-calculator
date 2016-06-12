/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Definiert Semester. 
 * Erzeugt Module und weist diese dem Semester zu. 
 * Ist serialisierbar. 
 * @author Simon Zobrist
 */
public class Semester implements Serializable {
    private String name;
    private String description;
    private ArrayList<Module> modules;
    /**
     * Erzeugt ein Semester mit Name und Beschreibung. 
     * @param name String Name des Semesters. 
     * @param description String Beschreibung des Semesters. 
     */
    public Semester(String name, String description) {
        this.modules = new ArrayList<Module>();
        this.name = name;
        this.description = description;         
    }
    /**
     * Gibt den Namen des Semesters zurück. 
     * @return String Name des Semesters. 
     */
    public String getName() {
        return name; 
    }
    /**
     * Erzeugt ein neues Modul (Fach). 
     * @param name String Name des Moduls. 
     * @param description String Beschreibung des Moduls. 
     * @param instructorName String Name des Dozenten für das Modul. 
     */
    public void addModule(String name, String description, String instructorName) {
        modules.add(new Module(name, description, instructorName));
    }
    /**
     * Fügt ein neues Modul der Modulsammlung (ArrayList of Module) hinzu. 
     * @param module Module Modulobjekt das hinzugefügt werden soll. 
     */
    public void addModule(Module module) {
        modules.add(module);
    }
    /**
     * Gibt das Modul anhand des ArraList Index zurück. 
     * @param index int ArrayList index für das Modul. 
     * @return 
     */
    public Module getModule(int index) {
        Module tempModule = null;
        if (index < modules.size()) {
           tempModule = modules.get(index);
        }
        return tempModule;
    }
    /**
     * Gibt die ArrayList mit den erfassten Modulen zurück. 
     * @return ArrayList Objekttyp Module 
     */
    public ArrayList<Module> getModules() {
        return modules;
    }
    /**
     * Löscht das übergebene Modul aus der ArrayList. 
     * @param module Module Zu löschendes Modulobjekt. 
     */
    public void removeModule(Module module){
        modules.remove(module);
    }
    /**
     * Berechnet den Notenschnitt aller Module (Semesternotenschnitt). 
     * @return double Notendurchschnitt aller Module. 
     */
    public double getAverage() {
        double average, sum = 0;
        for(Module tempModule : modules) {
            if(tempModule != null) {
                sum += tempModule.getAverage();
            }
        }
        average = Math.round((sum / modules.size()) * 10) / 10.0;
        if (average == 0) {
            average ++;
        }
        return average; 
    }
    /**
     * Gibt die Beschreibung des Semesters zurück. 
     * @return String Beschreibung. 
     */
    public String getdescription() {
        return description;
    }
}
