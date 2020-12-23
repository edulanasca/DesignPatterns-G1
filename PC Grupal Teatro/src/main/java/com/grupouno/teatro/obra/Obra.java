package com.grupouno.teatro.obra;

import com.grupouno.teatro.butacas.Sector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Obra {

  private String nombre;
  private String sinopsis;
  private Sector sector;

  public Obra(Sector sector) {
    this.sector = sector;

  }

  abstract String obtenerTipoObra();

  abstract String seleccionarObra();

  public void seleccionarSector(){
    sector.calcularCosto();
  }

}
