package segurosxy.modelos.seguro.vehiculo;

import segurosxy.modelos.Vehiculo;

public class SeguroRobo extends SeguroVehicular {

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
