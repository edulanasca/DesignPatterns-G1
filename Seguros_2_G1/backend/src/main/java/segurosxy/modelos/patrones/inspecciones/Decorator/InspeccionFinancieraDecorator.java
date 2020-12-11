package segurosxy.modelos.patrones.inspecciones.Decorator;

import segurosxy.cliente.model.Cliente;
import segurosxy.modelos.interfaces.IInspeccion;
import segurosxy.modelos.patrones.inspecciones.InspeccionFinanciera;

public class InspeccionFinancieraDecorator extends InspeccionDecorator{

    public InspeccionFinancieraDecorator(IInspeccion InspeccionDecortada){
        super(InspeccionDecortada);
    }

    @Override
    public void hacerInspeccion(Cliente cliente) {
        //se hace la inspeccion de la inspeccion decorador
        inspeccionDecorada.hacerInspeccion(cliente);

        //despues se hace la inspeccion financiera
        hacerInspeccionFinanciera(cliente);
    }

    public void hacerInspeccionFinanciera(Cliente cliente){
        System.out.println("-----------------------------");
        //Se hace la logica de negocio de la Inspeccion Financiera
        //Se interpreta el resultado
        System.out.println("Inspeccion Financiera: "+interpretarResultado(true));
    }


}
