package segurosxy.modelos.patrones;

import segurosxy.modelos.interfaces.ICobertura;

public class CoberturaDecorator implements ICobertura {

    public final ICobertura cobertura;

    public CoberturaDecorator(ICobertura cobertura)    {

        this.cobertura = cobertura;
    }

    public void calculaCobertura() {

        this.cobertura.calculaCobertura();
    }

}
