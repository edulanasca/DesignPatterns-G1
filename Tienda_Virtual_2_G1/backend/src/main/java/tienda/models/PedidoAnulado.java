package tienda.models;

import tienda.models.patterns.IEstadoPedido;

public class PedidoAnulado implements IEstadoPedido {

    private String id;

    @Override
    public void procesar(Pedido pedido) {
        pedido = null;
        System.out.println("Se a anulado el pedido");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
