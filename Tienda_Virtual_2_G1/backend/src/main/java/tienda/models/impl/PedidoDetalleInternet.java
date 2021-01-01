package tienda.models.impl;

import tienda.models.Pedido;
import tienda.models.interfaces.IPedidoDetalle;

public class PedidoDetalleInternet implements IPedidoDetalle {

    private String idProduct;
    private Integer quantity;
    private Double price;

    public PedidoDetalleInternet(String idProduct,Integer quantity,Double price)  {
        //this.order = order;
        //this.product = product;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public Double calculaPrecio() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pedido getPedido() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double getPrecio() {
        // Intenet Promocion
        Double customPrice = 0.0;
        customPrice = this.price * this.quantity * 0.85;
        return customPrice;
    }

    @Override
    public Integer getCantidad() {
        return quantity;
    }

    @Override
    public void setPedido(Pedido order) {
        // TODO Auto-generated method stub

    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    
}
