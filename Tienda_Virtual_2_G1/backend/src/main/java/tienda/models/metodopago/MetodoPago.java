package tienda.models.metodopago;

import tienda.models.Pedido;

public interface MetodoPago {

    void pagarPedido(Pedido order);
    double devolverComision(Double montoTotal);

}
