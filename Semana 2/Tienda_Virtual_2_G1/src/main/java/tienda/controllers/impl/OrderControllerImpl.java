package tienda.controllers.impl;

import tienda.config.Paths;
import tienda.controllers.OrderController;
import tienda.models.metodopago.BlockChainMetodoPago;
import tienda.models.Pedido;
import tienda.models.impl.PedidoDetalleInternet;
import tienda.models.impl.PedidoDetallePromocion;
import tienda.models.interfaces.IPedidoDetalle;
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

    private PedidoRepositorio orderRepository;

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
        order.setMontoTotal( order.calcularMontoPedido() );

        System.out.println("Precio Total " + order.getMontoTotal());

        //MetodoPago paymentMethod = new MetodoPago();
        BlockChainMetodoPago paymentMethod = new BlockChainMetodoPago();
        order.pagar(paymentMethod);

        orderRepository.create(order);

        context.status(HttpStatus.CREATED_201)
                .header(HttpHeader.LOCATION.name(), Paths.formatPostLocation(order.getId().toString()));

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

        if (order.getId() != null && !order.getId().toString().equals(id)) {
            throw new BadRequestResponse("Id update is not allowed");
        }

        orderRepository.update(order, id);

    }
}