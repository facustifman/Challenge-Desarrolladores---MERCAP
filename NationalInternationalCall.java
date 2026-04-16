import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NationalInternationalCall extends Call {
    private static final Map<String, Double> nationalCosts = new HashMap<>();
    private static final Map<String, Double> internationalCosts = new HashMap<>();

    static {
        nationalCosts.putAll(loadCSV("national_costs.csv"));
        internationalCosts.putAll(loadCSV("international_costs.csv"));
    }

    public NationalInternationalCall(Location place_of_caller, Location place_of_receiver, String day_of_week, int duration, int startTime) {
        super(place_of_caller, place_of_receiver, day_of_week, duration, startTime);
    }
    @Override
    public double calculateCost() {
        double cost = 0.0;
        String type = getTypeOfCall();
        if (type.equals("national")) {
            double cost_per_minute = search_cost(getReceiver().getCity(), "national");
            cost = getDuration() * cost_per_minute;
        } else if (type.equals("international")) {
            double cost_per_minute = search_cost(getReceiver().getCountry(), "international");
            cost = getDuration() * cost_per_minute;
        }
        return cost;
    }

    private static Map<String, Double> loadCSV(String filename) {
        Map<String, Double> data = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    data.put(parts[0].trim(), Double.valueOf(parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading CSV: " + filename);
        }
        return data;
    }

    private double search_cost(String key, String type_of_call) {
        if (type_of_call.equals("national")) {
            return nationalCosts.getOrDefault(key, 0.50);
        } else {
            return internationalCosts.getOrDefault(key, 1.00);
        }
    }
    
}