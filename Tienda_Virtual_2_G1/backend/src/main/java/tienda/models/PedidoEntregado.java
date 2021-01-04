package tienda.models;

import tienda.models.patterns.IEstadoPedido;

public class PedidoEntregado implements IEstadoPedido {

    private String id;

    @Override
    public void procesar(Pedido pedido) {
        System.out.println("Se entrego el pedido " + pedido.getId());
        pedido.setEstadoPedido(new PedidoFinalizado());
    }

    @Override
    public void anular(Pedido pedido) {
        System.out.println("No se puede anular un pedido entregado");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
