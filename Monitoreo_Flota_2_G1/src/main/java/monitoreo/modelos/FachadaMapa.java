package monitoreo.modelos;

import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.mapping.view.GraphicsOverlay;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FachadaMapa {
    private GraphicsOverlay graphicsOverlay;
    private StackPane stackPane;
    private Mapa mapaBase;

    public FachadaMapa(Stage stage){
        // set the title and size of the stage and show it
        stage.setTitle("Sistema de Monitoreo de Vehiculos");
        stage.setWidth(800);
        stage.setHeight(700);
        stage.show();

        // create a JavaFX scene with a stack pane as the root node and add it to the scene
        stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        stage.setScene(scene);

        graphicsOverlay = new GraphicsOverlay();
    }

    public Mapa mostrarMapa()  {

        mapaBase = new Mapa();
        mapaBase.imprimeCoordenadasActual();
        return mapaBase;
    }

    public void addGraphicsOverlay(Graphic graphic){
        this.graphicsOverlay.getGraphics().add(graphic);
    }

    public void addGraphicOverlay(){
        mapaBase.getMapView().getGraphicsOverlays().add(graphicsOverlay);
    }

    public void stackAddMapView(){
        stackPane.getChildren().add(mapaBase.getMapView());
    }

    public StackPane getStackPane(){
        return stackPane;
    }

    public Mapa getMapaBase(){
        return mapaBase;
    }
}
