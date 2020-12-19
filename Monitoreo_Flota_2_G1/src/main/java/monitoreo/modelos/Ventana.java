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

    //graphicsOverlay = new GraphicsOverlay();
    Punto puntoRecojo = new Punto(recojo, -12.054901, -77.085470);
    puntoRecojo.ejecutarServicio();
    //graphicsOverlay.getGraphics().add(puntoRecojo.getPunto());
    facade.addGraphicsOverlay(puntoRecojo.getGrafico());


    Double[][] puntosEntrega = {
            {-12.054901, -77.085470},
            {-12.051833, -77.087903},
            {-12.061104, -77.084243},
            {-12.060876, -77.082660},
            {-12.067592, -77.081687},
            {-12.072936, -77.083132}
    };
    PoliLinea poliEntrega = new PoliLinea(entrega, puntosEntrega);
    //graphicsOverlay.getGraphics().add(poliEntrega.getPoligono());
    facade.addGraphicsOverlay(poliEntrega.getGrafico());
    poliEntrega.ejecutarServicio();

    Punto puntoEntrega = new Punto(entrega,-12.072936, -77.083132);
    //graphicsOverlay.getGraphics().add(puntoEntrega.getPunto());
    facade.addGraphicsOverlay(puntoEntrega.getGrafico());
    puntoEntrega.ejecutarServicio();

    //facade.getMapaBase().getMapView().getGraphicsOverlays().add(graphicsOverlay);
    facade.addGraphicOverlay();
    //facade.getStackPane().getChildren().add(mapaBase.getMapView());
    facade.stackAddMapView();

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
