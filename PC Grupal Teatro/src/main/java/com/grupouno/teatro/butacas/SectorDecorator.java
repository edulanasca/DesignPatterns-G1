package com.grupouno.teatro.butacas;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class SectorDecorator implements Sector {

  Sector sectorDecorada;

  public SectorDecorator(Sector sectorDecorada) {
    this.sectorDecorada = sectorDecorada;
  }
}
