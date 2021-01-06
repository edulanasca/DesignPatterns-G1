package tienda.models;

import tienda.models.patterns.DescuentoFactory;
import tienda.models.patterns.IDescuento;
import tienda.models.patterns.IEstadoPedido;

public class PedidoCreado implements IEstadoPedido {

  private String id;

  public PedidoCreado() {
  }

  @Override
  public void procesar(Pedido pedido) {

    //IDescuento descuento = factoryDiscount.crearDescuento(DescuentoFactory.DESCUENTO_ANIVERSARIO);
    IDescuento descuento = DescuentoFactory.getInstance().crearDescuento(DescuentoFactory.DESCUENTO_CUPON);
    pedido.setMontoTotal(pedido.calcularMontoPedido(descuento));
    //System.out.println("Precio Total " + order.getMontoTotal()  );

    System.out.println("Validado pedido con monto: " + pedido.getMontoTotal());

    pedido.setEstadoPedido(new PedidoValidado());
  }

  @Override
  public void anular(Pedido pedido) {
    System.out.println("El pedido se va a anular");
    pedido.setEstadoPedido(new PedidoAnulado());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
