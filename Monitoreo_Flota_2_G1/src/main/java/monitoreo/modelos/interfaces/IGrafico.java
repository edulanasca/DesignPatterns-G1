package monitoreo.modelos.interfaces;

import com.esri.arcgisruntime.mapping.view.Graphic;

public abstract class IGrafico {

    protected ITipoServicio tipoServicio;

    public IGrafico (ITipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public abstract void mover(Integer x, Integer Y);

    public abstract Double getPrecio();

    public void ejecutarServicio(){
        tipoServicio.ejecutarServicio();
    };

    public abstract Graphic getGrafico();
}
