package tienda.models.patterns.state.cliente;

import org.bson.codecs.pojo.annotations.BsonIgnore;
import tienda.models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteObservado extends ClienteState {

  @BsonIgnore
  private final List<String> observaciones = new ArrayList<>();

  public ClienteObservado() {
    super(Estado.OBSERVADO);
  }

  public List<String> getObservaciones() {
    return observaciones;
  }

  @Override
  public void verificarInfo(Cliente cliente) {

    if (observaciones.isEmpty()) {

      if (super.correosNoAdmitidos.stream()
          .anyMatch(correo -> correo.equals(cliente.getCorreo().split("@")[1]))) {
        cliente.setEstadoCliente(new ClienteDesactivo());
        return;
      }

      if (cliente.getNumeroDocumento().length() == 8 &&
          cliente.getDirecciones().stream().noneMatch(direccion -> direccion.getDistrito() == null)) {

        cliente.setEstadoCliente(new ClienteActivo());
      } else {
        cliente.setEstadoCliente(new ClienteObservado());
      }

    } else {
      super.setObservacion(String.join("\n", this.observaciones));
//      super.setEstado(Estado.OBSERVADO.name());
    }
  }
}
