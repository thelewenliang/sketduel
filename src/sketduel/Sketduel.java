/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sketduel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author mac
 */
public class Sketduel {

    ArrayList<Course> courseList;
    
    public static void main(String[] args) {
        new Sketduel().go();
    }
    
    public void go() {
        setupWindow();
    }
    
    public void setupWindow() {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        JFrame frame = new JFrame("Sketduel");
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadCoursesItem = new JMenuItem("Load Courses");
        fileMenu.add(loadCoursesItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.setSize(new Dimension(500,300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.requestFocus();
    }
    
    public void showLoadCourses() {
        new CourseFileWriter()
    }
    
    public class LoadCoursesItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            showLoadCourses();
        }
        
    }
}
