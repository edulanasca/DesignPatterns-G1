package tienda.models;

import tienda.models.patterns.IEstadoPedido;

public class PedidoFinalizado implements IEstadoPedido {

    private String id;
    
    public PedidoFinalizado()   {}
    
    @Override
    public void procesar(Pedido pedido) {

        System.out.println("Finalizando pedido.");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
