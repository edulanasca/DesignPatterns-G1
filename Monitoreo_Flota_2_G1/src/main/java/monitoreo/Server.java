package monitoreo;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import javafx.application.Application;
import monitoreo.modelos.Ventana;

import java.nio.file.Paths;

public class Server {

    public static void main(String[] args) {

        /*System.out.println("Iniciando servidor...");
        ArcGISRuntimeEnvironment.setInstallDirectory(
                Paths.get(System.getProperty("user.home"),
                        "Downloads",
                        "arcgis-runtime-sdk-java-100.9.0",
                        "arcgis-runtime-sdk-java-100.9.0")
                        .toString()
        );*/

        ArcGISRuntimeEnvironment.setInstallDirectory("D://Descargas Web//arcgis-runtime-sdk-java-100.9.0//arcgis-runtime-sdk-java-100.9.0");

        Application.launch(Ventana.class, args);
    }

}
