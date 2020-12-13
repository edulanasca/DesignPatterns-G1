package segurosxy.modelos.patrones.cobertura;

import segurosxy.modelos.interfaces.ICobertura;

public class CoberturaPorChoqueDecorator extends CoberturaDecorator {

    public CoberturaPorChoqueDecorator(ICobertura cobertura) {
        super(cobertura);
    }

    @Override
    public String calculaCobertura() {
        return super.calculaCobertura() + "\n"
            + agregarDanosPorChoque();
    }

    private String agregarDanosPorChoque() {
        return "[Cobertura Choque] Daños por choque al vehiculo";
    }

}
