package aad.mongodb.clase2026;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.List;

public class EjemplosAggregationPipeline {

    // sacar nota máxima de los juegos según su plataforma
    public static void notaMaximaPorPlataforma(MongoCollection<Document> listaJuegos){

        Bson agrupar = Aggregates.group("$platform",
                Accumulators.max("nota_Maxima","$meta_score"));

        Bson ordenar = Aggregates.sort(Sorts.ascending("nota_Maxima"));

        listaJuegos.aggregate(List.of(agrupar, ordenar)).forEach(doc -> System.out.println(doc.toJson()));

    }

    // ¿cuantos juegos hay por consola? De más a menos
    public static void juegosPorConsola(MongoCollection<Document> listaJuegos){

        Bson agrupar = Aggregates.group("$platform",
                Accumulators.sum("Num_Juegos", 1));

        Bson ordenar = Aggregates.sort(Sorts.descending("Num_Juegos"));

        listaJuegos.aggregate(List.of(agrupar, ordenar )).forEach(doc -> System.out.println(doc.toJson()));;

    }

    // sacar nota media de los juegos de switch

    public void notaMediaSwitch(MongoCollection<Document> listaJuegos){
        Bson notamedia = Aggregates.match(Filters.eq("platform","Switch" ));
        Bson agrupar = Aggregates.group("$platform",
                Accumulators.avg("nota_meda", "$meta_score"));


        listaJuegos.aggregate(List.of(notamedia, agrupar)).forEach(doc -> System.out.println(doc.toJson()));

    }

    // Sacar top 5 peores juegos de Switch o de Wii, ordenados por meta_score ascendente
    public void top5PeoresSwitchWii(MongoCollection<Document> listaJuegos){

       // listaJuegos.aggregate()
        //listaJuegos.aggregate(List.of()).forEach(doc -> System.out.println(doc.toJson()));

    }
    // sacar el juego (o juegos) de la GBA que tenga(n) la menor nota en meta_score
    // Este ejemplo en dos partes.
    public static void juegoGBAMejorNota(MongoCollection<Document> listaJuegos){

        Bson notamax = Aggregates.match(Filters.eq("platform","GBA" ));
        Bson agrupar = Aggregates.group("$platform",
                Accumulators.max("max", "$meta_score"));

        int notaMax = listaJuegos.aggregate(List.of(notamax, agrupar)).first().getInteger("max");

        listaJuegos.find(Filters.and(Filters.eq("meta_score", notaMax)
                , Filters.eq("platform", "GBA"))).forEach(System.out::println);
    }

    // ¿Top 5 géneros más frecuentes en Switch?
    public static void top5GenerosSwitch(MongoCollection<Document> listaJuegos){

        Bson listaD = Aggregates.unwind("$genres");
        Bson grupo = Aggregates.group("$genres",Accumulators.sum("Top-generos",1));
        Bson sort = Aggregates.sort(Sorts.descending("Top-generos"));
        Bson limit = Aggregates.limit(5);
        listaJuegos.aggregate(List.of(listaD,grupo,sort,limit)).forEach(doc -> System.out.println(doc.toJson()));

    }

    // Devuelve los desarrolladores y su nota media, ordenados de más a menos.
    public void desarrolladoresPorNotaMedia(MongoCollection<Document> listaJuegos){

        //listaJuegos.aggregate()
        listaJuegos.aggregate(List.of()).forEach(doc -> System.out.println(doc.toJson()));

    }


    public static void main(String[] args) {
        String connectionString =
                "mongodb+srv://anavarroprofe96_db_user:vuestro_pass@accesodatos.tv2ftyn.mongodb.net/?appName=AccesoDatos";
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
                
                System.out.println("----- NOTA MAXIMA POR PLATAFORMA -----");
                notaMaximaPorPlataforma(listaJuegos);
                System.out.println("----- JUEGOS POR CONSOLA -----");
                juegosPorConsola(listaJuegos);
                System.out.println("----- NOTA MEDIA SWITCH -----");
                //notaMediaSwitch(listaJuegos);
                System.out.println("----- TOP 5 PEORES JUEGOS SWITCH/WII -----");
                //top5PeoresSwitchWii(listaJuegos);
                System.out.println("----- JUEGO GBA MEJOR NOTA -----");
                juegoGBAMejorNota(listaJuegos);
                System.out.println("----- TOP 5 GENEROS SWITCH -----");
                top5GenerosSwitch(listaJuegos);
                System.out.println("----- DESARROLLADORES POR NOTA MEDIA -----");
                //desarrolladoresPorNotaMedia(listaJuegos);


            } catch (MongoException e) {
                e.printStackTrace();
            }
        }

    }
}
