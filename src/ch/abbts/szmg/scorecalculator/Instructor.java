/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

/**
 * Definiert Dozenten (Lehrpersonen). 
 * Wird von Person abgeleitet. 
 * @author Simon Zobrist
 */
public class Instructor extends Person {
    
    public Instructor(String name, String preName) {
        super(name, preName);
    }
    
}
