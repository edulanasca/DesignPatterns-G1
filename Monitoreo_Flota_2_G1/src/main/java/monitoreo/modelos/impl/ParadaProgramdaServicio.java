package monitoreo.modelos.impl;

import monitoreo.modelos.interfaces.ITipoServicio;

public class ParadaProgramdaServicio implements ITipoServicio {
    @Override
    public void ejecutarServicio() {
        System.out.println("[ParadaProgramada] Ejecutando parada programada");
    }
}
