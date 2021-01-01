package tienda.models.patterns.state.cliente;

import tienda.models.Cliente;

public class ClienteDesactivo extends ClienteState {

  public ClienteDesactivo() {
    super(Estado.DESACTIVO);
  }

  @Override
  public void verificarInfo(Cliente cliente) {
    super.setObservacion("El correo " + cliente.getCorreo() + " tiene un dominio no permitido.");
  }
}
