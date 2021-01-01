package tienda.models.patterns.state.cliente;

import tienda.models.Cliente;

import java.util.List;

public abstract class ClienteState {

  private String observacion;
  private Estado estado;

  protected final List<String> correosNoAdmitidos = List.of("xyz.com", "pishing.es", "naive.org");

  public enum Estado {
    OBSERVADO, ACTIVO, DESACTIVO
  }

  public ClienteState() {
  }

  public ClienteState(Estado estado) {
    this.estado = estado;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  public String getObservacion() {
    return observacion;
  }

  public void setObservacion(String observacion) {
    this.observacion = observacion;
  }

  public abstract void verificarInfo(Cliente cliente);
}
