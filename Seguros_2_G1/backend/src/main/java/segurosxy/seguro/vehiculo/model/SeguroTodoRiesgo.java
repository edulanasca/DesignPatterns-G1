package segurosxy.seguro.vehiculo.model;

import segurosxy.modelos.Vehiculo;

public class SeguroTodoRiesgo extends SeguroVehicular{

  public SeguroTodoRiesgo() { }

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
