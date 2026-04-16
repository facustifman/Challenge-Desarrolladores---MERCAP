public class Main {
    public static void main(String[] args) {
        // Create client and residence location
        Location residenceLocation = new Location("Buenos Aires", "Argentina");
        Client cliente = new Client("Juan Pérez", residenceLocation);

        // Create calls and add to client's history
        
        Location bsas = new Location("Buenos Aires", "Argentina");
        LocalCall llamada1 = new LocalCall(bsas, bsas, "Monday", 90, 10);
        cliente.addCall(llamada1);
        
        LocalCall llamada2 = new LocalCall(bsas, bsas, "Saturday", 60, 15);
        cliente.addCall(llamada2);
        
        Location cordoba = new Location("Córdoba", "Argentina");
        NationalInternationalCall llamada3 = new NationalInternationalCall(bsas, cordoba, "Tuesday", 120, 14);
        cliente.addCall(llamada3);
        
        Location brasil = new Location("Sao Paulo", "Brasil");
        NationalInternationalCall llamada4 = new NationalInternationalCall(bsas, brasil, "Wednesday", 45, 18);
        cliente.addCall(llamada4);
        
        NationalInternationalCall llamada5 = new NationalInternationalCall(bsas, bsas, "Friday", 730, 7);
        cliente.addCall(llamada5);

        Bill factura = new Bill(cliente, 4, 2026);
        factura.printBill();
    }
}