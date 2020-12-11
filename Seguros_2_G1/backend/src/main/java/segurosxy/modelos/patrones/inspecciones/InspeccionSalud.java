package segurosxy.modelos.patrones.inspecciones;

import segurosxy.cliente.model.Cliente;
import segurosxy.modelos.interfaces.IInspeccion;

public class InspeccionSalud implements IInspeccion {

    @Override
    public void hacerInspeccion(Cliente cliente) {
        System.out.println("-----------------------------");
        //Se hace la logica de negocio de la Inspeccion de Salud
        //Se interpreta el resultado
        System.out.println("Inspeccion de Salud: "+interpretarResultado(true));
    }

    //interpretador del resultado de la inspeccion
    private String interpretarResultado(boolean resultado){
        if (resultado){
            return "Aprobada";
        }else
            return "Desaprobada";
    }
}
