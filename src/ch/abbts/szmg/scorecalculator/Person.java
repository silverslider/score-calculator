/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.io.Serializable;

/**
 *
 * @author szobrist
 */
public class Person implements Serializable {
    private String name;
    private String preName;
    
    public Person(String name, String preName) {
        this.name = name; 
        this.preName = preName; 
    }
    public String getName() {
        return name;
    }
}
