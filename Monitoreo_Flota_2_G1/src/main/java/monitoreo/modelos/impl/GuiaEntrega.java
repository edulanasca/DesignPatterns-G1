package monitoreo.modelos.impl;

import monitoreo.modelos.interfaces.IEntrega;

import java.util.ArrayList;
import java.util.List;

public class GuiaEntrega implements IEntrega {

    private List<IEntrega> entregas;

    public GuiaEntrega()    {
        entregas = new ArrayList<IEntrega>();
    }

    public void agregarEntrega(IEntrega entrega)    {

        if (entrega != null)
            this.entregas.add(entrega);
    }

    public void quitarEntrega(int posicion)    {

        this.entregas.remove(posicion);
    }

    public List<IEntrega> getEntregas()   {

        return this.entregas;
    }

    @Override
    public void listarEntrega() {

        for (IEntrega entregaProgramada : entregas) {

            entregaProgramada.listarEntrega();
        }
    }

    @Override
    public Double calcularCosto() {

        Double costoTotal = 0.0;
        for (IEntrega entregaProgramada : entregas) {

            costoTotal = costoTotal + entregaProgramada.calcularCosto();
        }
        return costoTotal;
    }
}
