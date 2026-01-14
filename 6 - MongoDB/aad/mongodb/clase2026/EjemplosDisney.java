package aad.mongodb.clase2026;

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

public class EjemplosDisney {
    public static void ej1(MongoCollection<Document> listaDisney){
        MongoIterable<Document> pelisLarga = listaDisney.find(Filters.lt("Running time (int)", 90));

        //System.out.println("Hay un total de " + pelisLarga);
        for (Document peliLarga : pelisLarga){
            System.out.println(peliLarga.getString("title") + " con duracion de " + peliLarga.get("Running time (int)") );
        }

    }

    public static void pelisDel2000Buenas(MongoCollection<Document> listaDisney){
        MongoIterable<Document> pelisLarga =
                listaDisney.find(Filters.and(
                                Filters.lt("Release date (datetime)", "2010-12-31"),
                                Filters.gt("Release date (datetime)", "2000-01-01"),
                                Filters.gt("metascore", 90)
                        )
                ).sort(Sorts.ascending("metascore"));

        // NOMBRE = "MARCOS" AND LLORON = TRUE
        // = NOMBRE MARCOS AND
        // Filters.and(
        for (Document peliLarga : pelisLarga){
            System.out.println(peliLarga.getString("title")
                    + " salio en " + peliLarga.get("Release date (datetime)") + "con" +  peliLarga.get("metascore"));
        }

    }

    public static void main(String[] args) {

        String connectionString =
                "SUSTITUID POR VUESTRA URL";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("AccesoDatos");

                // sacar info de colección
                MongoCollection<Document> listaDisney = database.getCollection("disney");

                pelisDel2000Buenas(listaDisney);
                // Running time (int) > 90
                // COLUMNA OPERADOR VALOR
                // peli = "COCO"
                // OPERADOR (CLUMNA, VALOR)

            } catch (MongoException e) {
                e.printStackTrace();
            }
        }

    }
}

