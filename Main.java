public class Main {
    public static void main(String[] args) {
        // Create client and residence location
        Location residenceLocation = new Location("Buenos Aires", "Argentina");
        client cliente = new client("Juan Pérez", residenceLocation);

        // Create calls and add to client's history
        
        Location bsas = new Location("Buenos Aires", "Argentina");
        local_call llamada1 = new local_call(bsas, bsas, "Monday", 90, 10);
        cliente.addCall(llamada1);
        
        local_call llamada2 = new local_call(bsas, bsas, "Saturday", 60, 15);
        cliente.addCall(llamada2);
        
        Location cordoba = new Location("Córdoba", "Argentina");
        national_international_call llamada3 = new national_international_call(bsas, cordoba, "Tuesday", 120, 14);
        cliente.addCall(llamada3);
        
        Location brasil = new Location("Sao Paulo", "Brasil");
        national_international_call llamada4 = new national_international_call(bsas, brasil, "Wednesday", 45, 18);
        cliente.addCall(llamada4);
        
        local_call llamada5 = new local_call(bsas, bsas, "Friday", 730, 7);
        cliente.addCall(llamada5);

        Bill factura = new Bill(cliente, 4, 2026);
        factura.printBill();
    }
}