package tienda.models;

import tienda.models.patterns.IEstadoPedido;

public class PedidoPorEntregar implements IEstadoPedido {

    private String id;
    
    public PedidoPorEntregar()  {}

    @Override
    public void procesar(Pedido pedido) {

        System.out.println("Entregando pedido: " + pedido.getId());

        pedido.setEstadoPedido( new PedidoFinalizado() );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
