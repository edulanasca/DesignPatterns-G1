package tienda.controllers.impl;

import tienda.config.Paths;
import tienda.controllers.OrderController;
import tienda.models.Entrega;
import tienda.models.Pedido;
import tienda.models.impl.PedidoDetalleInternet;
import tienda.models.impl.PedidoDetallePromocion;
import tienda.models.interfaces.IPedidoDetalle;
import tienda.models.metodopago.BlockChainMetodoPagoFactory;
import tienda.models.metodopago.MetodoPago;
import tienda.models.metodopago.MetodoPagoFactory;
import tienda.models.patterns.DescuentoFactory;
import tienda.models.patterns.EntregaBuilder;
import tienda.models.patterns.IDescuento;
import tienda.repositories.PedidoRepositorio;

import io.javalin.http.Context;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;

import java.util.ArrayList;
import java.util.List;

//import org.bson.types.ObjectId;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;

public class OrderControllerImpl implements OrderController {
    private static final String ID = "id";

    private final PedidoRepositorio orderRepository;

    public OrderControllerImpl(PedidoRepositorio orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(Context context) {
        Pedido order = context.bodyAsClass(Pedido.class);

        List<IPedidoDetalle> items = new ArrayList<>();
        PedidoDetalleInternet oi1 = new PedidoDetalleInternet( "P01010034", 1, 400.90);
        PedidoDetallePromocion oi2 = new PedidoDetallePromocion( "P01010025", 1, 600.90);
        items.add(oi1);
        items.add(oi2);
        order.setDetallePedido(items);
        //instancia Singleton del DescuentoFactory
        DescuentoFactory factoryDiscount = DescuentoFactory.getInstance();
        //IDescuento descuento = factoryDiscount.crearDescuento(DescuentoFactory.DESCUENTO_ANIVERSARIO);
        IDescuento descuento = factoryDiscount.crearDescuento(DescuentoFactory.DESCUENTO_CUPON);
        order.setMontoTotal( order.calcularMontoPedido(descuento) );

        System.out.println("Precio Total " + order.getMontoTotal());

        MetodoPagoFactory factory = new BlockChainMetodoPagoFactory();
        MetodoPago paymentMethod = factory.crearMetodoPago();
        order.pagar(paymentMethod);

        orderRepository.create(order);

        String idO = order.getId();
        context.status(HttpStatus.CREATED_201)
                .header(HttpHeader.LOCATION.name(), Paths.formatPostLocation(idO));

        // Realiza la entrega del pedido
        EntregaBuilder deliveryBuilder = new EntregaBuilder( idO );
        Entrega entregaPedido = deliveryBuilder.withDatosContacto( "Lionel Messi", "6541122" )
            //.withEntregaDomicilio("Calle Las Azucenas 177", "24/11/2020", "Turno Tarde")
            .withRecojoEnTienda("Tienda Los Olivos", "24/11/2020", "Turno Tarde")
            .withPersonalPropio("Sí")
            .build();
        System.out.println("Entrega: " + entregaPedido);

        order.setEntregaPedido(entregaPedido);

        try {
            orderRepository.update(order, order.getId());
        } catch(Exception e) { e.getMessage(); }

    }

    public void find(Context context) {
        String id = context.pathParam(ID);
        Pedido order = orderRepository.find(id);

        if (order == null) {
            throw new NotFoundResponse(String.format("A order with id '%s' is not found", id));
        }

        context.json(order);

    }

    public void findAll(Context context) {
        context.json(orderRepository.findAll());
    }

    @Override
    public void delete(Context context) {
        orderRepository.delete(context.pathParam(ID));

    }


    @Override
    public void update(Context context) {
        Pedido order = context.bodyAsClass(Pedido.class);
        String id = context.pathParam(ID);

        if (order.getId() != null && !order.getId().equals(id)) {
            throw new BadRequestResponse("Id update is not allowed");
        }

        orderRepository.update(order, id);

    }
}