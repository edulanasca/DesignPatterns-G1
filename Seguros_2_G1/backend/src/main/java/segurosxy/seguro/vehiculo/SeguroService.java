package segurosxy.seguro.vehiculo;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import segurosxy.config.Database;
import segurosxy.modelos.Certificado;
import segurosxy.seguro.Seguro;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.mongodb.client.model.Filters.eq;
import static segurosxy.config.Utils.objectToJson;

public class SeguroService {

  private final MongoCollection<Document> seguros;

  public SeguroService() {
    this.seguros = Database.getDatabase().getCollection("seguros");
  }

  public Document save(Seguro entity) {
    seguros.insertOne(Document.parse(objectToJson(entity)));
    return seguros.find(eq("certificado.numero", ((Certificado)entity.getCertificado()).getNumero())).first();
  }

  public Document getSeguro(ObjectId id) {
    return seguros.find(eq("_id", id)).first();
  }

  public List<Document> findAll() {
    return StreamSupport.stream(seguros.find().spliterator(), false).collect(Collectors.toList());
  }


}
