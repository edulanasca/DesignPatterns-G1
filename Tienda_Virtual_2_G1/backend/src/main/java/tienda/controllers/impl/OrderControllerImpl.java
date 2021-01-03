package tienda.controllers.impl;

import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;
import tienda.config.Paths;
import tienda.controllers.OrderController;
import tienda.models.Entrega;
import tienda.models.EntregaBuilderDirector;
import tienda.models.Pedido;
import tienda.models.PedidoCreado;
import tienda.models.impl.PedidoDetalleInternet;
import tienda.models.impl.PedidoDetallePromocion;
import tienda.models.interfaces.IPedidoDetalle;
import tienda.models.metodopago.BlockChainMetodoPagoFactory;
import tienda.models.metodopago.MetodoPago;
import tienda.models.metodopago.MetodoPagoFactory;
import tienda.models.patterns.DescuentoFactory;
import tienda.models.patterns.EntregaBuilder;
import tienda.models.patterns.IDescuento;
import tienda.models.patterns.iterator.IDetallePedidoIterator;
import tienda.repositories.PedidoRepositorio;

import java.util.List;

//import org.bson.types.ObjectId;

public class OrderControllerImpl implements OrderController {
    private static final String ID = "id";

    private final PedidoRepositorio orderRepository;

    public OrderControllerImpl(PedidoRepositorio orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(Context context) {
        Pedido order = context.bodyAsClass(Pedido.class);

        List<IPedidoDetalle> items = List.of(
            new PedidoDetalleInternet( "P01010034", 1, 400.90),
            new PedidoDetallePromocion( "P01010025", 2, 600.90),
            new PedidoDetallePromocion( "P01010012", 2, 546.8),
            new PedidoDetalleInternet("P01010037", 3, 200.6),
            new PedidoDetalleInternet("P01010055", 5, 345.9),
            new PedidoDetallePromocion( "P01010044", 1, 348.8),
            new PedidoDetalleInternet("P01010078", 7, 123.8),
            new PedidoDetallePromocion( "P01010098", 1, 345.7)
        );

        order.setDetallePedido(items);
        //instancia Singleton del DescuentoFactory
        DescuentoFactory factoryDiscount = DescuentoFactory.getInstance();
        //IDescuento descuento = factoryDiscount.crearDescuento(DescuentoFactory.DESCUENTO_ANIVERSARIO);
        IDescuento descuento = factoryDiscount.crearDescuento(DescuentoFactory.DESCUENTO_CUPON);
        order.setMontoTotal( order.calcularMontoPedido(descuento) );

        order.setEstadoPedido( new PedidoCreado() );
        System.out.println("Pedido Creado.");   
        order.procesar();

        // Crear el pedido
        System.out.println("Precio Total " + order.getMontoTotal());

        MetodoPagoFactory factory = new BlockChainMetodoPagoFactory();
        MetodoPago paymentMethod = factory.crearMetodoPago();
        order.pagar(paymentMethod);

        orderRepository.create(order);

        String idO = order.getId();
        context.status(HttpStatus.CREATED_201)
                .header(HttpHeader.LOCATION.name(), Paths.formatPostLocation(idO));

        // Realiza la entrega del pedido
        EntregaBuilder deliveryBuilder = new EntregaBuilder( "idO" );
        deliveryBuilder.withDatosContacto("Lionel Messi", "6541122").withPersonalPropio("SI");
        EntregaBuilderDirector entregaDirector = new EntregaBuilderDirector(deliveryBuilder);
        Entrega entregaPedido = entregaDirector.buildEntregaTienda("24/11/2020", "Tienda Los Olivos", "Turno Tarde");
        System.out.println("Entrega: " + entregaPedido);

        order.setEntregaPedido(entregaPedido);

        //ANTES DE LAS MODIFICACIONES
        //Entrega entregaPedido = deliveryBuilder.withDatosContacto( "Lionel Messi", "6541122" )
        //.withEntregaDomicilio("Calle Las Azucenas 177", "24/11/2020", "Turno Tarde")
        //.withRecojoEnTienda("Tienda Los Olivos", "24/11/2020", "Turno Tarde")
        //.withPersonalPropio("Sí")
        //.build();


        System.out.println("Pedido Validado.");   
        order.procesar();
        try {
            orderRepository.update(order, order.getId());
        } catch(Exception e) { e.printStackTrace(); }

        System.out.println("Pedido Pagado.");
        order.procesar();

        System.out.println("Pedido Entregado.");   
        order.procesar();

        IDetallePedidoIterator iterator = order.iterator();
        while (iterator.hasNext()) {
            IPedidoDetalle detalle = iterator.next();
            System.out.println("Detalle: " +
                "[" + detalle.getClass().getSimpleName() + "] - " +
                detalle.getIdProduct() + " - " +
                detalle.getCantidad() + " - " +
                detalle.getPrecio() );
        }
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
