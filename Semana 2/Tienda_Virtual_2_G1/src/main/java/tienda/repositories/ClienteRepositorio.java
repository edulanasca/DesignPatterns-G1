package tienda.repositories;
import tienda.models.Cliente;

import java.util.List;

public interface ClienteRepositorio {

    void create(Cliente cliente);

    Cliente find(String id);

    List<Cliente> findAll();

    Cliente update(Cliente post, String id);

    void delete(String id);
}