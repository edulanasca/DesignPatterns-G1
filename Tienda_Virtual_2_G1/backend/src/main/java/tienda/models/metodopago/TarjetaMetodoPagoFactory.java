package tienda.models.metodopago;

public class TarjetaMetodoPagoFactory implements MetodoPagoFactory {
  @Override
  public MetodoPago crearMetodoPago() {
    return new TarjetaMetodoPago();
  }
}
