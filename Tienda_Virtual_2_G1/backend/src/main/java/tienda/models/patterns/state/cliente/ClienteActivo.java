package tienda.models.patterns.state.cliente;

import tienda.models.Cliente;

public class ClienteActivo extends ClienteState {

  public ClienteActivo() {
    super(Estado.ACTIVO);
  }

  @Override
  public void verificarInfo(Cliente cliente) {
    super.setObservacion("Ninguna observación para " + cliente.getNombre());
  }
}
