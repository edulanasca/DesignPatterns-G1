package segurosxy.seguro.vehiculo.model;

import segurosxy.modelos.Vehiculo;

public class SeguroRobo extends SeguroVehicular {

  public SeguroRobo() { }

  public SeguroRobo(Vehiculo vehiculo) {
    super(vehiculo);
  }

  @Override
  public String detalleSeguro() {
    return null;
  }

  @Override
  public void calcularRiesgo() {

  }
}
