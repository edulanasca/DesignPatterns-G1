package tienda.models.interfaces;

import tienda.models.*;

public interface IPedidoDetalle {

    public Double calculaPrecio();

    public Pedido getPedido();

    public void setPedido(Pedido order);

    public Integer getCantidad();

    public abstract Double getPrecio();

    public abstract String getIdProduct();

}
