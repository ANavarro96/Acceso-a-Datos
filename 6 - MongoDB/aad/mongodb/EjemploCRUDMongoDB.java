package aad.mongodb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Updates;

/**
 * Hello world!
 *
 */
public class EjemploCRUDMongoDB 
{
	public static void guardarGatitos(MongoCollection<Document> gatitos) {
		ArrayList<Document> listaGatitos = new ArrayList<>();
    	
    	// Creamos los Document utilizando append y los añadimos a una lista de documentos
		
		
    	listaGatitos.add(new Document("_id",1).append("nombre", "Rayitas").append("raza", "siames"));
    	listaGatitos.add(new Document("_id",2).append("nombre", "Peludin").append("raza", "noruego"));
    	listaGatitos.add(new Document("_id",3).append("nombre", "Gordito").append("raza", "negro"));
    	
    	// Voy a hacer este gatito un poco más completo (con un objeto dentro y una lista)
    	Document direccion = new Document("calle","moraleja").append("piso", 9).append("piscina", "True").append("ciudad","Madrid");
    	
    	Document duenyo = new Document("nombre","paco").append("edad", 29).append("profesion", "Médico");
    	Document duenya = new Document("nombre","paca").append("edad", 25).append("profesion", "Juez");
    	
    	ArrayList<Document> duenyos = new ArrayList<Document>();
    	duenyos.add(duenyo);duenyos.add(duenya);
    	
    	listaGatitos.add(new Document("_id",4)
    			.append("nombre", "Guapito").append("raza", "Turco").append("direccion", direccion)
    			.append("duenyos", duenyos));
    	
    	listaGatitos.add(new Document("_id",5).append("nombre", "Rayito Mcqueen").append("raza", "siames"));
    	
    	// Guardamos todos estos gatitos en la coleccion
    	gatitos.insertMany(listaGatitos);
		
	}
	
	public static void obtenerTodosGatitos(MongoCollection<Document> gatitos){
		
		for(Document gatito:gatitos.find()) {
			System.out.println(gatito.toJson());
		};
		
	}
	
	
	public static void obtenerGatitoGuapito(MongoCollection<Document> gatitos){
		
		FindIterable<Document> lista =  gatitos.find(Filters.eq("nombre","Guapito"));
		
		for(Document gatito :lista) System.out.println(gatito.toJson());
		
	}
	
	public static void modificarUnGatito(MongoCollection<Document> gatitos){
		
		/* Otra forma directa usando el operador $set 
		Document nuevoNombre = new Document("nombre","Garfield").append("edad", 5).append("vacunado", "False");
		
		gatitos.findOneAndUpdate(Filters.eq("nombre","Rayitas"),new Document("$set",nuevoNombre)); */
		
		// Usando la clave de Java indicada
		
		gatitos.findOneAndUpdate(Filters.eq("nombre","Rayitas"),Updates.combine(Updates.set("nombre", "Garfield"),
				Updates.push("numLasanyasComidas", 10)));
		
	}
	
	public static void borrarGatitos(MongoCollection<Document> gatitos){
		
		// Con esto borraríamos TODOS los gatitos
		gatitos.deleteMany(new Document());
		
		// Con esto borraremos sólo un gato que tenga el campo "edad" (si alguno lo tiene)
		gatitos.deleteOne(Filters.exists("edad"));
		
		
		// Con esto borraremos todos los gatos cuya raza sea alguna de las que se pasan como parametro
		gatitos.deleteMany(Filters.in("raza",Arrays.asList("Persa","Bengala","Scottish")));
	}
	
public static void busquedaTextual(MongoCollection<Document> gatitos){
		
		// Creamos el índice de la clave nombre, de tipo textual, si ya existe no hace nada
		gatitos.createIndex(Indexes.text("nombre"));
		
		//En este busco aquellos gatitos que tengan en el nombre Rayito o Peludin
		//FindIterable<Document> listaGatitosIn = gatitos.find(Filters.text("Rayito Peludin"));
		
		
		// En este busco los gatitos que tengan en el nombre Rayito pero NO Peludin
		//FindIterable<Document> listaGatitosIn = gatitos.find(Filters.text("Rayito -Peludin"));
		
		
		// En este busco los gatitos que tengan en el nombre Rayito y tambien McQueen
		FindIterable<Document> listaGatitosIn = gatitos.find(Filters.text("\"Rayito\" \"McQueen\""));
		
		for(Document d: listaGatitosIn) System.out.println(d.toJson());
		
		
	}
	
	
    public static void main( String[] args )
    {
    	
    	// Abrimos colección con el servidor de Mongo
    	MongoClient mongoClient = new MongoClient();
    	
    	
    	// Nos conectamos (o creamos) una BBDD llamada Felinos
    	MongoDatabase database = mongoClient.getDatabase("Felinos");
    	
    	// Nos conectamos (o creamos) a una colección (o tabla)  llamada gatitos
    	MongoCollection<Document> gatitos = database.getCollection("gatitos");
    	
    	guardarGatitos(gatitos);
    	//modificarUnGatito(gatitos);
    	//borrarGatitos(gatitos);
    	//obtenerGatitoGuapito(gatitos);
    	busquedaTextual(gatitos);
    	
    	//gatitos.drop();
    	// Cerramos conexión
    	mongoClient.close();
    	
    }
}
