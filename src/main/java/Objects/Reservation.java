package Objects;

public class Reservation implements Comparable<Reservation>{
    private String equipment;
    private Date date;
    private Time time;
    private int id;

    public Reservation(String e, int mon, int d, int h, int min, int id){
        equipment = e;
        date = new Date(mon, d);
        time = new Time(h, min);
        this.id = id;
    }

    public Reservation(String e, String date, String time, int id){
        equipment = e;
        this.date = new Date(date);
        this.time = new Time(time);
        this.id = id;
    }

    public String getEquipment() {
        return equipment;
    }
    public String getDate() {
        return date.toString();
    }
    public String getTime() {
        return time.toString();
    }
    public int getId() {
        return id;
    }
    public String toString(){
        return equipment + " " + date.toString() + " " + time.toString() + " " + id;
    }

    @Override
    public int compareTo(Reservation o) {
        if (date.compareTo(o.date) > 0) return 1;
        else if (date.compareTo(o.date) < 0) return -1;
        else{
            if (time.compareTo(o.time) > 0) return 1;
            else if(time.compareTo(o.time) < 0) return 1;
            else return 0;
        }
    }
}

class Date implements Comparable<Date>{
    int month;
    int day;
    public Date(int mon, int d){
        month = mon;
        day = d;
    }

    public Date(String date){
        int i = date.indexOf('/');
        month = Integer.parseInt(date.substring(0, i));
        day = Integer.parseInt(date.substring(i + 1));
    }

    public String toString(){
        return Integer.toString(month) + "/" + Integer.toString(day);
    }

    @Override
    public int compareTo(Date o) {
        if (month > o.month) return 1;
        else if (month < o.month) return -1;
        else{
            return Integer.compare(day, o.day);
        }
    }
}
class Time implements Comparable<Time>{
    int hour;
    int minute;
    public Time(int h, int min){
        hour = h;
        minute = min;
    }

    public Time(String time){
        int i = time.indexOf(':');
        int j = time.indexOf(' ');

        int h = Integer.parseInt(time.substring(0, i));
        int m = Integer.parseInt(time.substring(i + 1, j));
        String s = time.substring(j+1);

        if (s.equals("am") && h == 12){
            hour = 0;
            minute = m;
        } else if (s.equals("am")){
            hour = h;
            minute = m;
        } else if(s.equals("pm") && h == 12){
            hour = 12;
            minute = m;
        } else{
            hour = h + 12;
            minute = m;
        }
    }

    public String toString(){
        if (minute >= 10) {
            if (hour == 0) return "12:" + Integer.toString(minute) + " am";
            else if (hour < 12) return Integer.toString(hour) + ":" + Integer.toString(minute) + " am";
            else if (hour == 12) return "12:" + Integer.toString(minute) + " pm";
            else return Integer.toString(hour - 12) + ":" + Integer.toString(minute) + " pm";

        } else if (minute > 0){
            if (hour == 0) return "12:0" + Integer.toString(minute) + " am";
            else if (hour < 12) return Integer.toString(hour) + ":0" + Integer.toString(minute) + " am";
            else if (hour == 12) return "12:0" + Integer.toString(minute) + " pm";
            else return Integer.toString(hour - 12) + ":0" + Integer.toString(minute) + " pm";

        } else {
            if (hour == 0) return "12:00 am";
            else if (hour < 12) return Integer.toString(hour) + ":00 am";
            else if (hour == 12) return "12:00 pm";
            else return Integer.toString(hour - 12) + ":00 pm";
        }
    }

    @Override
    public int compareTo(Time o) {
        if (hour > o.hour) return 1;
        else if (hour < o.hour) return -1;
        else{
            return Integer.compare(minute, o.minute);
        }
    }
}

