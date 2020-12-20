package monitoreo.modelos.impl;

import monitoreo.modelos.interfaces.ITipoServicio;

public class MantenimientoVehiculoServicio implements ITipoServicio {
    @Override
    public void ejecutarServicio() {
        System.out.println("[MantenimientoVehiculo] Ejecutando mantenimiento");
    }
}
