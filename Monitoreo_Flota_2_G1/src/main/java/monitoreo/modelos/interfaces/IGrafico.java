package monitoreo.modelos.interfaces;

import com.esri.arcgisruntime.mapping.view.Graphic;

public interface IGrafico {

    void mover(Integer x, Integer Y);

    Double getPrecio();

    void ejecutarServicio();

    void agregar(IGrafico grafico);

    void eliminar(IGrafico grafico);

    void mostrar();

}
