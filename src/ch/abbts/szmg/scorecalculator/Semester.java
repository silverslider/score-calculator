/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.util.ArrayList;

/**
 *
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
    
}
