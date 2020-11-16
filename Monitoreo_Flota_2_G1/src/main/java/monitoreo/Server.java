package monitoreo;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import monitoreo.modelos.Mapa;

public class Server extends Application {

    public static void main(String[] args) {

        System.out.println("Iniciando servidor...");
        ArcGISRuntimeEnvironment.setInstallDirectory("/opt/arcgis-runtime-sdk-java-100.9.0");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Ventana ventana = new Ventana(stage);
        Scene scene = new Scene(ventana.getParent());
        stage.setScene(scene);
        ((Mapa) ventana.getMapBase()).imprimeCoordenadasActual();
        stage.setTitle("Sistema de Monitoreo de Vehiculos");
        stage.setWidth(ventana.getWidth());
        stage.setHeight(ventana.getHeight());
        stage.widthProperty().addListener(listener -> ventana.setWidth(((ReadOnlyDoubleProperty) listener).get()));
        stage.heightProperty().addListener(listener -> ventana.setHeight(((ReadOnlyDoubleProperty) listener).get()));

        stage.show();
    }

}
