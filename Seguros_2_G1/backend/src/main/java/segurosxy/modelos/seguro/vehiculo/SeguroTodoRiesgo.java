package segurosxy.modelos.seguro.vehiculo;

import segurosxy.modelos.Vehiculo;

public class SeguroTodoRiesgo extends SeguroVehicular{

  public SeguroTodoRiesgo(String marca, String modelo) {
    super(marca, modelo);
  }

  public SeguroTodoRiesgo(Vehiculo vehiculo) {
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
