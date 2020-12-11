package segurosxy.modelos.patrones.inspecciones.Decorator;

import segurosxy.cliente.model.Cliente;
import segurosxy.modelos.interfaces.IInspeccion;

public abstract class InspeccionDecorator implements IInspeccion {

    protected IInspeccion inspeccionDecorada;

    public InspeccionDecorator(IInspeccion inspeccionDecorada){
        this.inspeccionDecorada=inspeccionDecorada;
    }

    @Override
    public void hacerInspeccion(Cliente cliente) {
        this.inspeccionDecorada.hacerInspeccion(cliente);
    }

    //interpretador del resultado de la inspeccion
    protected String interpretarResultado(boolean resultado){
        if (resultado){
            return "Aprobada";
        }else
            return "Desaprobada";
    }

}
