package segurosxy;

import segurosxy.modelos.Cliente;
import segurosxy.modelos.SeguroTarjeta;
import segurosxy.modelos.SeguroVehicular;

public class App {

    public static void main( String[] args )
    {

        Cliente cliente = new Cliente("Juan Perez");

        SeguroVehicular seguro = new SeguroVehicular("Toyota","Yaris"); // Se va a romper
        seguro.cacularRiesgo();
        cliente.setCompraSeguro(seguro);

        SeguroTarjeta seguro2 = new SeguroTarjeta("BCP");
        seguro2.cacularRiesgo();
        cliente.setCompraSeguro(seguro2);

        cliente.getListaSeguroCliente();

    }

}
