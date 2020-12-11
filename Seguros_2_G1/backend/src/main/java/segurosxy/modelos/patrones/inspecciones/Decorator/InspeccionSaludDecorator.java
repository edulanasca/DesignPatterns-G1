package segurosxy.modelos.patrones.inspecciones.Decorator;

import segurosxy.cliente.model.Cliente;
import segurosxy.modelos.interfaces.IInspeccion;

public class InspeccionSaludDecorator extends InspeccionDecorator{

    public InspeccionSaludDecorator(IInspeccion inspeccionDecorada) {
        super(inspeccionDecorada);
    }

    @Override
    public void hacerInspeccion(Cliente cliente) {
        //se hace la inspeccion de la inspeccion decorada
        inspeccionDecorada.hacerInspeccion(cliente);

        //despues se hace la inspeccion de Salud
        hacerInspeccionSalud(cliente);
    }

    public void hacerInspeccionSalud(Cliente cliente) {
        System.out.println("-----------------------------");
        //Se hace la logica de negocio de la Inspeccion de Salud
        //Se interpreta el resultado
        System.out.println("Inspeccion de Salud: "+interpretarResultado(true));
    }


}
