package monitoreo.modelos.impl;

import monitoreo.modelos.interfaces.IEntrega;

public class EntregaProgramada extends EntregaGeneral {


    public EntregaProgramada(String rangoHora, String fecha) {
        super(rangoHora, fecha);
    }

    @Override
    public void listarEntrega() {
        System.out.println("[Entrega Programada] Entrega planificada: " + this.fecha + " - " + this.rangoHora);
    }
}