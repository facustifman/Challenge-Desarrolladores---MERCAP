import java.util.ArrayList;
import java.util.List;

public class client {
    private String name;
    private Location residence;
    private List<Call> callHistory;
    public client(String name, Location residence) {
        this.name = name;
        this.residence = residence;
        this.callHistory = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public Location getResidence() {
        return residence;
    }
    public List<Call> getCallHistory() {
        return callHistory;
    }
    public void addCall(Call call) {
        callHistory.add(call);
    }
}