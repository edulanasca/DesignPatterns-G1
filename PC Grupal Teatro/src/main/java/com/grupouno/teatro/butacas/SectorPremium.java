package com.grupouno.teatro.butacas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SectorPremium extends SectorDecorator {

  public SectorPremium(Sector sectorDecorada) {
    super(sectorDecorada);
  }

  @Override
  public double calcularCosto() {
    return this.sectorDecorada.calcularCosto() + 30;
  }
}
