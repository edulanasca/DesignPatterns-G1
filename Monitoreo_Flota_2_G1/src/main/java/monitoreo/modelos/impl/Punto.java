package monitoreo.modelos.impl;

import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.SpatialReference;
import com.esri.arcgisruntime.geometry.SpatialReferences;
import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.mapping.view.GraphicsOverlay;
import com.esri.arcgisruntime.symbology.SimpleMarkerSymbol;
import monitoreo.modelos.interfaces.IGrafico;
import monitoreo.modelos.interfaces.ITipoServicio;

public class Punto implements IGrafico {

    private ITipoServicio tipoServicio;

    private Graphic punto;
    private static final SpatialReference SPATIAL_REFERENCE = SpatialReferences.getWgs84();
    SimpleMarkerSymbol circleSymbol;

    public Punto(ITipoServicio tipoServicio, Double latitud, Double longitud){
        this.tipoServicio = tipoServicio;

        circleSymbol = new SimpleMarkerSymbol(SimpleMarkerSymbol.Style.CIRCLE, 0xFFFF0000, 10);
        punto = new Graphic(new Point(longitud, latitud, SPATIAL_REFERENCE), circleSymbol);
        //graphicsOverlay.getGraphics().add(punto);
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
}
