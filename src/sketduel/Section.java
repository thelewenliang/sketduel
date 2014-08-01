package sketduel;

import java.io.Serializable;
import java.util.ArrayList;

public class Section implements Serializable {

    Course course;
    int code;
    Period period;
    String room;

    public Section(Course course, int code, Period period, String room) {
        this.course = course;
        this.code = code;
        this.period = period;
        this.room = room;
    }

    @Override
    public String toString() {
        return course + " " + code + " " + period.toString() + " " + room;
    }

}
