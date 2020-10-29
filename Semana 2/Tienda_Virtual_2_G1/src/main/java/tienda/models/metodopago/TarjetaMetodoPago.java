package tienda.models.metodopago;

import tienda.models.Pedido;
import tienda.models.Tarjeta;

public class TarjetaMetodoPago implements MetodoPago {
  private Tarjeta tarjeta;

  public Tarjeta getTarjeta() {
    return tarjeta;
  }

  public void setTarjeta(Tarjeta tarjeta) {
    this.tarjeta = tarjeta;
  }

  @Override
  public void pagarPedido(Pedido order) {
    System.out.println("Procesando el pago con tarjeta " + this.tarjeta.getNumero() + "\n" +
        "Total: " + order.getMontoTotal() + "\n" +
        "Comision: " + this.devolverComision(order.getMontoTotal()));
  }

  @Override
  public double devolverComision(Double montoTotal) {
    return montoTotal * 0.10;
  }
}
