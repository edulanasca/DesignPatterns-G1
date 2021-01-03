package tienda.models.interfaces;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import tienda.models.*;

@BsonDiscriminator
public interface IPedidoDetalle {

    Double calculaPrecio();

    Pedido getPedido();

    void setPedido(Pedido order);

    Integer getCantidad();

    Double getPrecio();

    String getIdProduct();

}
