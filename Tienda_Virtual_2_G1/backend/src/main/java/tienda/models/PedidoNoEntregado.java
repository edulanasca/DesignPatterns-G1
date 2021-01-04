package tienda.models;

import tienda.models.patterns.IEstadoPedido;

public class PedidoNoEntregado implements IEstadoPedido {

    private String id;

    @Override
    public void procesar(Pedido pedido) {
        System.out.println("Ocurrio un error con la entrega del pedido " + pedido.getId());
        System.out.println("Reenviando pedido " + pedido.getId());
        pedido.setEstadoPedido(new PedidoPorEntregar());
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
