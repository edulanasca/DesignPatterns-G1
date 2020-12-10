package tienda.repositories.impl;

import tienda.models.Producto;
import tienda.repositories.ProductoRepositorio;

import java.util.List;
import java.util.LinkedList;

//import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

public class ProductoRepositorioImpl implements ProductoRepositorio {

    private static final String COLLECTION_NAME = "productos";
    private static final FindOneAndReplaceOptions UPDATE_OPTIONS = new FindOneAndReplaceOptions()
            .returnDocument(ReturnDocument.AFTER);

    private final MongoCollection<Producto> Products;

    public ProductoRepositorioImpl(MongoDatabase database) {
        this.Products = database.getCollection(COLLECTION_NAME, Producto.class);
    }

    @Override
    public void create(Producto Product) {
        System.out.println("entrando: " + Product);
        //Product.setCodigo((new ObjectId()).toString());
        Products.insertOne(Product);
    }

    @Override
    public void delete(String id) {
        Products.deleteOne(new Document("_id", id));
    }

    @Override
    public Producto find(String id) {
        //System.out.println("_id: " + id);
        return Products.find(eq("_id", id)).first();
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> result = new LinkedList<>();

        for (Producto Product : Products.find()) {
            //System.out.println("Product: " + Product);
            result.add(Product);
        }

        return result;
    }

    @Override
    public Producto update(Producto post, String id) {
        return Products.findOneAndReplace(new Document("_id", id), post, UPDATE_OPTIONS);
    }
    
}