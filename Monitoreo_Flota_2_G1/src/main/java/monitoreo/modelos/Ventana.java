package monitoreo.modelos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import monitoreo.modelos.impl.*;
import monitoreo.modelos.interfaces.ITipoServicio;


public class Ventana extends Application {

  private Mapa mapaBase;

  @Override
  public void start(Stage stage) throws Exception {

    FachadaMapa facade = new FachadaMapa(stage);
    facade.mostrarMapa();

    facade.getMapaBase().imprimeCoordenadasActual();

    Icono imagen = new ImagenIcono("https://upload-icon.s3.us-east-2.amazonaws.com/uploads/icons/png/4498062351543238871-512.png");

    Button btnNuevo = new Button();
    btnNuevo.setGraphic( (imagen.getImageView()!=null)?imagen.getImageView(): new IconoNulo().getImageView() );
    btnNuevo.setText("Nuevo");
    btnNuevo.setOnAction(event -> muestraNuevaVentana());

    // https://developers.arcgis.com/java/latest/java/sample-code/change-viewpoint/
    facade.getStackPane().getChildren().add(btnNuevo);
    StackPane.setAlignment(btnNuevo, Pos.BOTTOM_CENTER);
    StackPane.setMargin(btnNuevo, new Insets(10, 10, 10, 10));

    // Entregas programadas para una misma ruta
    // Double costoTotal = 0.0; No es necesario usar un acumulador
    GuiaEntrega guia = new GuiaEntrega();
    guia.agregarEntrega(new EntregaProgramada("09:00-10:00", "14/12/2020"));
    guia.agregarEntrega(new EntregaProgramada("10:00-11:00", "14/12/2020"));
    guia.agregarEntrega(new EntregaProgramada("12:00-13:00", "14/12/2020"));
    guia.listarEntrega();

    GuiaEntrega guiaGeneral = new GuiaEntrega();
    guiaGeneral.agregarEntrega(new EntregaProgramada("13:00-14:00", "15/12/2020"));
    guiaGeneral.agregarEntrega(new EntregaProgramada("15:00-16:00", "15/12/2020"));
    guiaGeneral.agregarEntrega(guia);

    System.out.println("[Cliente][Guia General] Costo total "+guiaGeneral.calcularCosto());

    // Crear ruta con entrega y recojo
    // Alertas y notificaciones
    // Eliminar clases que repiten comportamiento
    ITipoServicio recojo = new RecojoTipoServicio();
    ITipoServicio entrega = new EntregaTipoServicio();

    ITipoServicio mantenimiento = new MantenimientoVehiculoServicio();
    ITipoServicio paradaProgramada = new ParadaProgramdaServicio();

    Punto puntoMantenimiento = new Punto(mantenimiento, -12.055332, -77.084903);
    puntoMantenimiento.ejecutarServicio();
    facade.addGraphicsOverlay(puntoMantenimiento.getGrafico());

    //graphicsOverlay = new GraphicsOverlay();
    Punto puntoRecojo = new Punto(recojo, -12.054901, -77.085470);
    puntoRecojo.ejecutarServicio();
    //graphicsOverlay.getGraphics().add(puntoRecojo.getPunto());
    facade.addGraphicsOverlay(puntoRecojo.getGrafico());

    Double[][] puntosEntrega = {
            {-12.055332, -77.084903},
            {-12.054901, -77.085470},
            {-12.051833, -77.087903},
            {-12.061104, -77.084243},
            {-12.060876, -77.082660},
            {-12.061899, -77.081970},
            {-12.067592, -77.081687},
            {-12.072936, -77.083132},

    };
    PoliLinea poliEntrega = new PoliLinea(entrega, 0xFFFFFF00, puntosEntrega);
    //graphicsOverlay.getGraphics().add(poliEntrega.getPoligono());
    facade.addGraphicsOverlay(poliEntrega.getGrafico());
    poliEntrega.ejecutarServicio();

    Punto puntoProgramada = new Punto(paradaProgramada, -12.061899, -77.081970);
    puntoProgramada.ejecutarServicio();
    facade.addGraphicsOverlay(puntoProgramada.getGrafico());

    Punto puntoEntrega = new Punto(entrega,-12.072936, -77.083132);
    //graphicsOverlay.getGraphics().add(puntoEntrega.getPunto());
    facade.addGraphicsOverlay(puntoEntrega.getGrafico());
    puntoEntrega.ejecutarServicio();

    trazarRutasReparto(facade);

    //facade.getMapaBase().getMapView().getGraphicsOverlays().add(graphicsOverlay);
    facade.addGraphicOverlay();
    //facade.getStackPane().getChildren().add(mapaBase.getMapView());
    facade.stackAddMapView();

  }

  public void trazarRutasReparto(FachadaMapa mapa) {

    Double[][] R1 = {
        {-12.07155, -77.07245},
        {-12.07224, -77.06885},
        {-12.07159, -77.06155},
        {-12.06824, -77.06121},
        {-12.06735, -77.06015},
        {-12.06649, -77.05425},
        {-12.05719, -77.05172},
        {-12.05335, -77.06385},
    };

    Double[][] subR1 = {
        {-12.06795, -77.06063},
        {-12.07206, -77.05883},
        {-12.07525, -77.05377},
        {-12.08641, -77.06325},
        {-12.09489, -77.05059}
    };

    Double[][] SR1A = {
        {-12.08064, -77.05833},
        {-12.08341, -77.05434},
        {-12.08236, -77.04554},
        {-12.07968, -77.04233},
        {-12.0751, -77.04228},
        {-12.07376, -77.0307},
        {-12.07712, -77.02859},
        {-12.072, -77.01173}
    };

    Punto puntoPartidaR1 = new Punto("Punto partida R1", R1[0][0], R1[0][1]);
    Punto puntoLlegadaR1 = new Punto("Punto llegada R1", R1[R1.length - 1][0], R1[R1.length - 1][1]);
    PoliLinea rutaUno = new PoliLinea("R1", 0xFF1EFFF5, R1);
    Punto puntoPartidaSR1 = new Punto("Punto partida SR1", subR1[0][0], subR1[0][1]);
    Punto puntoLlegadaSR1 = new Punto("Punto llegada SR1", subR1[subR1.length - 1][0], subR1[subR1.length - 1][1]);
    PoliLinea subRutaUno = new PoliLinea("SR1", 0xFF7AFF1E, subR1);
    Punto puntoPartidaSR1A = new Punto("Punto partida SR1A", SR1A[0][0], SR1A[0][1]);
    Punto puntoLlegadaSR1A = new Punto("Punto llegada SR1A", SR1A[SR1A.length - 1][0], SR1A[SR1A.length - 1][1]);
    PoliLinea subRuta1A = new PoliLinea("SR1A", 0xFFFF2E27, SR1A);

    mapa.addGraphicsOverlay(puntoPartidaR1.getGrafico());
    mapa.addGraphicsOverlay(rutaUno.getGrafico());
    mapa.addGraphicsOverlay(puntoLlegadaR1.getGrafico());
    mapa.addGraphicsOverlay(puntoPartidaSR1.getGrafico());
    mapa.addGraphicsOverlay(subRutaUno.getGrafico());
    mapa.addGraphicsOverlay(puntoLlegadaSR1.getGrafico());
    mapa.addGraphicsOverlay(puntoPartidaSR1A.getGrafico());
    mapa.addGraphicsOverlay(subRuta1A.getGrafico());
    mapa.addGraphicsOverlay(puntoLlegadaSR1A.getGrafico());

    rutaUno.agregar(puntoPartidaR1);
    rutaUno.agregar(subRutaUno);
    rutaUno.agregar(puntoLlegadaR1);

    subRutaUno.agregar(puntoPartidaSR1);
    subRuta1A.agregar(puntoPartidaSR1A);
    subRutaUno.agregar(subRuta1A);
    subRuta1A.agregar(puntoLlegadaSR1A);
    subRutaUno.agregar(puntoLlegadaSR1);

    rutaUno.mostrar();
  }

  public void muestraNuevaVentana() {
    Stage stage = new Stage();
    StackPane stackPane = new StackPane();
    Scene scene = new Scene(stackPane);
    stage.setScene(scene);
    stage.setTitle("Sistema de Monitoreo de Vehiculos");
    stage.setWidth(800);
    stage.setHeight(700);

    //  Clonacion de MapaBase
    Mapa mapaBase2 = (Mapa) mapaBase.copiar();

    mapaBase2.imprimeCoordenadasActual();
    stackPane.getChildren().add(mapaBase2.getMapView());

    stage.show();
  }

}
