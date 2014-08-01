package sketduel;

import java.io.Serializable;
import java.security.InvalidParameterException;

public class Period implements Serializable {

    Time start;
    Time end;

    public enum Day {

        m("Monday"), t("Tuesday"), w("Wednesday"), h("Thursday"), f("Friday"), s("Saturday"), u("Sunday");
        String text;
        Day(String text) {
            this.text = text;
        }
        
        @Override
        public String toString() {
            return text;
        }
    };
    Day day;

    public Period(Day day, String time) {
        this.day = day;
        String[] temp = time.split("-");
        start = new Time(temp[0].trim());
        end = new Time(temp[1].trim());
    }

    public Period(String day, String time) {
        Day theDay;
        switch (day.toUpperCase()) {
            case "M":
                theDay = Day.m;
                break;
            case "T":
                theDay = Day.t;
                break;
            case "W":
                theDay = Day.w;
                break;
            case "H":
                theDay = Day.h;
                break;
            case "F":
                theDay = Day.f;
                break;
            case "S":
                theDay = Day.s;
                break;
            case "U":
                theDay = Day.u;
                break;
            default:
                throw new InvalidParameterException();
        }
        this.day = theDay;
        String[] temp = time.split("-");
        start = new Time(temp[0].trim());
        end = new Time(temp[1].trim());
    }

    public boolean isCrash(Period comp) {
        if (day == comp.day) {
            return true;
        } else {
            return start.compareTo(comp.start) != end.compareTo(comp.end); //if before or after then true
        }
    }

    @Override
    public String toString() {
        return day + " " + start + " - " + end;
    }

    public class Time {

        int hour;
        int minute;

        public Time(String time) {
            String[] temp = time.split(":");
            hour = Integer.parseInt(temp[0].trim());
            minute = Integer.parseInt(temp[1].trim());
        }

        public int compareTo(Time time) {
            if (this.hour > time.hour) {
                return 1; //later
            } else if (this.hour < time.hour) {
                return 2; //earlier
            } else {
                if (this.minute > time.minute) {
                    return 1;
                } else if (this.minute < time.minute) {
                    return 2;
                } else {
                    return 0; //same
                }
            }
        }
        @Override
        public String toString() {
            String hourString = Integer.toString(hour);
            String minuteString = Integer.toString(minute);
            if(hour < 10) {
                hourString = "0" + hour;
            }
            if(minute < 10) {
                minuteString = "0" + minute;
            }
            return hourString + ":" + minuteString;
        }
    }
}
