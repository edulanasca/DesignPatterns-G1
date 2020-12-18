package monitoreo.modelos.impl;

import com.esri.arcgisruntime.geometry.*;
import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.symbology.SimpleLineSymbol;
import monitoreo.modelos.interfaces.IGrafico;
import monitoreo.modelos.interfaces.ITipoServicio;

import java.util.List;

public class PoliLinea implements IGrafico {

    private ITipoServicio tipoServicio;

    private Graphic poligono;

    private static final SpatialReference SPATIAL_REFERENCE = SpatialReferences.getWgs84();

    public PoliLinea(ITipoServicio tipoServicio, Double[][] puntos) {

        this.tipoServicio = tipoServicio;

        // create a green (0xFF005000) simple line symbol
        SimpleLineSymbol outlineSymbol = new SimpleLineSymbol(SimpleLineSymbol.Style.SOLID, 0xffffff00, 3.0f);
        
        // create a new point collection for polygon
        PointCollection points = new PointCollection(SPATIAL_REFERENCE);

        // create and add points to the point collection
        for(Double[] punto: puntos){
            points.add(new Point(punto[1], punto[0]));
        }

        // create the polyline from the point collection
        Polyline polygon = new Polyline(points);

        // create the graphic with polyline and symbol
        System.out.println(polygon.toJson().toString());
        this.poligono = new Graphic(polygon, outlineSymbol);

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
}
