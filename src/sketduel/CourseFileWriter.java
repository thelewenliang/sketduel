package sketduel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Writes <b>Course</b> or <b>ArrayList&lt;Course&gt;</b> into a file. The files written by this
 * class can be read by CourseFileReader.
 *
 * @author thelewenliang
 */
public class CourseFileWriter {

    PrintWriter writer;

    public CourseFileWriter(File file) throws FileNotFoundException {
        writer = new PrintWriter(file);
    }
    

    public void writeCoursesList(ArrayList<Course> courseList) {
        for (Course course : courseList) {
            writeCourse(course);
        }
    }

    public void writeCourse(Course course) {
        writer.println(course.code);
        for (Section sec : course.sectionList) {
            String sectionString = sec.code + " " + sec.room + " " + sec.period.day + " " + sec.period.start + " " + sec.period.end;
            writer.println(sectionString);
        }
        writer.println("</course>");
    }
}
