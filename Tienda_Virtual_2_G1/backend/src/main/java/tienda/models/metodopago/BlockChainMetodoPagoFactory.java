package tienda.models.metodopago;

public class BlockChainMetodoPagoFactory implements MetodoPagoFactory {
  @Override
  public MetodoPago crearMetodoPago() {
    return new BlockChainMetodoPago();
  }
}
