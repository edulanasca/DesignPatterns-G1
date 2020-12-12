package segurosxy.modelos.patrones;

import segurosxy.cliente.model.Cliente;
import segurosxy.modelos.interfaces.IInspeccion;
import segurosxy.modelos.patrones.inspecciones.Decorator.InspeccionJudicialDecorator;
import segurosxy.modelos.patrones.inspecciones.Decorator.InspeccionSaludDecorator;
import segurosxy.modelos.patrones.inspecciones.InspeccionFinanciera;
import segurosxy.modelos.patrones.inspecciones.InspeccionJudicial;

public class VentaSeguro {



    public void inspeccionar(Cliente cliente){
        IInspeccion inspeccionFinancieraMasOtrosDos = new InspeccionJudicialDecorator(
                    new InspeccionSaludDecorator(new InspeccionFinanciera()));

        inspeccionFinancieraMasOtrosDos.hacerInspeccion(cliente);
    }


    public static void main(String[] args) {
        Cliente cliente = new Cliente("Giusepe");

        VentaSeguro venta = new VentaSeguro();

        venta.inspeccionar(cliente);


    }


}
