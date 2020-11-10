package segurosxy.seguro.vehiculo.model;

import segurosxy.modelos.Vehiculo;

public class SeguroSOAT extends SeguroVehicular{

  public SeguroSOAT() {}

  public SeguroSOAT(String marca, String modelo) {
    super(marca, modelo);
  }

  public SeguroSOAT(Vehiculo vehiculo) {
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
