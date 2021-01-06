package tienda.models;

import tienda.models.patterns.EntregaBuilder;
import tienda.models.patterns.IEstadoPedido;

public class PedidoValidado implements IEstadoPedido    {

    private String id;

    public PedidoValidado() {}

    @Override
    public void procesar(Pedido pedido) {

        // Realiza la entrega del pedido
/*
        EntregaBuilder deliveryBuilder = new EntregaBuilder( pedido.getId().toString() );
        Entrega entregaPedido = deliveryBuilder.withDatosContacto( "Lionel Messi", "6541122" )
            //.withEntregaDomicilio("Calle Las Azucenas 177", "24/11/2020", "Turno Tarde")
            .withRecojoEnTienda("Tienda Los Olivos", "24/11/2020", "Turno Tarde")
            .withPersonalPropio("Sí")
            .build();
        //System.out.println("Entrega: " + entregaPedido);

        pedido.setEntregaPedido(entregaPedido);
*/
        Entrega entregaPedido = pedido.getEntregaPedido();

        System.out.println("Pendiente de entrega con direccion: " + entregaPedido);

        pedido.setEstadoPedido( new PedidoPorEntregar() );
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
