/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sketduel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mac
 */
public class Sketduel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CourseFileReader reader = new CourseFileReader(new File("testcourse.txt"));
            ArrayList<Course> courseList = reader.readCourses();
            for(Course x : courseList) {
                System.out.println(x);
                for(Section y : x.sectionList) {
                    System.out.println(y);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
