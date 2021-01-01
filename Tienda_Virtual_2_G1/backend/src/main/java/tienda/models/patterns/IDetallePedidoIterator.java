package tienda.models.patterns;

import tienda.models.interfaces.IPedidoDetalle;

public interface IDetallePedidoIterator {

    public boolean hasNext();

    public IPedidoDetalle next();
    
}
