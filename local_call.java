public class local_call extends Call {
    public local_call(Location place_of_caller, Location place_of_receiver, String day_of_week, int duration, int startTime) {
        super(place_of_caller, place_of_receiver, day_of_week, duration, startTime);
    }
    @Override
    public double calculateCost() {
        String day_of_Week = getDayOfWeek();
        double cost;
        if (day_of_Week.equals("Saturdays") || day_of_Week.equals("Sunday")) {
            cost = getDuration() * 0.10;
        } else {
            int time_in_double = Math.max(0, Math.min(getEndTime(), 20*60) - Math.max(getStartTime(), 8*60)); // time in double is the time of the call that is between 8:00 and 20:00, if the call starts before 8:00, we consider it starts at 8:00, if it ends after 20:00, we consider it ends at 20:00 to calculate the time of the call that is in double cost.
            cost = time_in_double * 0.20 + (getDuration() - time_in_double) * 0.10;
        }
        return cost;
    }
}