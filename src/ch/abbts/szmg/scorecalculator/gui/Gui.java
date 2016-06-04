/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.abbts.szmg.scorecalculator.gui;
import ch.abbts.szmg.scorecalculator.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author mg
 */
public class Gui extends JFrame {

    private MainPanel mainPanel;
    private TopMenuBar topMenuBar;
    private int frameWidth = 800;
    private int frameHeight = 400;
    private static JFrame mainFrame;
    
    private static Student student;
    private static Semester semester;
    private static Module module;
    
    // Konstruktor für Gui    
    public Gui() { 
        initGui();
    }
    
    private void initGui() {
        mainFrame = this;
        // MainFrame generieren: Titel, Position und gösse setzen
        setTitle("Score calculator");
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();
        setLocation((screenWidth-frameWidth)/2, (screenHeight-frameHeight)/2);
        setSize(frameWidth,frameHeight);
        setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Stellt sicher, dass sauber beendet wird.
        
        topMenuBar = new TopMenuBar();
        mainPanel = new MainPanel();
        
        add(topMenuBar);
        setJMenuBar(topMenuBar);
        
        setContentPane(mainPanel);
        
        setVisible(true);
    }
    
    public static JFrame getMainFrame(){
        return mainFrame;
    }
    public static Student getStudent() {
        return student;
    }
    public static void setStudent(Student student) {
        Gui.student = student;
    }
    public static Semester getSemester(String nameOfStudent) {
        return semester;
    }
    public static void setSemester(Semester semester) {
        Gui.semester = semester;
    }
    public static Module getModule() {
        return module;
    }
    public static void setModule(Module module) {
        Gui.module = module;
    }
}
