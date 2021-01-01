package tienda.models.patterns;

import tienda.models.Pedido;

public interface IEstadoPedido {
    
    void procesar(Pedido pedido);
}
