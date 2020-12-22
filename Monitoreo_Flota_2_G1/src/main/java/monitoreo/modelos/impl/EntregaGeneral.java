package monitoreo.modelos.impl;

import monitoreo.modelos.interfaces.IEntrega;

public abstract class EntregaGeneral implements IEntrega {

    protected String rangoHora;
    protected String fecha;
    protected Double costo = 99.90;

    public EntregaGeneral(String rangoHora, String fecha)  {
        this.rangoHora = rangoHora;
        this.fecha = fecha;
    }

    @Override
    public void listarEntrega(){}

    @Override
    public Double calcularCosto() {
        return this.costo;
    }
}
