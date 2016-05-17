/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Liest Daten von der Tastatur ein. 
 * @author Simon
 */
public class KeyboardReader {
    private final InputStreamReader is = new InputStreamReader(System.in);
    private final BufferedReader br = new BufferedReader(is);

    public KeyboardReader() {                
    }
    /**
     * Liest einen Int von der Tastatur ein. 
     * @return Gibt einen Int zurück. 
     */
    public int readInt() {
        int line = -1;
        try {
            line = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Ungültige Eingabe! \nGeben Sie eine Ganzzahl ein.");
        } catch (NumberFormatException ex) {
            System.out.println("Ungültige Eingabe! \nGeben Sie eine Zahl ein.");
        }
        return line;
    }
    /**
     * Liest einen String von der Tastatur ein. 
     * @return Gibt einen String zurück. 
     */
    public String readString() {
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Ungültige Eingabe! \nGeben Sie eine Ganzzahl ein.");
        }
        return line;
    }

    double readDouble() {
        double line = -1;
        try {
            line = Double.parseDouble(br.readLine());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Ungültige Eingabe! \nGeben Sie eine Fliesskommazahl ein.");
        } catch (NumberFormatException ex) {
            System.out.println("Ungültige Eingabe! \nGeben Sie eine Zahl ein.");
        }
        return line;
    }
}
