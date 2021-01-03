package tienda.models.patterns.iterator;

//import java.util.Iterator;

import tienda.models.interfaces.IPedidoDetalle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DetallePedidoIterator implements IDetallePedidoIterator {    // Iterator<IPedidoDetalle>

    private final List<IPedidoDetalle> detallePedido;
    protected int currentDetail = 0;

    public DetallePedidoIterator(List<IPedidoDetalle> detallePedido)    {
        this.detallePedido = new ArrayList<>(detallePedido);

        try {
            this.detallePedido.sort(Comparator.comparing(detalle -> detalle.getClass().getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }

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
