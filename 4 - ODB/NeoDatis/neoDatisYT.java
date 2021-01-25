package NeoDatis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IValuesQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;
import org.neodatis.odb.tutorial.Player;

import youtube.Video;
import youtube.Youtuber;

public class neoDatisYT {

	public static void poblarTablas(ODB odb) {
		ArrayList<Video> videosPwdie = new ArrayList<>();
		Video v1 = new Video("Bitch Lasagna", 265, new Date(), 100, 55);
		Video v2 = new Video("Minecraft", 1349, new Date(), 22, 66);
		videosPwdie.add(v1);videosPwdie.add(v2);
		
		ArrayList<Video> videos98 = new ArrayList<>();
		Video v3 = new Video("If Minecraft was made in 1998", 11, null, 100, 55);
		Video v4 = new Video("If Grand Theft Auto V was made in 1998", 22, null, 22, 66);
		videos98.add(v3);videos98.add(v4);
		
		
		Youtuber pdp = new Youtuber("Pewdiepie", "Felix", 31, videosPwdie);
		Youtuber demake = new Youtuber("98Demake", "pepon", 22, videos98);
		
		odb.store(v1);odb.store(v2);odb.store(v3);odb.store(v4);
		odb.store(pdp);odb.store(demake);
		
	}
	
public static void obtenerInfoCuantitativa(ODB odb) {
		
		// Se utiliza la clase valuesQuery para establecer las funciones de agregación a usar
		// Primero se pone la clase asociada, y después todas las operaciones
		IValuesQuery valuesQuery = new ValuesCriteriaQuery(Video.class).
				count("titulo").sum("visitas","suma").avg("likes","media_likes").max("dislikes", "max_dislikes");
		
		// En este caso , la query devuelve un objeto de tipo Values, los cuales se obtienen mediante la op getFirst()
		Values values = odb.getValues(valuesQuery);
		ObjectValues v = values.getFirst();
		// Una vez tenemos los valores, obtenemos la info llamando a la función getByAlias.
		System.out.println("Hay un numero: " +  v.getByAlias("titulo") + " de videos, la suma total de "
				+ "visitas es :" + v.getByAlias("suma") + " la media de likes es: " + v.getByAlias("media_likes")
				+ " el mayor número de dislikes es:" + v.getByAlias("max_dislikes"));
		
	}

public static void obtenerInfoAgrupacion(ODB odb) {
	
	// Se utiliza la clase valuesQuery para establecer las funciones de agregación a usar
	// Primero se pone la clase asociada, y después todas las operaciones
	IValuesQuery valuesQuery = new ValuesCriteriaQuery(Video.class).
			field("likes").sum("visitas","suma").avg("dislikes", "max_dislikes").groupBy("likes");
	
	
	Values values = odb.getValues(valuesQuery);
	ObjectValues v;
	// Aquí, como hemos agrupado, hay más de un registro a devolver.
	// Iteramos sobre el objeto Vaues (como si fuetra un cursor) utilizando como condición
	// el método hasNext()
	while(values.hasNext()) {
	// Una vez tenemos los valores, obtenemos la info llamando a la función getByAlias.
		v = values.nextValues();
		System.out.println("Los videos que tienen " + v.getByAlias("likes") + " likes tienen  la suma total de "
			+ "visitas es :" + v.getByAlias("suma") + " el mayor número de dislikes es:" + v.getByAlias("max_dislikes"));
	
	}
}


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Creamos la conexión con el objeto ODBFactory, el cual necesita que le pases
		 * la ruta al fichero
		 */
		ODB odb = ODBFactory.open("resources/youtube.neodatis");

		//obtenerInfoCuantitativa(odb);
		
		
		obtenerInfoAgrupacion(odb);
		/* Como siempre, hay que cerrar la conexión*/
		odb.close();
	}

}
