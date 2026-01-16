package aad.mongodb.clase2026;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class EjemplosNintendo {

    /*
    1 - A todos los juegos de Switch con meta_score >= 80, añade el género "JRPG”.
    2 - A todos los juegos que sean de género contenga "Action", añade "General" permitiendo duplicados
    3 - Quita el género "3D" de todos los documentos.
    4 - Añade el campo modificadoAFechaDe (fecha actual) a todos los juegos con user_score >= 8.5.
    5 - Incrementa en +10 el campo user_score a todos los juegos cuyo título contenga "Mario" (regex i).
    6 - A todos los juegos donde developers contenga "Nintendo", añade el developer "Nintendo EPD" sin duplicados.
    7 - A todos los juegos con genres que contenga a la vez "Action" y "Fighting" añade tag="EVO".
    8 - Establece un metascore mínimo de 60.
    9 - Elimina todos los juegos con meta_score nulo y user_score nulo.
    10 - Elimina únicamente el primer juego que encuentres con esrb_rating nulo.
     */

    public static void ej1(MongoCollection<Document> listaNintendo){
        // Implementación pendiente
    }

    public static void ej2(MongoCollection<Document> listaNintendo){
        // Implementación pendiente
    }

    public static void ej3(MongoCollection<Document> listaNintendo){
        // Implementación pendiente
    }

    public static void ej4(MongoCollection<Document> listaNintendo){
        // Implementación pendiente
    }

    public static void ej5(MongoCollection<Document> listaNintendo){
        // Implementación pendiente
    }
    public static void ej6(MongoCollection<Document> listaNintendo){
        // Implementación pendiente
    }
    public static void ej7(MongoCollection<Document> listaNintendo){
        // Implementación pendiente
    }
    public static void ej8(MongoCollection<Document> listaNintendo){
        // Implementación pendiente
    }
    public static void ej9(MongoCollection<Document> listaNintendo){
        // Implementación pendiente
    }
    public static void ej10(MongoCollection<Document> listaNintendo){
        // Implementación pendiente
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
                MongoCollection<Document> listaJuegos = database.getCollection("games");

                // Llamadas a los métodos de los ejercicios
                /*ej1(listaJuegos);
                ej2(listaJuegos);
                ej3(listaJuegos);
                ej4(listaJuegos);
                ej5(listaJuegos);
                ej6(listaJuegos);
                ej7(listaJuegos);
                ej8(listaJuegos);
                ej9(listaJuegos);
                ej10(listaJuegos);*/



            } catch (MongoException e) {
                e.printStackTrace();
            }
        }

    }
}

