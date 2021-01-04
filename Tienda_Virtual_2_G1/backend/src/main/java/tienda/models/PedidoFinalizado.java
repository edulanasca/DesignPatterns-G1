package tienda.models;

import tienda.models.patterns.IEstadoPedido;

public class PedidoFinalizado implements IEstadoPedido {

    private String id;
    
    public PedidoFinalizado()   {}
    
    @Override
    public void procesar(Pedido pedido) {

        System.out.println("Finalizando pedido.");
    }

    @Override
    public void anular(Pedido pedido) {
        System.out.println("No se puede anular un pedido Finalizado");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
