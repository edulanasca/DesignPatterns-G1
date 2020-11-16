package monitoreo.modelos;

import com.esri.arcgisruntime.concurrent.ListenableFuture;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import monitoreo.modelos.impl.IconoNulo;
import monitoreo.modelos.impl.ImagenGif;
import monitoreo.modelos.impl.ImagenIcono;
import monitoreo.modelos.interfaces.IVentana;

import javax.imageio.ImageIO;
import java.io.File;
import java.security.PrivateKey;

public class Ventana extends Application implements IVentana{

  private Mapa mapaBase;
  private final HBox menuBtn = new HBox();
  private final FileChooser fileChooser = new FileChooser();
  private double width =800;
  private double reight =700;
  private String title = "Sistema de Monitoreo de Vehiculos";
  private Stage stg;

  @Override
  public void start(Stage stage) {

    initPane(stage);

    fileChooser.setInitialFileName("map-screenshot.png");
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG file (*.png)", "*.png"));

    Button btnNuevo = new Button();
    btnNuevo.setText("Nuevo");
    btnNuevo.setOnAction(event -> muestraNuevaVentana());
    btnNuevo.setGraphic(
        getImage(
            new ImagenIcono("https://upload-icon.s3.us-east-2.amazonaws.com/uploads/icons/png/4498062351543238871-512.png")
        ));
    addBtn(btnNuevo);

    btnNuevo = new Button();
    btnNuevo.setText("Captura");
    btnNuevo.setOnAction(event -> screenshot(stage));
    btnNuevo.setGraphic(
        getImage(
            new ImagenGif("https://skillsofthemodernage.com.au/img/resources/anim-icons/camera/animat-camera-color.gif")
        ));
    // https://developers.arcgis.com/java/latest/java/sample-code/change-viewpoint/
    addBtn(btnNuevo); // Se añade opcion

    btnNuevo = new Button();
    btnNuevo.setText("Clonar");
    btnNuevo.setOnAction(event -> copiar());
    addBtn(btnNuevo);
  }

  public void muestraNuevaVentana() {
    Stage stage = new Stage();

    BorderPane clonePane = new BorderPane();
    Scene scene = new Scene(clonePane);
    stage.setScene(scene);
    stage.setTitle(title);

    stage.setWidth(stg.getWidth());
    stage.setHeight(stg.getHeight());


    //  Clonacion de MapaBase
    Mapa mapaBase2 = (Mapa) mapaBase.copiar();

    mapaBase2.imprimeCoordenadasActual();
    clonePane.setCenter(mapaBase2.getMapView());

    clonePane.setCenter(mapaBase.getMapView());  // el mapa se pone al centro de la escena
    stage.show();
  }

  public void screenshot(Stage stage) {
    // export image from map view
    ListenableFuture<Image> mapImage = this.mapaBase.getMapView().exportImageAsync();
    mapImage.addDoneListener(() -> {
      try {
        // get image
        Image image = mapImage.get();
        // choose a location to save the file
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
          // write the image to the save location
          ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    });
  }

  public void addBtn(ButtonBase btn) {
    this.menuBtn.getChildren().add(btn);
  }


  private void initPane(Stage stage) {
    // set the title and size of the stage and show it
    stage.setTitle(title);
    stage.setWidth(width);
    stage.setHeight(reight);

    stage.show();
    
    // create a JavaFX scene with a stack pane as the root node and add it to the scene
    BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane);
    stage.setScene(scene);

    // create a MapView to display the map and add it to the stack pane
    mapaBase = new Mapa();
    mapaBase.imprimeCoordenadasActual();

    pane.setCenter(mapaBase.getMapView());  // el mapa se pone al centro de la escena
    pane.setBottom(this.menuBtn);   // se pone un HBox a modo de menu
    this.menuBtn.setAlignment(Pos.CENTER);
    stg = stage;
  }

  private ImageView getImage(Icono icono) {
    return (!icono.isNull() && icono.getImageView() != null) ? icono.getImageView() : new IconoNulo().getImageView();
  }



  @Override
  public IVentana copiar() {
    Ventana vent = new Ventana();
    Stage stage = new Stage();
    BorderPane clonePane = new BorderPane();
    Scene scene = new Scene(clonePane);
    stage.setScene(scene);
    stage.setTitle(title);

    stage.setWidth(stg.getWidth());
    stage.setHeight(stg.getHeight());


    //  Clonacion de MapaBase
    Mapa mapaBase2 = (Mapa) mapaBase.copiar();

    mapaBase2.imprimeCoordenadasActual();
    clonePane.setCenter(mapaBase2.getMapView());

    clonePane.setCenter(mapaBase.getMapView());  // el mapa se pone al centro de la escena
    stage.show();
    vent.stg = stage;
    return vent;
  }



}
