package segurosxy.modelos.patrones;

import segurosxy.modelos.interfaces.ICobertura;

public class CoberturaPorRoboDecorator extends CoberturaDecorator {

    public CoberturaPorRoboDecorator(ICobertura cobertura) {
        super(cobertura);
    }

    @Override
    public void calculaCobertura() {
        super.calculaCobertura();
        agregarDanosPorRobo();
    }

    private void agregarDanosPorRobo() {
        System.out.println("[Cobertura Robo] Daños por robo al vehiculo");
    }

}
