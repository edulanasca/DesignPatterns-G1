package com.grupouno.teatro.obra;

import com.grupouno.teatro.butacas.Sector;

public class ObraDrama extends Obra {
  public ObraDrama() {
    super();
    super.setNombre("Obra de Drama");
  }

  public ObraDrama(Sector sector) {
    super(sector);
  }

  @Override
  String obtenerTipoObra() {
    return "Obra de Drama";
  }

  @Override
  String seleccionarObra() {
    return "Cronicas de una muerte anunciada";
  }

}
