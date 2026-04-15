public class local_call extends Call {
    public local_call(String place_of_caller, String place_of_receiver, String day_of_week, int duration, int startTime) {
        super(place_of_caller, place_of_receiver, day_of_week, duration, startTime);
    }
    double calculateCost() {
        double cost = 0.0;
        if (getDayOfWeek() == "Saturday" || getDayOfWeek() == "Sunday") {
            cost = getDuration() * 0.10;
        } else {
            int time_in_double = Math.max(0, Math.min(getEndTime(), 20*60) - Math.max(getStartTime(), 8*60));
            cost = time_in_double * 0.20 + (getDuration() - time_in_double) * 0.10;
        }
        return cost;
    }
}