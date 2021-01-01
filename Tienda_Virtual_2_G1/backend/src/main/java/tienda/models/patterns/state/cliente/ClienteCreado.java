package tienda.models.patterns.state.cliente;

import tienda.models.Cliente;


public class ClienteCreado extends ClienteState {

  private boolean isObservado = false;

  @Override
  public void verificarInfo(Cliente cliente) {

    if (super.correosNoAdmitidos.stream()
        .noneMatch(correo -> correo.equals(cliente.getCorreo().split("@")[1]))) {

      ClienteObservado observado = new ClienteObservado();

      if (cliente.getNumeroDocumento().length() > 8) {
        observado.getObservaciones().add("Numero de DNI mayor a 8 digitos");
        isObservado = true;
      }

      if (cliente.getDirecciones().stream()
          .anyMatch(direccion -> direccion.getDistrito() == null || direccion.getDistrito().isEmpty())) {
        observado.getObservaciones().add("La direccion no puede estar vacia");
        isObservado = true;
      }

      cliente.setEstadoCliente(isObservado ? observado : new ClienteActivo());

    } else {
      cliente.setEstadoCliente(new ClienteDesactivo());
    }

  }
}
