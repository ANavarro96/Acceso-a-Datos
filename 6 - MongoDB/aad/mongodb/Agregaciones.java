package aad.mongodb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.BsonField;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

public class Agregaciones {
	
	public static void maxYMin(MongoCollection<Document> zips) {
	
		AggregateIterable<Document> maxr = zips.aggregate(
                Arrays.asList(
                        Aggregates.group(null, 
                        		Accumulators.max("max_poblacion", "$pop"),
                        		Accumulators.min("min_pop", "$pop"))));
		
		
		
		for(Document d:maxr) System.out.println(d.toJson());
		
		
	}
	
	public static void mediaPopPorEstado(MongoCollection<Document> zips) {
		
		AggregateIterable<Document> maxr = zips.aggregate(
                Arrays.asList(
                        Aggregates.group("$state", 
                        		Accumulators.max("media_pob", "$pop"))));
		
		for(Document d:maxr) System.out.println(d.toJson());
		
		
	}
	
	public static void menosPopuladasCA(MongoCollection<Document> zips) {
		
		 	Bson match = Aggregates.match(Filters.and(Filters.eq("state", "CA"),Filters.gt("pop",0)));
		 	Bson group = Aggregates.group("$city", Accumulators.sum("poblacion_total", "$pop"));
	        Bson project = Aggregates.project(Projections.fields(Projections.excludeId(), Projections.include("poblacion_total"), Projections.computed("city", "$_id")));
	        Bson sort = Aggregates.sort(Sorts.ascending("poblacion_total"));
	        Bson limit = Aggregates.limit(5);
	        
	        AggregateIterable<Document> resultado = zips.aggregate(Arrays.asList(match,group,project,sort,limit));
	        
	        for(Document d: resultado) System.out.println(d.toJson());
	        
	        
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Abrimos colección con el servidor de Mongo
    	MongoClient mongoClient = new MongoClient();
    	
    	
    	// Nos conectamos (o creamos) una BBDD llamada Felinos
    	MongoDatabase database = mongoClient.getDatabase("prueba");
    	
    	// Nos conectamos (o creamos) a una colección (o tabla)  llamada gatitos
    	MongoCollection<Document> zips = database.getCollection("zips");
    	
    	//maxYMin(zips);
    	//mediaPopPorEstado(zips);
    	menosPopuladasCA(zips);
    	
    	mongoClient.close();
    	

	}

}
