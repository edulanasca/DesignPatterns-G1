package tienda.models;

import tienda.models.patterns.IEstadoPedido;

public class PedidoPorEntregar implements IEstadoPedido {

    private String id;
    
    public PedidoPorEntregar()  {}

    @Override
    public void procesar(Pedido pedido) {

        System.out.println("Entregando pedido: " + pedido.getId());

        if (pedido.isEntregado()) {
            pedido.setEstadoPedido(new PedidoEntregado());
        }else {
            pedido.setEstadoPedido(new PedidoNoEntregado());
        }

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
