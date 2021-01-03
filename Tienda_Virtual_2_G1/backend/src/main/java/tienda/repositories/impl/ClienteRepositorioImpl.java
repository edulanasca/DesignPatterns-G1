package tienda.repositories.impl;

import tienda.models.Cliente;
import tienda.repositories.ClienteRepositorio;

import java.util.List;
import java.util.LinkedList;

//import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.types.ObjectId;

public class ClienteRepositorioImpl implements ClienteRepositorio {

    private static final String COLLECTION_NAME = "clientes";
    private static final FindOneAndReplaceOptions UPDATE_OPTIONS = new FindOneAndReplaceOptions()
            .returnDocument(ReturnDocument.AFTER);

    private final MongoCollection<Cliente> clientes;

    public ClienteRepositorioImpl(MongoDatabase database) {
        this.clientes = database.getCollection(COLLECTION_NAME, Cliente.class);
    }

    @Override
    public void create(Cliente cliente) {
        System.out.println("entrando: " + cliente);
        cliente.setId((new ObjectId()).toString());
        cliente.getEstadoCliente().verificarInfo(cliente);
        clientes.insertOne(cliente);
    }

    @Override
    public void delete(String id) {
        clientes.deleteOne(new Document("_id", id));
    }

    @Override
    public Cliente find(String id) {
        //System.out.println("_id: " + id);
        return clientes.find(eq("_id", id)).first();
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> result = new LinkedList<>();

        for (Cliente cliente : clientes.find()) {
            //System.out.println("customer: " + customer);
            result.add(cliente);
        }

        return result;
    }

    @Override
    public Cliente update(Cliente post, String id) {
        post.getEstadoCliente().verificarInfo(post);
        System.out.println(post.getEstadoCliente().getClass().getName());
        return clientes.findOneAndReplace(new Document("_id", id), post, UPDATE_OPTIONS);
    }
    
}