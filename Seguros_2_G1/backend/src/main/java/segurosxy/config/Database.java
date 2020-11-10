package segurosxy.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ResourceBundle;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Database {
  private static MongoDatabase db;

  private Database() {

  }

  public static MongoDatabase getDatabase() {
    if (db == null) {
      MongoClient client = MongoClients
          .create(clientSettings());

      db = client.getDatabase("Seguros");
    }
    return db;
  }

  private static MongoClientSettings clientSettings() {
    ConnectionString connectionString =
        new ConnectionString(ResourceBundle.getBundle("config").getString("mongo.url"));

    return MongoClientSettings
        .builder()
        .applyConnectionString(connectionString)
        .codecRegistry(codecRegistry())
        .build();
  }

  private static CodecRegistry codecRegistry() {
    CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
    return fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
  }
}
