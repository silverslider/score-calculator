/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator.gui;

import ch.abbts.szmg.scorecalculator.*;
import javax.swing.JOptionPane;

/**
 * Mit dieser Klasse kann der Notendurchscnitt pro Student, Semester oder Fach
 * mit Hilfe von Dialogboxen ausgegeben werden.
 * @author Simon Zobrist
 */
public class ScoreList {
    
    private Student student;
    private Semester semester;
    private Module module;
    
    /**
     * 
     * @param student Student Studentenobjekt von welchem der Durchscnitt
     * angezeigt werden soll.
     */
    public ScoreList(Student student) {
        this.student = student;
        initStudentDialog();
    }
    // Studentendialog
    private void initStudentDialog() {
        String text = new String();
        text = "<html><b>Notenschnitt pro Semester: </b>";
        if (student.getSemesters() != null && student.getSemesters().size() > 0) {
            for (Semester semester : student.getSemesters()) {
                text += "<tr><td>" + semester.getName() + "</td><td>" + semester.getdescription() + "</td><td> " + semester.getAverage() + "</td></tr>" ;
            }
            text += "<tr><td><b>Gesamtnotenschnitt: <b></td><td></td><td>" + student.getAverage() + "</td></tr></html>";
            JOptionPane.showMessageDialog(Gui.getMainFrame(), text, "Notenliste von " + student.getFullName(), JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(Gui.getMainFrame(), "Keine Daten vorhanden!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }

    }
    /**
     * 
     * @param semester Semester Semesterobjekt von welchem der Durschnitt
     * angezeigt werden soll.
     */
    public ScoreList(Semester semester) {
        this.semester = semester;
        initSemesterDialog();
    }
    // Semester Dialog
    private void initSemesterDialog() {
        String text = new String();
        text = "<html><h2>Semester: " + semester.getName() + "</h2><br><b>Notenschnitt pro Fach:</b>";
        if (semester.getModules() != null && semester.getModules().size() > 0) {
            for (Module module : semester.getModules()) {
                text += "<html><tr><td>" + module.getName() + "</td><td> " + module.getAverage() + "</td></tr></html>" ;
            }
            text += "<tr><td><b>Gesamtnotenschnitt: <b></td>" + semester.getAverage() + "</tr></html>";
            JOptionPane.showMessageDialog(Gui.getMainFrame(), text, "Notenliste von " + semester.getName(), JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(Gui.getMainFrame(), "Keine Daten vorhanden!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * 
     * @param module Modul Modulobjekt von welchem der Durschnitt angezeigt 
     * werden soll
     */
    public ScoreList(Module module) {
        this.module = module;
        initModuleDialog();
    }
    // Modul Dialog
    private void initModuleDialog(){
        String text = new String();
        if(module.getScores() != null && module.getScores().size() > 0){
            text = "<html><h2>Fach: " + module.getName() + "</h2><br><tr><td><b>Dozent: </b><td>" + module.getInstructor() + "</td></tr><tr><td>Notenschnitt : </td><td>" + module.getAverage() + "</td></html>";
            JOptionPane.showMessageDialog(Gui.getMainFrame(), text, "Notenliste von " + module.getName(), JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(Gui.getMainFrame(), "Keine Daten vorhanden!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }
}
