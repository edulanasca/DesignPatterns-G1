package tienda.models;

import java.util.List;
import tienda.models.interfaces.IPedidoDetalle;
import tienda.models.patterns.iterator.DetallePedidoCollection;
import tienda.models.patterns.iterator.DetallePedidoIterator;
import tienda.models.metodopago.MetodoPago;
import tienda.models.patterns.IDescuento;
import tienda.models.patterns.iterator.IDetallePedidoIterator;
import tienda.models.patterns.IEstadoPedido;

public class Pedido implements DetallePedidoCollection {
    private String id;
    private Double montoTotal;
    private String direccionEntrega;
    private String cliente;
    private Entrega entregaPedido;
    private Double descuento;
    private IEstadoPedido estadoPedido;

    //Señal si esta se entrego o no (se actuliza cuando el usuario recive el producto)
    private boolean entregado = false;
    private List<IPedidoDetalle> detallePedido;


    public List<IPedidoDetalle> getDetallePedido() {
        //List<IOrderItem> ordersItems = new ArrayList<>();
        /*
            Get logic, ORM, SQL
        */
        return detallePedido;
    }

    public IEstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(IEstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public void setDetallePedido(List<IPedidoDetalle> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public Double calcularMontoPedido(IDescuento descuento) {
        List<IPedidoDetalle> detallePedido = this.getDetallePedido();

        Double total = 0.0;

        for (IPedidoDetalle item : detallePedido) {
            total += item.getPrecio();
        }

        //  Resta el descuento
        if (descuento != null)   {
            this.descuento = descuento.getDescuento();
            total = total - this.descuento;
        }

        return total;
    }

    public void pagar(MetodoPago paymentMethod)   {
        System.out.println("Paying order " + getId());
        paymentMethod.pagarPedido(this);
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Entrega getEntregaPedido() {
        return entregaPedido;
    }

    public void setEntregaPedido(Entrega entregaPedido) {
        this.entregaPedido = entregaPedido;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public void procesar() {

        estadoPedido.procesar(this);
    }

    public void anular() {
        estadoPedido.anular(this);
    }

    @Override
    public IDetallePedidoIterator iterator() {

        return new DetallePedidoIterator( detallePedido );
    }

    //geter y seter de la señar de entregado

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
}
