package monitoreo.modelos.impl;

import monitoreo.modelos.interfaces.ITipoServicio;

public class EntregaTipoServicio implements ITipoServicio {

    @Override
    public void ejecutarServicio() {
        System.out.println("[EntregaTipoServicio] Ejecutando entrega");
    }

}
