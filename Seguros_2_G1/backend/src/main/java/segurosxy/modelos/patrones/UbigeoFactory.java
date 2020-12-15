package segurosxy.modelos.patrones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.Connection;
import org.bson.Document;
import segurosxy.config.Database;
//import segurosxy.config.Connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UbigeoFactory {
    
    private static final HashMap<String, HashMap<String, HashMap<String, List<String>>>> megaCache = new HashMap<>();
    private static final HashMap<String, UbigeoFlyweight> ubigeos = new HashMap<>();

    private static UbigeoFactory ubigeoFactory = null;

    public static synchronized UbigeoFactory getInstance()  {

        if (ubigeoFactory == null)  {

            ubigeoFactory = new UbigeoFactory();
        }
        return ubigeoFactory;
    }

    private UbigeoFactory()  {

        if(megaCache.isEmpty()){
            System.out.println("[UbigeoFactory] Cargando data desde mongo");
            MongoCollection<Document> ubigeos = Database.getDatabase().getCollection("ubigeo");
            try (MongoCursor<Document> cursor = ubigeos.find().iterator()) {
                while (cursor.hasNext()) {
                    Document ubi = cursor.next();
                    String codDep = (String) ubi.get("cod_dep_inei");
                    String descDep = (String) ubi.get("desc_dep_inei");
                    String codProv = (String) ubi.get("cod_prov_inei");
                    codProv = codProv.substring(2);
                    String descProv = (String) ubi.get("desc_prov_inei");
                    String codUbi = (String) ubi.get("cod_ubigeo_inei");
                    codUbi = codUbi.substring(4);
                    String descUbi = (String) ubi.get("desc_ubigeo_inei");

                    megaCache.computeIfAbsent(codDep, k -> new HashMap<>());
                    megaCache.get(codDep).computeIfAbsent(codProv, k -> new HashMap<>());
                    if (megaCache.get(codDep).get(codProv).get(codUbi) == null) {
                        List<String> list = new ArrayList<>();
                        list.add(descDep);
                        list.add(descProv);
                        list.add(descUbi);
                        megaCache.get(codDep).get(codProv).put(codUbi, list);
                    }
                    //System.out.println(codDep+","+codProv+","+codUbi);
                }
            }

        }
        System.out.println("[UbigeoFactory] Data obtenida de la cache");
    }

    public UbigeoFlyweight getUbigeo( String codigoDepartamento, String codigoProvincia, String codigoDistrito)  {

        UbigeoFlyweight flyweight;

        if ( ubigeos.get( codigoDepartamento + codigoProvincia + codigoDistrito)==null  )   {

            List<String> datos = megaCache.get(codigoDepartamento).get(codigoProvincia).get(codigoDistrito);
            flyweight = new UbigeoFlyweight( datos.get(0), datos.get(1), datos.get(2) );
            ubigeos.put( codigoDepartamento + codigoProvincia + codigoDistrito, flyweight);
            System.out.println("[UbigeoFactory] Creando y recuperando los datos de UbigeoFlyweight");
        }
        else {
            flyweight = ubigeos.get( codigoDepartamento + codigoProvincia + codigoDistrito);
        }
        return flyweight;
    }
}
