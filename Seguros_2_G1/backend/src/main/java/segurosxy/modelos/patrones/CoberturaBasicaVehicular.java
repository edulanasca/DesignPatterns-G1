package segurosxy.modelos.patrones;

import segurosxy.modelos.interfaces.ICobertura;

public class CoberturaBasicaVehicular implements ICobertura {

    public void calculaCobertura() {
        System.out.println("El seguro vehicular cubre: ");
        agregarDanosVehiculo();
    }

    private void agregarDanosVehiculo() {
        System.out.println("[Cobertura Base] Daños al vehiculo");
    }

}