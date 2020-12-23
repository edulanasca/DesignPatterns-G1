package com.grupouno.teatro.butacas;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SectorPalco extends SectorDecorator {

  public SectorPalco(Sector sectorDecorada) {
    super(sectorDecorada);
  }

  @Override
  public double calcularCosto() {
    return this.sectorDecorada.calcularCosto() + 40;
  }
}
