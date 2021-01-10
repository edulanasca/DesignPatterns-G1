package segurosxy.seguro;

import io.javalin.http.Context;
import segurosxy.cliente.model.ClienteAsegurado;
import segurosxy.modelos.SeguroEmpresa;
import segurosxy.modelos.Vehiculo;
import segurosxy.modelos.patrones.mediator.DummyCorreoMediator;
import segurosxy.seguro.vehiculo.model.SeguroChoque;
import segurosxy.seguro.vehiculo.model.SeguroSOAT;
import segurosxy.seguro.vehiculo.model.SeguroTodoRiesgo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeguroController {

  @SuppressWarnings("unchecked")
  public void createSeguro(Context context) {
    Map<String, Object> json = context.bodyAsClass(HashMap.class);

    final Seguro seguro;
    Vehiculo vehiculo = new Vehiculo(json.get("marca").toString(), json.get("modelo").toString());

    switch ((String) json.get("tipo")) {
      case "choque": seguro = new SeguroChoque(vehiculo); break;
      case "todoriesgo": seguro = new SeguroTodoRiesgo(vehiculo); break;
      case "empresa": seguro = new SeguroEmpresa(vehiculo); break;
      default: seguro = new SeguroSOAT(vehiculo);
    }

    DummyCorreoMediator correoMediator = new DummyCorreoMediator();

    List<String> clientes = (List<String>) json.get("afiliados");
    clientes.forEach(cliente -> {
      ClienteAsegurado asegurado = new ClienteAsegurado(cliente, correoMediator);
      asegurado.setSeguros(List.of(seguro));
      seguro.addObserver(asegurado);
    });

    seguro.notificarAfiliacion();
  }

}
