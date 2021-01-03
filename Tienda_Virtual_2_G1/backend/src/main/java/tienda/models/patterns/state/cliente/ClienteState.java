package tienda.models.patterns.state.cliente;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import tienda.models.Cliente;

import java.util.List;

@BsonDiscriminator
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

  @Override
  public String toString() {
    return "ClienteState{" +
        "observacion='" + observacion + '\'' +
        ", estado=" + estado +
        '}';
  }
}
