package tienda.repositories;

import tienda.models.Producto;
import java.util.List;

public interface ProductoRepositorio {

    void create(Producto product);

    Producto find(String id);

    List<Producto> findAll();

    Producto update(Producto post, String id);

    void delete(String id);
}