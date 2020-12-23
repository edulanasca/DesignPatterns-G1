package com.grupouno.teatro.butacas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectorGeneral implements Sector {

  private List<Sector> sectors = new java.util.ArrayList<>();

  public void agregarButaca(Sector sector) {
    this.sectors.add(sector);
  }

  public void eliminarButaca(Sector sector) {
    this.sectors.remove(sector);
  }

  @Override
  public double calcularCosto() {
    double sum = 0.0;
    for (Sector sector : sectors) {
      sum += sector.calcularCosto();
    }
    return sum;
  }
}
