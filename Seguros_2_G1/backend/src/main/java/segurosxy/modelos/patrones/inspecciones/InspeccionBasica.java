package segurosxy.modelos.patrones.inspecciones;

import segurosxy.cliente.model.Cliente;
import segurosxy.modelos.interfaces.IInspeccion;

public class InspeccionBasica implements IInspeccion {

    @Override
    public void hacerInspeccion(Cliente cliente) {
        System.out.println("-----------------------------");
        //Se inicializa la inspeccion
        //Se interpreta el resultado
        System.out.println("Inspeccion al cliente: " + cliente.getNombre());
    }

}
