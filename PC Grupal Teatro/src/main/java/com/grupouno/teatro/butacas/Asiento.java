package com.grupouno.teatro.butacas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asiento implements Sector {

  private Integer numero;
  private Estado estado;
  private double precio;

  public Asiento(Integer numero) {
    this.numero = numero;
    this.estado = Estado.NO_DISPONIBLE;
  }

  @Override
  public double calcularCosto() {
    return 10;
  }

  public enum Estado {
    DISPONIBLE, NO_DISPONIBLE
  }
}
