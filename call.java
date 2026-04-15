import client.java;
import call.java;
import java.time;

public abstract class Call {
    private String place_of_caller;
    private String place_of_receiver;
    private String day_of_week;
    private int duration;
    private int startTime;
    private int endTime;
    public Call(String place_of_caller, String place_of_receiver, String day_of_week, int duration, int startTime) {
        this.place_of_caller = place_of_caller;
        this.place_of_receiver = place_of_receiver;
        this.day_of_week = day_of_week;
        this.duration = duration;
        this.startTime = startTime * 60; // Conversion to minutes
        this.endTime = startTime + duration;
    }
    public String getCaller() {
        return place_of_caller;
    }
    public String getReceiver() {
        return place_of_receiver;
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