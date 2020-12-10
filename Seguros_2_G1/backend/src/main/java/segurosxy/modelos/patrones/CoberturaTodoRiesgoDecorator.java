package segurosxy.modelos.patrones;

import segurosxy.modelos.interfaces.ICobertura;

public class CoberturaTodoRiesgoDecorator extends CoberturaDecorator {

    public CoberturaTodoRiesgoDecorator(ICobertura cobertura) {
        super(cobertura);
    }

    @Override
    public void calculaCobertura() {
        super.calculaCobertura();
        agregarDanosTodoRiesgo();
    }

    private void agregarDanosTodoRiesgo() {
        System.out.println("[Cobertura Todo Riesgo] Daños por todo riesgo al vehiculo");
    }
}
