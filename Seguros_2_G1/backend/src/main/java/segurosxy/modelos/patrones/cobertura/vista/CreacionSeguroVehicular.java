package segurosxy.modelos.patrones.cobertura.vista;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.bson.Document;
import segurosxy.config.Database;
import segurosxy.modelos.interfaces.ICobertura;
import segurosxy.modelos.patrones.cobertura.*;

import java.util.ArrayList;
import java.util.List;

public class CreacionSeguroVehicular extends Application {

  private ICobertura basica = new CoberturaBasicaVehicular();
  private final List<ICobertura> referencias = new ArrayList<>();
  private final TextArea area = new TextArea();
  private final VBox coberturaDecorator = new VBox();

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Creacion de Seguro Vehicular");
    stage.setWidth(700);
    stage.setHeight(500);

    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(10, 10 , 10, 10));

    TextField marca = new TextField();
    marca.setMaxWidth(150);

    TextField modelo = new TextField();
    modelo.setMaxWidth(150);

    gridPane.add(new Label("Marca"), 0, 0);
    gridPane.add(marca, 1,0);
    gridPane.add(new Label("Modelo"), 0,1);
    gridPane.add(modelo, 1, 1);
    gridPane.add(new Label("Cobertura"), 0, 2);

    ComboBox<String> coberturas = new ComboBox<>(
        FXCollections.observableArrayList(
            "Por Choque",
            "Por Robo",
            "Todo Riesgo",
            "Afectación a terceros"
        )
    );

    coberturas.getSelectionModel().selectFirst();

    gridPane.add(coberturas, 1, 2);

    Button addCobertura = new Button("Añadir cobertura");
    gridPane.add(addCobertura, 2, 2);

    gridPane.add(coberturaDecorator, 1, 3);

    coberturaDecorator.setAlignment(Pos.CENTER);

    addCobertura.setOnAction(event -> {
      HBox hBox = new HBox();
      TextField cobertura = new TextField(
          coberturas.getSelectionModel().getSelectedItem()
      );
      cobertura.setEditable(false);

      switch (coberturas.getSelectionModel().getSelectedIndex()) {
        case 0:
          basica = new CoberturaPorChoqueDecorator(basica);
          referencias.add(basica);
          break;
        case 1:
          basica = new CoberturaPorRoboDecorator(basica);
          referencias.add(basica);
          break;
        case 2:
          basica = new CoberturaTodoRiesgoDecorator(basica);
          referencias.add(basica);
          break;
        case 3:
          basica = new CoberturaAfectacionATercerosDecorator(basica);
          referencias.add(basica);
          break;
      }

      Button eliminar = new Button("X");
      eliminar.setOnAction(event1 -> {
        int index = coberturaDecorator.getChildren().indexOf(hBox); // Obtener el índice de la fila a eliminar

        if (coberturaDecorator.getChildren().size() == index + 1) {
          if (basica instanceof CoberturaBasicaVehicular) {
            basica = new CoberturaBasicaVehicular();
          } else {
            basica = ((CoberturaDecorator) basica).getCobertura();
            referencias.remove(index);
          }
        } else {
          ((CoberturaDecorator) basica).removeDecorator(referencias.get(index)); // Quitar la cobertura
          referencias.remove(index);
        }

        area.clear();
        area.setText(basica.calculaCobertura()); // Actualizar el area de texto

        coberturaDecorator.getChildren().remove(index); // Remover la fila
      });

      area.clear();
      area.setText(basica.calculaCobertura());

      hBox.getChildren().addAll(cobertura, eliminar);
      coberturaDecorator.getChildren().add(hBox);
    });


    gridPane.add(area, 1, 4);
    area.setPrefWidth(450);
    area.setWrapText(true);
    area.setText(basica.calculaCobertura());

    Button guardarSeguro = new Button("Agregar Seguro Vehicular");
    gridPane.add(guardarSeguro, 1, 5);

    guardarSeguro.setOnAction(event -> {

      Document seguro = new Document();
      seguro.put("marca", marca.getText());
      seguro.put("modelo", modelo.getText());
      seguro.put("cobertura", basica.calculaCobertura());

      Database.getDatabase().getCollection("segurosVehiculares").insertOne(seguro);
      marca.clear();
      modelo.clear();
      coberturas.getSelectionModel().select(0);

      area.clear();
      basica = new CoberturaBasicaVehicular();
      area.setText(basica.calculaCobertura());

      ObservableList<Node> list = FXCollections.observableArrayList(coberturaDecorator.getChildren());
      list.forEach(e -> coberturaDecorator.getChildren().remove(e));
    });

    Scene scene = new Scene(gridPane);
    stage.setScene(scene);
    stage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }
}
