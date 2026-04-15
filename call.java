import client.java;
import call.java;
import java.time;

public abstract class Call {
    private Tuple<String, String> place_of_caller; // first element city, second element country
    private Tuple<String, String> place_of_receiver;
    private String day_of_week;
    private int duration;
    private int startTime;
    private int endTime;
    public Call(Tuple<String, String> place_of_caller, Tuple<String, String> place_of_receiver, String day_of_week, int duration, int startTime) {
        this.place_of_caller = place_of_caller;
        this.place_of_receiver = place_of_receiver;
        this.day_of_week = day_of_week;
        this.duration = duration;
        this.startTime = startTime * 60; // conversion to minutes
        this.endTime = startTime*60 + duration * 60; // conversion to minutes
    }
    public Tuple<String, String> getCaller() {
        return place_of_caller;
    }
    public Tuple<String, String> getReceiver() {
        return place_of_receiver;
    }
    public String getTypeOfCall() {
        if (place_of_caller[0].equals(place_of_receiver[0])) {
            return "local";
        } else if (place_of_caller[1].equals(place_of_receiver[1]) && !place_of_caller[0].equals(place_of_receiver[0])) {
            return "national";
        } else {
            return "international";
        }
    }
    public String getDayOfWeek() {
        return day_of_week;
    }
    public int getDuration() {
        return duration;
    }
    public int getStartTime() {
        return startTime;
    }
    public int getEndTime() {
        return endTime;
    }
}