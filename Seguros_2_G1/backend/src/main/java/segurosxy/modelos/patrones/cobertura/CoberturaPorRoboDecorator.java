package segurosxy.modelos.patrones.cobertura;

import segurosxy.modelos.interfaces.ICobertura;

public class CoberturaPorRoboDecorator extends CoberturaDecorator {

    public CoberturaPorRoboDecorator(ICobertura cobertura) {
        super(cobertura);
    }

    @Override
    public String calculaCobertura() {
        return super.calculaCobertura() + "\n"
        + agregarDanosPorRobo() + "\n";
    }

    private String agregarDanosPorRobo() {
        return "[Cobertura Robo] Daños por robo al vehiculo";
    }

}
