package monitoreo;

import com.esri.arcgisruntime.concurrent.ListenableFuture;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import monitoreo.modelos.Icono;
import monitoreo.modelos.Mapa;
import monitoreo.modelos.RegistroLog;
import monitoreo.modelos.interfaces.IMapa;
import monitoreo.modelos.interfaces.IVentana;

import javax.imageio.ImageIO;
import java.io.File;

public class Ventana implements IVentana {

  private Stage stage;
  private BorderPane parent;
  private HBox menuBtn;

  private IMapa mapBase;

  private double width = 700.0;
  private double height = 700.0;

  public Ventana() {
    this.parent = new BorderPane();
    this.menuBtn = new HBox();
    this.mapBase = new Mapa(); // TODO clone map when creating a new win
    init();
  }

  public Ventana(Stage stage) {
    this();
    this.stage = stage;
  }

  public Stage getStage() {
    return stage;
  }

  public void setStage(Stage stage) {
    this.stage = stage;
  }

  public BorderPane getParent() {
    return parent;
  }

  public void setParent(BorderPane parent) {
    this.parent = parent;
  }

  public HBox getMenuBtn() {
    return menuBtn;
  }

  public void setMenuBtn(HBox menuBtn) {
    this.menuBtn = menuBtn;
    this.parent.setBottom(this.menuBtn);
  }

  public IMapa getMapBase() {
    return mapBase;
  }

  public void setMapBase(IMapa mapBase) {
    this.mapBase = mapBase;
    this.parent.setCenter(((Mapa) this.mapBase).getMapView());
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width <= 0 ? 700 : width;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height <= 0 ? 800 : height;
  }

  /**
   * Configuracion de los elementos de Ventana
   */
  private void init() {

    this.menuBtn.setAlignment(Pos.CENTER);
    this.addBtn(nuevo());
    this.addBtn(captura());

    this.parent.setCenter(((Mapa) this.mapBase).getMapView());
    this.parent.setBottom(this.menuBtn);
  }

  /**
   * Añadir opciones al menu
   *
   * @param button Botón a añadir
   */
  public void addBtn(ButtonBase button) {
    this.menuBtn.getChildren().add(button);
  }

  private Button nuevo() {
    Button button = new Button();
    button.setText("Nuevo");

    button.setOnAction(event -> muestraNuevaVentana());

    button.setGraphic(
        Icono
            .getIcono("https://upload-icon.s3.us-east-2.amazonaws.com/uploads/icons/png/4498062351543238871-512.png")
            .getImageView()
    );

    return button;
  }

  private void muestraNuevaVentana() {

    Stage stage = new Stage();
    Ventana ventana = copiar();

    RegistroLog.getInstance().log(this.toString());
    RegistroLog.getInstance().log(ventana.toString());

    Scene scene = new Scene(ventana.getParent());

    ((Mapa) ventana.getMapBase()).imprimeCoordenadasActual();
    stage.setTitle("Sistema de Monitoreo de Vehiculos");
    stage.setHeight(ventana.getHeight());
    stage.setWidth(ventana.getWidth());

    stage.widthProperty().addListener(listener -> ventana.setWidth(((ReadOnlyDoubleProperty) listener).get()));
    stage.heightProperty().addListener(listener -> ventana.setHeight(((ReadOnlyDoubleProperty) listener).get()));

    stage.setScene(scene);
    stage.show();
  }

  public Button captura() {
    Button button = new Button();
    button.setText("Captura");
    button.setOnAction(event -> screenshoot(this.stage));
    button.setGraphic(
        Icono
            .getIcono("https://skillsofthemodernage.com.au/img/resources/anim-icons/camera/animat-camera-color.gif")
            .getImageView()
    );

    return button;
  }

  public void screenshoot(Stage stage) {
    final FileChooser fileChooser = new FileChooser();

    fileChooser.setInitialFileName("map-screenshot.png");
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG file (*.png)", "*.png"));

    ListenableFuture<Image> mapImage = ((Mapa) this.mapBase).getMapView().exportImageAsync();
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

  @Override
  public Ventana copiar() {
    Ventana v = new Ventana();

    v.setWidth(this.getWidth());
    v.setHeight(this.getHeight());
    v.setMapBase(this.mapBase.copiar());
    return v;
  }
}