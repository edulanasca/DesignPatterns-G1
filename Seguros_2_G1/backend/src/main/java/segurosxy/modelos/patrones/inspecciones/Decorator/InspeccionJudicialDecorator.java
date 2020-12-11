package segurosxy.modelos.patrones.inspecciones.Decorator;

import segurosxy.cliente.model.Cliente;
import segurosxy.modelos.interfaces.IInspeccion;

public class InspeccionJudicialDecorator extends InspeccionDecorator{

    public InspeccionJudicialDecorator(IInspeccion inspeccionDecorada) {
        super(inspeccionDecorada);
    }

    @Override
    public void hacerInspeccion(Cliente cliente) {
        //se hace la inspeccion de la inspeccion decorador
        inspeccionDecorada.hacerInspeccion(cliente);

        //despues se hace la inspeccion Judicial
        hacerInspeccionJudicial(cliente);
    }

    public void hacerInspeccionJudicial(Cliente cliente) {
        System.out.println("-----------------------------");
        //Se hace la logica de negocio de la Inspeccion Judicial
        //Se interpreta el resultado
        System.out.println("Inspeccion Judicial: "+interpretarResultado(true));
    }


}
