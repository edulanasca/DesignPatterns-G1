package tienda.repositories.impl;

import tienda.models.Pedido;
import tienda.repositories.PedidoRepositorio;

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

public class PedidoRepositorioImpl implements PedidoRepositorio {

    private static final String COLLECTION_NAME = "pedidos";
    private static final FindOneAndReplaceOptions UPDATE_OPTIONS = new FindOneAndReplaceOptions()
            .returnDocument(ReturnDocument.AFTER);

    private final MongoCollection<Pedido> pedidos;

    public PedidoRepositorioImpl(MongoDatabase database) {
        this.pedidos = database.getCollection(COLLECTION_NAME, Pedido.class);
    }

    @Override
    public void create(Pedido pedido) {

        pedido.setId((new ObjectId()).toString());
        pedidos.insertOne(pedido);
    }

    @Override
    public void delete(String id) {
        pedidos.deleteOne(new Document("_id", id));
    }

    @Override
    public Pedido find(String id) {
        //System.out.println("_id: " + id);
        return pedidos.find(eq("_id", id)).first();
    }

    @Override
    public List<Pedido> findAll() {
        List<Pedido> result = new LinkedList<>();

        for (Pedido Order : pedidos.find()) {
            //System.out.println("Order: " + Order);
            result.add(Order);
        }

        return result;
    }

    @Override
    public Pedido update(Pedido post, String id) {
        return pedidos.findOneAndReplace(new Document("_id", id), post, UPDATE_OPTIONS);
    }
    
}