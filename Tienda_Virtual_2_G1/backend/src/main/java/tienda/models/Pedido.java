package tienda.models;

import java.util.List;
import tienda.models.interfaces.IPedidoDetalle;
import tienda.models.metodopago.MetodoPago;
import tienda.models.patterns.IDescuento;


public class Pedido {
    private String id;
    private Double montoTotal;
    private String direccionEntrega;
    private String cliente;
    private Entrega entregaPedido;
    private Double descuento;

    private List<IPedidoDetalle> detallePedido;


    public List<IPedidoDetalle> getDetallePedido() {
        //List<IOrderItem> ordersItems = new ArrayList<>();
        /*
            Get logic, ORM, SQL
        */
        return detallePedido;
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

}