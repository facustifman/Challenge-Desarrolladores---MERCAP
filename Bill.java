import java.util.List;

public class Bill {
    private static final double FIXED_MONTHLY_COST = 15.0; // Fixed monthly fee for the client
    private final Client client;
    private final int month;

    public Bill(Client client, int month, int year) {
        this.client = client;
        this.month = month;
    }

    public double calculateTotalCost() {
        double totalCost = FIXED_MONTHLY_COST; // Base cost is the fixed monthly fee
        List<Call> callHistory = client.getCallHistory();
        
        for (Call call : callHistory) {
            totalCost += call.calculateCost();
        }
        return totalCost;
    }

    public void printBill() {
        System.out.println("================== BILL ====================");
        System.out.println("Client: " + client.getName());
        System.out.println("Residence: " + client.getResidence());
        System.out.println("Month: " + month + "/2026");
        System.out.println("==============================================");
        System.out.println("Monthly Basic Fee: $" + FIXED_MONTHLY_COST);
        System.out.println("----------------------------------------------");
        
        double callsCost = 0.0;
        List<Call> callHistory = client.getCallHistory();
        
        System.out.println("Call Details:");
        for (Call call : callHistory) {
            double cost = call.calculateCost();
            callsCost += cost;
            System.out.println("  From: " + call.getCaller() + " to: " + call.getReceiver() + 
                             " (" + call.getTypeOfCall() + ") - Duration: " + call.getDuration() + " min - Cost: $" + cost);
        }
        
        System.out.println("----------------------------------------------");
        System.out.println("Total Call Cost: $" + callsCost);
        System.out.println("==============================================");
        System.out.println("TOTAL TO PAY: $" + calculateTotalCost());
        System.out.println("==============================================\n");
    }
}