public abstract class Call {
    private final Location place_of_caller;
    private final Location place_of_receiver;
    private final String day_of_week;
    private final int duration;
    private final int startTime;
    private final int endTime;
    public Call(Location place_of_caller, Location place_of_receiver, String day_of_week, int duration, int startTime) {
        this.place_of_caller = place_of_caller;
        this.place_of_receiver = place_of_receiver;
        this.day_of_week = day_of_week;
        this.duration = duration;
        this.startTime = startTime * 60; // conversion to minutes
        this.endTime = startTime*60 + duration * 60; // conversion to minutes
    }
    public Location getCaller() {
        return place_of_caller;
    }
    public Location getReceiver() {
        return place_of_receiver;
    }
    public String getTypeOfCall() {
        if (place_of_caller.getCity().equals(place_of_receiver.getCity())) {
            return "local";
        } else if (place_of_caller.getCountry().equals(place_of_receiver.getCountry()) && !place_of_caller.getCity().equals(place_of_receiver.getCity())) {
            return "national";
        } else {
            return "international";
        }
    }

    public abstract double calculateCost();
    
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