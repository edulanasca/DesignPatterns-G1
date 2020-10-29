package tienda.models;

import java.util.List;
import tienda.models.interfaces.IPedidoDetalle;
import tienda.models.metodopago.MetodoPago;


public class Pedido {
    private String id;
    private Double montoTotal;
    private String direccionEntrega;
    private String cliente;

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

    public Double calcularMontoPedido() {
        List<IPedidoDetalle> detallePedido = this.getDetallePedido();

        Double total = 0.0;

        for (IPedidoDetalle item : detallePedido) {
            total += item.getPrecio();
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

}