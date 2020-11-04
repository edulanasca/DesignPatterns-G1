package tienda.models.impl;

import tienda.models.Pedido;
import tienda.models.interfaces.IPedidoDetalle;

public class PedidoDetallePromocion implements IPedidoDetalle {

    private String idProduct;
    private Integer quantity;
    private Double price;

    public PedidoDetallePromocion(String idProduct, Integer quantity, Double price)  {
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
        Double customPrice = 0.0;
        customPrice = this.price * this.quantity;

        // promo primera compra
        customPrice -= 20.0;

        if (customPrice < 0 ) {
            customPrice = 0.0;
        }
        return customPrice;
    }

    @Override
    public Integer getCantidad() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPedido(Pedido order) {
        // TODO Auto-generated method stub

    }
    
}