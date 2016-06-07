/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator.gui;

import ch.abbts.szmg.scorecalculator.*;
import javax.swing.JOptionPane;

/**
 *
 * @author szobrist
 */
public class ScoreList {
    
    private Student student;
    private Semester semester;
    private Module module;
    
    public ScoreList(Student student) {
        this.student = student;
        initStudentDialog();
    }
    private void initStudentDialog() {
        String text = new String();
        text = "<html><b>Notenschnitt pro Semester: </b>";
        if (student.getSemesters() != null) {
            for (Semester semester : student.getSemesters()) {
                text += "<tr> <td>" + semester.getName() + "</td> <td> " + semester.getAverage() + "</td> </tr>" ;
            }
            text += "<tr><td><b>Gesamtnotenschnitt: <b></td>" + student.getAverage() + "</tr></html>";
            JOptionPane.showMessageDialog(Gui.getMainFrame(), text, "Notenliste von " + student.getFullName(), JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(Gui.getMainFrame(), "Keine Daten vorhanden!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }

    }
    public ScoreList(Semester semester) {
        this.semester = semester;
        initSemesterDialog();
    }
    private void initSemesterDialog() {
        String text = new String();
        text = "<html><h2>Semester: " + semester.getName() + "</h2><br><b>Notenschnitt pro Fach:</b>";
        if (semester.getModules() != null) {
            for (Module module : semester.getModules()) {
                text += "<html><tr><td>" + module.getName() + "</td><td> " + module.getAverage() + "</td></tr></html>" ;
            }
            text += "<tr><td><b>Gesamtnotenschnitt: <b></td>" + student.getAverage() + "</tr></html>";
            JOptionPane.showMessageDialog(Gui.getMainFrame(), text, "Notenliste von " + student.getFullName(), JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(Gui.getMainFrame(), "Keine Daten vorhanden!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }
}
