package monitoreo;

import com.esri.arcgisruntime.geometry.*;
import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.symbology.SimpleLineSymbol;
import com.esri.arcgisruntime.symbology.SimpleMarkerSymbol;

public class GraficoFacade {

  private static final SpatialReference SPATIAL_REFERENCE = SpatialReferences.getWgs84();
  private static GraficoFacade graficoFacade;

  public GraficoFacade() {

  }

  public static GraficoFacade getInstance() {
    if (graficoFacade == null) {
      graficoFacade = new GraficoFacade();
    }
    return graficoFacade;
  }

  public Graphic dibujarPuntoCircular(Double lat, Double lon, int color, float tam) {
    return new Graphic(
        new Point(lon, lat, SPATIAL_REFERENCE),
        new SimpleMarkerSymbol(SimpleMarkerSymbol.Style.CIRCLE, color, tam)
    );
  }

  public Graphic dibujarLineaSolida(int color, float grosor, Double[][] puntos) {
    PointCollection points = new PointCollection(SPATIAL_REFERENCE);

    for (Double[] punto: puntos) {
      points.add(new Point(punto[1],punto[0]));
    }

    return new Graphic(
        new Polyline(points),
        new SimpleLineSymbol(SimpleLineSymbol.Style.SOLID, color, grosor)
    );
  }

}
