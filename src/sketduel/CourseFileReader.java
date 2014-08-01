package sketduel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CourseFileReader {

    ArrayList<Course> courseList;
    BufferedReader reader;

    public CourseFileReader(File file) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(file));
    }

    public ArrayList<Course> readCourses() throws IOException {
        courseList = new ArrayList<>();
        while (reader.ready()) {
            String courseCode = reader.readLine();
            Course course = new Course(courseCode);
            courseList.add(course);
            boolean end = false;
            while (!end) {
                String in = reader.readLine();
                if ("</course>".equals(in)) {
                    end = true;
                    continue;
                }
                String[] info = in.split(" ");
                int secCode = Integer.parseInt(info[0]);
                Period period = new Period(info[1], info[2] + ":" + info[3]);
                String room = info[4];
                Section section = new Section(course, secCode, period, room);
                course.sectionList.add(section);
            }
        }
        return courseList;
    }

}
