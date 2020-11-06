package segurosxy.modelos.seguro.vehiculo;

import segurosxy.modelos.Vehiculo;

public class SeguroChoque extends SeguroVehicular {
  public SeguroChoque(String marca, String modelo) {
    super(marca, modelo);
  }

  public SeguroChoque(Vehiculo vehiculo) {
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
