package segurosxy.modelos.patrones.inspecciones.Decorator;

import segurosxy.cliente.model.Cliente;
import segurosxy.modelos.interfaces.IInspeccion;

public class InspeccionViviendaDecorator extends InspeccionDecorator {

    public InspeccionViviendaDecorator(IInspeccion inspeccionDecorada) {
        super(inspeccionDecorada);
    }

    @Override
    public void hacerInspeccion(Cliente cliente) {
        //se hace la inspeccion de la inspeccion decorada
        inspeccionDecorada.hacerInspeccion(cliente);

        //despues se hace la inspeccion de Vivienda
        hacerInspeccionVivienda(cliente);
    }

    public void hacerInspeccionVivienda(Cliente cliente) {
        System.out.println("-----------------------------");
        //Se hace la logica de negocio de la Inspeccion de Vivienda
        //Se interpreta el resultado
        System.out.println("Inspeccion de Vivienda: "+interpretarResultado(true));
    }


}
