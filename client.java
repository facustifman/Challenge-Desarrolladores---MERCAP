public class client {
    private String name;
    private String residence;
    private List<Call> callHistory;
    public client(String name, String residence) {
        this.name = name;
        this.residence = residence;
        this.callHistory = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getResidence() {
        return residence;
    }
    public List<Call> getCallHistory() {
        return callHistory;
    }
    public void addCall(Call call) {
        callHistory.add(call);
    }
}