package monitoreo;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import javafx.application.Application;
import monitoreo.modelos.Ventana;

public class Server {

    public static void main(String[] args) {

        System.out.println("Iniciando servidor...");
        ArcGISRuntimeEnvironment.setInstallDirectory("/opt/arcgis-runtime-sdk-java-100.9.0");

        Application.launch(Ventana.class, args);
    }

}
