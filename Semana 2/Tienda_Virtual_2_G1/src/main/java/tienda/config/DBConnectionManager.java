package tienda.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoDatabase;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.codecs.configuration.CodecRegistries;

public class DBConnectionManager {

    private final MongoClient mongoClient;

    public DBConnectionManager() {
        this.mongoClient = new MongoClient( "localhost" , 27017 );
        //this.mongoDB = this.mongoClient.getDatabase("SRP");
    }

    public MongoDatabase getDatabase() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(
                        PojoCodecProvider.builder().automatic(true).build()
                )
        );
        MongoDatabase database = this.mongoClient.getDatabase("SRP").withCodecRegistry(pojoCodecRegistry);
        return database;
    }

    public void closeDatabase() {
        this.mongoClient.close();
    }

}