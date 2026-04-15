public class main {
    public static void main(String[] args) {
        // Crear cliente
        Location residenceLocation = new Location("Buenos Aires", "Argentina");
        client cliente = new client("Juan Pérez", residenceLocation);

        // Crear algunas llamadas de ejemplo
        
        // Llamada Local - lunes 10:00 a 11:30 (90 min en franja de 8-20)
        Location bsas = new Location("Buenos Aires", "Argentina");
        local_call llamada1 = new local_call(bsas, bsas, "Monday", 90, 10);
        cliente.addCall(llamada1);
        
        // Llamada Local - sábado 15:00 a 16:00 (no aplica franja, costo fijo 0.10)
        local_call llamada2 = new local_call(bsas, bsas, "Saturday", 60, 15);
        cliente.addCall(llamada2);
        
        // Llamada Nacional - a Córdoba
        Location cordoba = new Location("Córdoba", "Argentina");
        national_international_call llamada3 = new national_international_call(bsas, cordoba, "Tuesday", 120, 14);
        cliente.addCall(llamada3);
        
        // Llamada Internacional - a Brasil
        Location brasil = new Location("Sao Paulo", "Brasil");
        national_international_call llamada4 = new national_international_call(bsas, brasil, "Wednesday", 45, 18);
        cliente.addCall(llamada4);
        
        // Llamada Local que cruza franja horaria (7:50 a 22:00)
        local_call llamada5 = new local_call(bsas, bsas, "Friday", 730, 7);
        cliente.addCall(llamada5);

        // Crear factura y mostrar
        bill factura = new bill(cliente, 4, 2026);
        factura.printBill();
    }
}