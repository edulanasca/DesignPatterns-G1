package monitoreo.modelos.impl;

import monitoreo.modelos.interfaces.ITipoServicio;

public class RecojoTipoServicio implements ITipoServicio {

    @Override
    public void ejecutarServicio() {
        System.out.println("[RecojoTipoServicio] Ejecutando recojo");
    }

}
