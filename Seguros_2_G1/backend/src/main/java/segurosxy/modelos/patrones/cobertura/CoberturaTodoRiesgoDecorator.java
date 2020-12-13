package segurosxy.modelos.patrones.cobertura;

import segurosxy.modelos.interfaces.ICobertura;

public class CoberturaTodoRiesgoDecorator extends CoberturaDecorator {

    public CoberturaTodoRiesgoDecorator(ICobertura cobertura) {
        super(cobertura);
    }

    @Override
    public String calculaCobertura() {
        return super.calculaCobertura() + "\n"
            + agregarDanosTodoRiesgo();
    }

    private String agregarDanosTodoRiesgo() {
        return "[Cobertura Todo Riesgo] Daños por todo riesgo al vehiculo";
    }
}
