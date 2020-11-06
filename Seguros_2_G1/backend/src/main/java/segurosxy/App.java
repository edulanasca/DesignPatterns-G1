package segurosxy;

import segurosxy.modelos.Cliente;
import segurosxy.modelos.seguro.tarjeta.SeguroTarjeta;
import segurosxy.modelos.seguro.vehiculo.SeguroTodoRiesgo;
import segurosxy.modelos.seguro.vehiculo.SeguroVehicular;

public class App {

    public static void main( String[] args )
    {

        Cliente cliente = new Cliente("Juan Perez");

        SeguroVehicular seguro = new SeguroTodoRiesgo("Toyota","Yaris"); // Se va a romper
        seguro.calcularRiesgo();
        cliente.setCompraSeguro(seguro);

        SeguroTarjeta seguro2 = new SeguroTarjeta("BCP");
        seguro2.calcularRiesgo();
        cliente.setCompraSeguro(seguro2);

        cliente.getListaSeguroCliente();

    }

}
