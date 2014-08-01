package sketduel;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {

    ArrayList<Section> sectionList = new ArrayList<>();
    String code;

    public Course(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

}
