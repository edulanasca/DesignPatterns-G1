package tienda.repositories;

import tienda.models.Pedido;

import java.util.List;

public interface PedidoRepositorio {
    
    void create(Pedido pedido);

    Pedido find(String id);

    List<Pedido> findAll();

    Pedido update(Pedido post, String id);

    void delete(String id);
}