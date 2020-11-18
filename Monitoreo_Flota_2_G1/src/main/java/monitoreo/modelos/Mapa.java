package monitoreo.modelos;

import com.esri.arcgisruntime.concurrent.ListenableFuture;
import com.esri.arcgisruntime.geometry.CoordinateFormatter;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.Viewpoint;
import com.esri.arcgisruntime.mapping.view.Callout;
import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseButton;
import javafx.util.Duration;
import monitoreo.modelos.interfaces.IMapa;

import java.util.concurrent.ExecutionException;

public class Mapa implements IMapa {

  private MapView mapView;
  private int idVentana;
  private Basemap.Type type;

  private double coordenadaXInicial;
  private double coordenadaYInicial;
  private double coordenadaXActual;
  private double coordenadaYActual;

  private final RegistroLog registro = RegistroLog.getInstance();

  public Mapa() {
    this(Basemap.Type.IMAGERY, -12.05462, -77.08396); // UNMSM
  }

  public Mapa(Basemap.Type type, double coordenadaXInicial, double coordenadaYInicial) {
    this.coordenadaXInicial = coordenadaXInicial;
    this.coordenadaYInicial = coordenadaYInicial;
    this.type = type;

    // create a MapView to display the map and add it to the stack pane
    mapView = new MapView();
    idVentana++;

    // create an ArcGISMap with the default imagery basemap
    ArcGISMap map = new ArcGISMap(type, this.coordenadaXInicial, this.coordenadaYInicial, 12);

    // display the map by setting the map on the map view
    mapView.setMap(map);
    showCalloutWhenMouseClicked();
  }

  private void showCalloutWhenMouseClicked() {
    // click event to display the callout with the formatted coordinates of the clicked location
    mapView.setOnMouseClicked(e -> {
      // check that the primary mouse button was clicked and user is not panning
      if (e.isStillSincePress() && e.getButton() == MouseButton.PRIMARY) {
        // get the map point where the user clicked
        Point2D point = new Point2D(e.getX(), e.getY());
        //System.out.println("Coordenadas: " + e.getX() + ", " + e.getY());
        Point mapPoint = mapView.screenToLocation(point);
        // show the callout at the point with the different coordinate format strings
        showCalloutWithLocationCoordinates(mapPoint);
      }
    });
  }

  private void showCalloutWithLocationCoordinates(Point location) {
    Callout callout = mapView.getCallout();
    callout.setTitle("Location:");

    registro.log("IdVentana:[" + idVentana + "] - " +
        "Coordenadas: " + this.coordenadaXActual + ", " + this.coordenadaYActual);

    String latLonDecimalDegrees = CoordinateFormatter.toLatitudeLongitude(location, CoordinateFormatter
        .LatitudeLongitudeFormat.DECIMAL_DEGREES, 4);

    String[] s = latLonDecimalDegrees.trim().split(" ");
    this.coordenadaXActual = -Double.parseDouble(s[0].substring(0, s[0].length() - 1));
    this.coordenadaYActual = -Double.parseDouble(s[1].substring(0, s[1].length() - 1));

    String latLonDegMinSec = CoordinateFormatter.toLatitudeLongitude(location, CoordinateFormatter
        .LatitudeLongitudeFormat.DEGREES_MINUTES_SECONDS, 1);

    String utm = CoordinateFormatter.toUtm(location, CoordinateFormatter.UtmConversionMode.LATITUDE_BAND_INDICATORS,
        true);
    String usng = CoordinateFormatter.toUsng(location, 4, true);
    callout.setDetail(
        "Decimal Degrees: " + latLonDecimalDegrees + "\n" +
            "Degrees, Minutes, Seconds: " + latLonDegMinSec + "\n" +
            "UTM: " + utm + "\n" +
            "USNG: " + usng + "\n"
    );
    mapView.getCallout().showCalloutAt(location, new Duration(500));
  }

  public MapView getMapView() {
    return mapView;
  }

  public void setMapView(MapView mapView) {
    this.mapView = mapView;
  }

  public Basemap.Type getType() {
    return type;
  }

  public void setType(Basemap.Type type) {
    this.type = type;

    double x = this.coordenadaXActual == 0 ? this.coordenadaXInicial : this.coordenadaXActual;
    double y = this.coordenadaYActual == 0 ? this.coordenadaYInicial : this.coordenadaYActual;
    double scale = isNaN(this.mapView.getMapScale()) ? 12000 : this.mapView.getMapScale();

    this.mapView.setMap(new ArcGISMap(type, x, y, 6));

    Viewpoint viewpoint = new Viewpoint(x, y, scale);

    // take n seconds to move to viewpoint
    ListenableFuture<Boolean> viewpointSetFuture = mapView.setViewpointAsync(viewpoint, 3);

    viewpointSetFuture.addDoneListener(() -> {
      try {
        boolean completed = viewpointSetFuture.get();
        if (completed) {
          registro.log("IdVentana:[" + idVentana + "] - Acercamiento completado");

        }
      } catch (InterruptedException e) {
        registro.log("IdVentana:[" + idVentana + "] - Acercamiento interrumpido");
      } catch (ExecutionException e) {
        registro.log(RegistroLog.Level.ERROR, e.getMessage());
      }
    });

  }

  private boolean isNaN(double x) {
    return x != x;
  }

  public void imprimeCoordenadasActual() {

    registro.log("IdVentana:[" + idVentana + "] - " +
        "Coordenadas actual: [" + this.coordenadaXActual + ", " + this.coordenadaYActual + "]");
  }

  @Override
  public IMapa copiar() {
    Mapa m = new Mapa();
//    this.idVentana++;
    m.idVentana = this.idVentana + 1;
    m.coordenadaXInicial = this.coordenadaXInicial;
    m.coordenadaYInicial = this.coordenadaYInicial;
    m.coordenadaXActual = this.coordenadaXActual;
    m.coordenadaYActual = this.coordenadaYActual;
    m.setType(this.type);
    return m;
  }

}