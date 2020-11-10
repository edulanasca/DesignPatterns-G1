package segurosxy.cliente;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import segurosxy.config.Database;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.mongodb.client.model.Filters.eq;

public class ClienteService {

  private final MongoCollection<Document> clientes;

  public ClienteService() {
    clientes = Database.getDatabase().getCollection("clientes");
  }

  public Document saveCliente(Document cliente) {
    clientes.insertOne(cliente);
    return clientes.find(eq("nombre", cliente.get("nombre").toString())).first();
  }

  public List<Document> allClientes() {
    return StreamSupport.stream(clientes.find().spliterator(), false).collect(Collectors.toList());
  }

}
