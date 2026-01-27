package aad.mongodb.clase2026;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.List;

public class EjemplosAggregationPipeline {

    // sacar nota máxima de los juegos según su plataforma
    public static void notaMaximaPorPlataforma(MongoCollection<Document> listaJuegos){



        listaJuegos.aggregate(List.of()).forEach(doc -> System.out.println(doc.toJson()));

    }

    // ¿cuantos juegos hay por consola? De más a menos
    public static void juegosPorConsola(MongoCollection<Document> listaJuegos){


        listaJuegos.aggregate(List.of( )).forEach(doc -> System.out.println(doc.toJson()));;

    }

    // sacar nota media de los juegos de switch

    public void notaMediaSwitch(MongoCollection<Document> listaJuegos){


        //listaJuegos.aggregate(List.of()).forEach(doc -> System.out.println(doc.toJson()));

    }

    // Sacar top 5 peores juegos de Switch o de Wii, ordenados por meta_score ascendente
    public void top5PeoresSwitchWii(MongoCollection<Document> listaJuegos){
        /*
        [
          { $match: { platform: { $in: ["Switch", "Wii"] } } },
          { $sort: { meta_score: 1 } },
          { $limit: 5 }
        ]
         */
       // listaJuegos.aggregate()
        //listaJuegos.aggregate(List.of()).forEach(doc -> System.out.println(doc.toJson()));

    }
    // sacar el juego (o juegos) de la GBA que tenga(n) la menor nota en meta_score
    // Este ejemplo en dos partes.
    public void juegoGBAMejorNota(MongoCollection<Document> listaJuegos){
        /*
        [
          { $match: { platform: "GBA" } },
          { $sort: { meta_score: -1 } },
          { $limit: 1 }
        ]
         */
        //listaJuegos.aggregate()
        listaJuegos.aggregate(List.of()).forEach(doc -> System.out.println(doc.toJson()));

    }

    // ¿Top 5 géneros más frecuentes en Switch?
    public void top5GenerosSwitch(MongoCollection<Document> listaJuegos){
        /*
        [
          { $match: { platform: "Switch" } },
          { $unwind: "$genres" },
          { $group: { _id: "$genres", count: { $sum: 1 } } },
          { $sort: { count: -1 } },
          { $limit: 5 }
        ]
         */
        //listaJuegos.aggregate()
        listaJuegos.aggregate(List.of()).forEach(doc -> System.out.println(doc.toJson()));

    }

    // Devuelve los desarrolladores y su nota media, ordenados de más a menos.
    public void desarrolladoresPorNotaMedia(MongoCollection<Document> listaJuegos){
        /*
        [
          { $unwind: "$developers" },
          { $group: { _id: "$developers", avgMetaScore: { $avg: "$meta_score" } } },
          { $sort: { avgMetaScore: -1 } }
        ]
         */
        //listaJuegos.aggregate()
        listaJuegos.aggregate(List.of()).forEach(doc -> System.out.println(doc.toJson()));

    }


    public static void main(String[] args) {
        String connectionString =
                "mongodb+srv://anavarroprofe96_db_user:@accesodatos.tv2ftyn.mongodb.net/?appName=AccesoDatos";
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
                MongoCollection<Document> listaJuegos = database.getCollection("games");


                // Llamadar a metodos
                // notaMaximaPorPlataforma(listaJuegos);
                // juegosPorConsola(listaJuegos);
                //notaMediaSwitch(listaJuegos);
                //top5PeoresSwitchWii(listaJuegos);
                //juegoGBAMejorNota(listaJuegos);
                //top5GenerosSwitch(listaJuegos);
                //desarrolladoresPorNotaMedia(listaJuegos);


            } catch (MongoException e) {
                e.printStackTrace();
            }
        }

    }
}
