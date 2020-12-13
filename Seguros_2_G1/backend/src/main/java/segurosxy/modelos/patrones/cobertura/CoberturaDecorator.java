package segurosxy.modelos.patrones.cobertura;

import segurosxy.modelos.interfaces.ICobertura;

public class CoberturaDecorator implements ICobertura {

    public ICobertura cobertura;

    public CoberturaDecorator(ICobertura cobertura)    {

        this.cobertura = cobertura;
    }

    public ICobertura getCobertura() {
        return cobertura;
    }

    public String calculaCobertura() {
        return this.cobertura.calculaCobertura();
    }

    public void removeDecorator(ICobertura remover) {

        if (cobertura.equals(remover)) {
            this.cobertura = ((CoberturaDecorator) cobertura).getCobertura();
        } else {
            ((CoberturaDecorator) cobertura).removeDecorator(remover);
        }
    }

    @Override
    public String toString() {
        return "CoberturaDecorator{" +
            "cobertura=" + cobertura +
            '}';
    }
}
