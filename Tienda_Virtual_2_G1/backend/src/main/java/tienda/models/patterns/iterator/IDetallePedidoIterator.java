package tienda.models.patterns.iterator;

import tienda.models.interfaces.IPedidoDetalle;

public interface IDetallePedidoIterator {

    boolean hasNext();

    IPedidoDetalle next();
    
}
