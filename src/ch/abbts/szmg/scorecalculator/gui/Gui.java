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
    private static Gui mainFrame;

    private Student student;
    private Semester semester;
    private Module module;

    
    // Konstruktor für Gui    
    public Gui() { 
        initGui();
    }
    
    private void initGui() {
        //Objekt apeichern für statischen Aufruf
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
        
        //Menübar und ContentPane erzeugen und einhängen
        topMenuBar = new TopMenuBar();
        mainPanel = new MainPanel();
        
        add(topMenuBar);
        setJMenuBar(topMenuBar);
        
        setContentPane(mainPanel);
        
        setVisible(true);
    }
    
    //Getter & Setter
    public static Gui getMainFrame(){
        return mainFrame;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Semester getSemester() {
        return semester;
    }
    public void setSemester(Semester semester) {
        this.semester = semester;
    }
    public Module getModule() {
        return module;
    }
    public void setModule(Module module) {
        this.module = module;
    }
}
