public class client {
    private String name;
    private Tuple<String, String> residence; // first element city, second element country
    private List<Call> callHistory;
    public client(String name, Tuple<String, String> residence) {
        this.name = name;
        this.residence = residence;
        this.callHistory = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public Tuple<String, String> getResidence() {
        return residence;
    }
    public List<Call> getCallHistory() {
        return callHistory;
    }
    public void addCall(Call call) {
        callHistory.add(call);
    }
}