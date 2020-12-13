package segurosxy.modelos.patrones.cobertura;

import segurosxy.modelos.interfaces.ICobertura;

public class CoberturaBasicaVehicular implements ICobertura {

    public String calculaCobertura() {
        return "El seguro vehicular cubre: " + "\n" +
            agregarDanosVehiculo();
    }

    private String agregarDanosVehiculo() {
        return "[Cobertura Base] Daños al vehiculo";
    }

}