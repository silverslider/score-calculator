/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.io.Serializable;

/**
 * Definiert Personen. Eine Person hat einen Namen sowie einen Vornamen. 
 * Ist serialisierbar. 
 * @author Simon Zobrist
 */
public class Person implements Serializable {
    private String name;
    private String preName;
    /**
     * Es kann eine Person generiert werden. 
     * @param name String Nachname der Person
     * @param preName String Vorname der Person
     */
    public Person(String name, String preName) {
        this.name = name; 
        this.preName = preName; 
    }
    /**
     * Gibt den Nachnamen der Person zurück. 
     * @return String Nachname
     */
    public String getName() {
        return name;
    }
    /**
     * Gibt Vor- und Nachname der Person zurück. 
     * @return String Rückgabeformat: Nachname 'Leerzeichen' Vorname
     */
    public String getFullName() {
        StringBuilder name = new StringBuilder();
        name.append(this.name);
        name.append(" ");
        name.append(this.preName);
        return name.toString();
    }
}
