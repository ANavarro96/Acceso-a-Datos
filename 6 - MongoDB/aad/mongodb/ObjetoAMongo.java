package aad.mongodb;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.Mongo;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.BsonField;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;

public class ObjetoAMongo {
	
	public static void anyadirCurso(MongoCollection<Curso> cursos) {
		Curso daw = new Curso("DAW",10,null);
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos.add(new Alumno("Mario", 23, 7));
		alumnos.add(new Alumno("Luigi", 28, 8.5));
		alumnos.add(new Alumno("Waluigi", 68, 4.99));
		Curso dam = new Curso("DAM",10,alumnos);
		
		Curso asir = new Curso("ASIR",5,null);
		
		cursos.insertOne(daw);
		cursos.insertOne(dam);
		cursos.insertOne(asir);
		
	}
	
	public static void borrarCurso(MongoCollection<Curso> cursos) {
		
		cursos.deleteMany(Filters.or(Filters.lt("alumnos",10),Filters.eq("alumnos.nombre","Waluigi")));		    
		
	}
	
	public static void ModificarAlumno(MongoCollection<Curso> cursos) {
		Document nuevoAlumno = new Document("nombre","Yoshi")
				.append("edad", 10).append("media", 6.7);
		
		cursos.updateMany(Filters.eq("lista_alumnos.nombre","Waluigi"),Updates.push("lista_alumnos",nuevoAlumno));		
		cursos.updateOne(Filters.eq("lista_alumnos.nombre","Waluigi"), Updates.pull("lista_alumnos", new Alumno("Waluigi", 68, 4.99)));
		
	}

	public static void main(String[] args) {
		
		
		CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                                                                .codecRegistry(codecRegistry)
                                                                .build();
        
        MongoClient mongoClient = MongoClients.create(clientSettings);
        
        MongoDatabase db = mongoClient.getDatabase("instituto");
        MongoCollection<Curso> cursos = db.getCollection("cursos", Curso.class);
		// Abrimos colección con el servidor de Mongo
        //anyadirCurso(cursos);
        
        ModificarAlumno(cursos);
        
        for(Curso c : cursos.find()) System.out.println(c.toString());        
        //cursos.deleteMany(new Document());
        mongoClient.close();
        
    	
	}

}
