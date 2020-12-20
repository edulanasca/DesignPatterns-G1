package monitoreo.modelos.impl;

import com.esri.arcgisruntime.mapping.view.Graphic;
import monitoreo.GraficoFacade;
import monitoreo.modelos.interfaces.IGrafico;
import monitoreo.modelos.interfaces.ITipoServicio;

public class Punto implements IGrafico {

    private String nombre;

    private ITipoServicio tipoServicio;
    private final Graphic punto;

    public Punto(String nombre, Double latitud, Double longitud) {
        this.nombre = nombre;
        this.punto = GraficoFacade.getInstance()
            .dibujarPuntoCircular(latitud, longitud, 0xFFFF0000, 10);
    }

    public Punto(ITipoServicio tipoServicio, Double latitud, Double longitud){
        this.tipoServicio = tipoServicio;
        this.punto = GraficoFacade.getInstance()
            .dibujarPuntoCircular(latitud, longitud, 0xFFFF0000, 10);
    }

    public Graphic getGrafico(){
        return getPunto();
    }

    public Graphic getPunto() {
        // alertas
        System.out.println("[Punto] Obteniendo Punto para agregarlo al mapa");
        return punto;
    }

    @Override
    public void mover(Integer x, Integer Y) {

    }

    @Override
    public Double getPrecio() {
        System.out.println("[Punto] Precio del punto 1 $");
        return 1.0;
    }

    @Override
    public void ejecutarServicio() {
        //System.out.println("[Punto] Ejecutando punto");
        tipoServicio.ejecutarServicio();
    }

    @Override
    public void agregar(IGrafico grafico) {
        System.out.println("No se puede agregar rutas a un punto");
    }

    @Override
    public void eliminar(IGrafico grafico) {
        System.out.println("No se puede quitar un punto");
    }

    @Override
    public void mostrar() {
        System.out.println("[Punto] " + nombre);
    }
}
