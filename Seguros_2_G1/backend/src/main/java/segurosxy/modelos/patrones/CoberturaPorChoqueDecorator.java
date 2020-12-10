package segurosxy.modelos.patrones;

import segurosxy.modelos.interfaces.ICobertura;

public class CoberturaPorChoqueDecorator extends CoberturaDecorator {

    public CoberturaPorChoqueDecorator(ICobertura cobertura) {
        super(cobertura);
    }

    @Override
    public void calculaCobertura() {
        super.calculaCobertura();
        agregarDanosPorChoque();
    }

    private void agregarDanosPorChoque() {
        System.out.println("[Cobertura Choque] Daños por choque al vehiculo");
    }

}
