package segurosxy.cliente;

import io.javalin.http.Context;
import org  .bson.Document;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;
import segurosxy.cliente.model.Cliente;
import segurosxy.modelos.Poliza;
import segurosxy.modelos.Vehiculo;
import segurosxy.modelos.patrones.PaisContext;
import segurosxy.modelos.patrones.UbigeoContext;
import segurosxy.seguro.Seguro;
import segurosxy.seguro.tarjeta.SeguroTarjeta;
import segurosxy.seguro.vehiculo.model.SeguroVehicular;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteController {

  private final ClienteService clienteService;

  public ClienteController() {
    this.clienteService = new ClienteService();
  }

  @SuppressWarnings("unchecked")
  public void createCliente(Context context) {
    HashMap<String, Object> json = context.bodyAsClass(HashMap.class);

    List<Map<String, Object>> seguros = (List<Map<String, Object>>) json.get("seguros");

    Cliente cliente = new Cliente((String) json.get("nombre"));
    seguros.forEach(seguro -> cliente.setCompraSeguro(filtrarSeguro(seguro)));

    Map<String, String> ubigeoCasa = (Map<String, String>) json.get("ubigeoCasa");
    Map<String, String> ubigeoTrabajo = (Map<String,String>) json.get("ubigeoTrabajo");

    if (ubigeoCasa != null || ubigeoTrabajo != null) {
      cliente.getUbigeos().put("ubigeoCasa", new UbigeoContext(
              ubigeoCasa.get("codigoDepartamento"),
              ubigeoCasa.get("codigoProvincia"),
              ubigeoCasa.get("codigoDistrito")
      ));

      cliente.getUbigeos().put("ubigeoTrabajo", new UbigeoContext(
              ubigeoTrabajo.get("codigoDepartamento"),
              ubigeoTrabajo.get("codigoProvincia"),
              ubigeoTrabajo.get("codigoDistrito")
      ));
    }

    cliente.getPaises().put("paisResidencia", new PaisContext((String) json.get("paisResidencia")));
    cliente.getPaises().put("paisNacimiento", new PaisContext((String) json.get("paisNacimiento")));

    Document d = new Document();
    d.put("nombre", json.get("nombre").toString());
    d.put("seguros", cliente.getSeguros());
    d.put("ubigeos", cliente.getUbigeos());
    d.put("paises", cliente.getPaises());

    Document saved = clienteService.saveCliente(d);

    context
        .status(HttpStatus.CREATED_201)
        .header(HttpHeader.LOCATION.name(), "clientes/" + saved.get("_id"))
        .json(saved);
  }

  public void allClientes(Context context) {
    context.status(HttpStatus.OK_200)
        .json(clienteService.allClientes());
  }

  private Seguro filtrarSeguro(Map<String, Object> seguroObj) {
    Seguro seguro;

    if (seguroObj.get("tipoSeguro").equals("vehicular")) {
      seguro = SeguroVehicular.getSeguroVehicular((String) seguroObj.get("tipoVehicular"));
      ((SeguroVehicular) seguro).setVehiculo(new Vehiculo((String) seguroObj.get("marca"), (String) seguroObj.get("modelo")));
    } else {
      seguro = new SeguroTarjeta((String) seguroObj.get("bancoTarjeta"));
    }

    seguro.setPoliza(new Poliza((Integer) seguroObj.get("numeroPoliza")));
    seguro.calcularRiesgo();

    return seguro;
  }

}
