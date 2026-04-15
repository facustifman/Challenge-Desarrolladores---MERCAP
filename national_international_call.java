import national_costs.csv;
import international_costs.csv;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class national_international_call extends Call {
    public national_international_call(String place_of_caller, String place_of_receiver, String day_of_week, int duration, int startTime) {
        super(place_of_caller, place_of_receiver, day_of_week, duration, startTime);
    }
    double calculateCost() {
        double cost = 0.0;
        if (getTypeOfCall() == "national") {
            cost_per_minute = search_cost(place_of_receiver[0], type_of_call);
            cost = getDuration() * cost_per_minute;
        } else {
            cost_per_minute = search_cost(place_of_receiver[1], type_of_call);
            cost = getDuration() * cost_per_minute;
        }
        return cost;
    }

    private Map<String, Double> loadCSV(String filename) {
        Map<String, Double> data = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                data.put(parts[0].trim(), Double.parseDouble(parts[1].trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private double search_cost(String key, String type_of_call) {
        Map<String, Double> costs;
        if (type_of_call == "national") {
            costs = loadCSV("national_costs.csv");
        } else {
            costs = loadCSV("international_costs.csv");
        }
        return costs.getOrDefault(key, 0.0);
    }
    
}