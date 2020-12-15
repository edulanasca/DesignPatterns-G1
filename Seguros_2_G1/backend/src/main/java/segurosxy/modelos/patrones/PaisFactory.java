package segurosxy.modelos.patrones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import segurosxy.config.Database;

import java.util.HashMap;
import java.util.Objects;

import static com.mongodb.client.model.Filters.eq;

public class PaisFactory {

    private final HashMap<String, PaisFlyweight> paises = new HashMap<>();
    private static PaisFactory paisFactory = null;
    private final MongoCollection<Document> paisesCol = Database.getDatabase().getCollection("paises");

    public static synchronized PaisFactory getInstance() {

        if (paisFactory == null) {

            paisFactory = new PaisFactory();
        }
        return paisFactory;
    }

    private PaisFactory() {

        try (MongoCursor<Document> cursor = this.paisesCol.find().iterator()) {
            while (cursor.hasNext()) {
                Document pais = cursor.next();
                this.paises.put((String) pais.get("codPais"), new PaisFlyweight((String) pais.get("descPais")));
            }
        }
    }

    public PaisFlyweight getPais(String codPais) {

        if (paises.get(codPais) == null) {

            paises.put(codPais, new PaisFlyweight((String) Objects.requireNonNull(
                    this.paisesCol.find(eq("codPais", codPais)).first())
                    .getOrDefault("descPais", "")));
            System.out.println("[PaisFactory] Creando y recuperando los datos de PaisFlyweight");
        }
        return paises.get(codPais);
    }

}
