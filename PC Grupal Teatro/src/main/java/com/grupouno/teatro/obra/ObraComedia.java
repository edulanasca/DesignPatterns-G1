package com.grupouno.teatro.obra;

import com.grupouno.teatro.butacas.Sector;


public class ObraComedia extends Obra {
  public ObraComedia() {
    super();
    super.setNombre("Obra de Comedia");
  }

  public ObraComedia(Sector sector) {
    super(sector);
  }

  @Override
  String obtenerTipoObra() {
    return "Obra de Comedia";
  }

  @Override
  String seleccionarObra() {
    return "Jaja obra en dos actos";
  }
}
