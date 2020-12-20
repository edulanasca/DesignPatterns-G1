package monitoreo.modelos.interfaces;

import com.esri.arcgisruntime.mapping.view.Graphic;

public abstract class IGrafico {

    protected String nombre;
    protected ITipoServicio tipoServicio;

    public IGrafico(String nombre, ITipoServicio tipoServicio) {
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
    }

    public abstract void mover(Integer x, Integer Y);

    public abstract Double getPrecio();

    public void ejecutarServicio(){
        tipoServicio.ejecutarServicio();
    };

    public abstract Graphic getGrafico();
    public abstract void mostrar();
    public abstract void agregar(IGrafico grafico);
    public abstract void eliminar(IGrafico grafico);
}
