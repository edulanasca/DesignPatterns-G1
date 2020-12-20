package monitoreo.modelos.impl;

import com.esri.arcgisruntime.mapping.view.Graphic;
import monitoreo.GraficoFacade;
import monitoreo.modelos.interfaces.IGrafico;
import monitoreo.modelos.interfaces.ITipoServicio;

import java.util.ArrayList;
import java.util.List;

public class PoliLinea implements IGrafico {

    private final String nombre;

    private final List<IGrafico> graficos = new ArrayList<>();
    private final ITipoServicio tipoServicio;
    private final Graphic poligono;

    public PoliLinea(String nombre, int color, Double[][] puntos) {
        this(nombre, null, color, puntos);
    }

    public PoliLinea(ITipoServicio tipoServicio, int color, Double[][] puntos) {
        this("", tipoServicio, color, puntos);
    }

    public PoliLinea(String nombre, ITipoServicio tipoServicio, int color, Double[][] puntos) {
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
        this.poligono = GraficoFacade.getInstance()
            .dibujarLineaSolida(color, 3.0f, puntos);
    }

    public Graphic getGrafico(){
        return getPoligono();
    }

    public Graphic getPoligono(){
        System.out.println("[PoliLinea] Obtener poligono para agregarlo al mapa");
        return this.poligono;
    }

    @Override
    public void mover(Integer x, Integer Y) {

    }

    @Override
    public Double getPrecio() {
        System.out.println("[PoliLinea] Precio del punto 1 $");
        return 1.0;
    }

    @Override
    public void ejecutarServicio() {
        //System.out.println("[Punto] Ejecutando punto");
        tipoServicio.ejecutarServicio();
    }

    @Override
    public void mostrar() {
        System.out.println("[Ruta] " + nombre);
        for (IGrafico grafico : graficos) grafico.mostrar();
    }

    @Override
    public void agregar(IGrafico grafico) {
        this.graficos.add(grafico);
    }

    @Override
    public void eliminar(IGrafico grafico) {
        this.graficos.remove(grafico);
    }
}
