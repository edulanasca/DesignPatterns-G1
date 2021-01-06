package tienda.models.patterns.iterator;

import tienda.models.interfaces.IPedidoDetalle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PrecioPedidoIterator implements IDetallePedidoIterator{

    private final List<IPedidoDetalle> detallePedido;
    protected int currentDetail = 0;

    public PrecioPedidoIterator(List<IPedidoDetalle> detallePedido)    {
        this.detallePedido = new ArrayList<>(detallePedido);
        this.detallePedido.sort(Comparator.comparing(IPedidoDetalle::getPrecio));
    }

    @Override
    public boolean hasNext() {
        return (currentDetail < detallePedido.size() && detallePedido.get(currentDetail) != null);
    }

    @Override
    public IPedidoDetalle next() {
        return detallePedido.get(currentDetail++);
    }
}
