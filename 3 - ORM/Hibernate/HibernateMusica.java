package Hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import resources.Album;
import resources.Artista;
import resources.Cancion;
import resources.Discografica;

public class HibernateMusica {

	/*
	 * Funcion que recibe como par�metro un objeto Session y un nuevo objeto de tipo Discografica
	 * Crea el nuevo objeto persistente.
	 */
	public static void persistirDiscografica(Session sesion,Discografica d) {
		sesion.save(d);	
	}
	
	/*
	 * Funcion que recibe como par�metro un objeto Session y el Id de la discografia a obtener
	 * Devuelve un objeto de tipo Discografica
	 */
	public static Discografica obtenerDiscografia(Session sesion,int id) {
		return sesion.get(Discografica.class, id);
	}
	
	
	/*
	 * Funcion que recibe como par�metro un objeto Session y el Id de la discografia a modificar
	 * Recupera el objeto persistente, modifica su nombre y actualiza los cambios
	 */
	public static void ModificarNombreDiscografica(Session sesion,int id) {
		Discografica d =  sesion.get(Discografica.class, id);
		
		d.setName("Maldito Records");
		
		sesion.save(d);
	}
	
	/*
	 * Funcion que recibe como par�metro un objeto Session y el Id de la discografia a borrar
	 * Recupera el objeto persistente, lo borra y actualiza los cambios
	 */
	public static void BorrarDiscografica(Session sesion,int id) {
		Discografica d =  sesion.get(Discografica.class, id);
		
		d.setName("Maldito Records");
		
		sesion.delete(d);
		
	}
	
	
	

	/*
	 * Funcion que realiza una consulta HQL, la cual devuelve todos los artistas.
	 */
	public static List<Artista> ObtenerTodosArtistas(Session sesion) {
		Query query = sesion.createQuery("from Artista");
		
		return query.list();
	}
	
	/*
	 * Funcion que permite imprimir por pantalla una lista de artistas
	 */
	public static void imprimirTodosArtistas(Session sesion,List<Artista> ListaArtistas) {
		
		System.out.println("Lista de todos los artistas");
		System.out.println("/**************************/");
		for(Artista a: ListaArtistas) {
			System.out.print(a.getId() + " " +  a.getName() + '\n');
			/*
			 * Como la relaci�n entre  Discografica - modelo.Artista  es 1 - N podemos sacar la informaci�n de cada Discogr�fica!!
			 * Se interpreta como un propio OBJETO!
			 */
			System.out.println("Informaci�n de la discogr�fica asociada a " + a.getName());
			System.out.print(a.getDiscografica().getName() + ' ' + a.getDiscografica().getId());
			System.out.println();
		}
	}
	
	
	/*
	 * Funcion que realiza una consulta HQL, la cual devuelve todos los Albumes.
	 */
	public static List<Album> ObtenerTodosAlbumes(Session sesion) {
		Query query = sesion.createQuery("from Album");
		
		return query.list();
	}
	
	
	
	/*
	 * Funcion que permite imprimir por pantalla una lista de albums
	 */
	public static void imprimirAlbum(Session sesion,List<Album> listaAlbums) {
		
		System.out.println("Lista de todos los albumes y sus canciones");
		System.out.println("/**************************/");
		for(Album a: listaAlbums) {
			System.out.print(a.getId() + " " +  a.getName() + '\n');
			/*
			 * Como la relaci�n entre  Album - Cancion  es 1 - N podemos sacar la informaci�n de cada Cancion!!
			 * Se interpreta como un Set de Cancion.
			 * Un objeto de tipo Set es parecido a un List o ArrayList, y se itera con la ayuda
			 * de un objeto Iterator.
			 * Un objeto Iterator sirve para pasar por todos los elementos de una lista, ya sea un Set, List o ArrayList.
			 * Los bucles con un Iterator siempre tienen la misma estructura:
			 * 	while(iterator.hasNext()){
			 * 	iterator.next() (esto saca el elemento actual de la lista, empezando por 0 , 1 ...)
			 * }
			 * 
			 * Aunque yo prefiero usando un bucle For mejorado (https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
			 */
			Set<Cancion> listaCanciones = a.getCancions();
			Iterator i = listaCanciones.iterator();
			System.out.println("Lista de canciones del disco " + a.getName()+ " del artista: " + a.getArtista().getName() );
			
			while (i.hasNext()) {
				Cancion c = (Cancion) i.next();
				System.out.print(c.getName() + " " +  c.getDuration());
				System.out.println();
				
			}
			/*
			 *  Con un bucle for mejorado ser�a
			 *  for(Cancion c : listaCanciones){
			 *   hacer lo que sea
			 *   Tenemos cada Canciones de la lista en c, ya lo he usado en alg�n otro ejemplo
			 *  }
			 * 
			 */

			
			
		}
	}
	
	
	/*
	 * Funcion que obtiene una lista de albumes del grupo The Wonder Years
	 */
	public static List<Album> ObtenerAlbumsTWY(Session sesion) {
		//Query query = sesion.createQuery("from Album where artista.name = :nombre");
		Query query = sesion.createQuery("select album from Album album, Artista artista where artista.id = album.artista.id and artista.name = :nombre");
		query.setParameter("nombre", "The Wonder Years");
		return query.list();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * La llamada a Configuration().configure() carga el fichero de configuraci�n hibernate.cfg.xml e
			inicializa el entorno de Hibernate. 
			Hay que ponerlo en la carpeta raiz, dentro de una subcarpeta llamada resources, si no por defecto
			Hibernate espera que est� dentro de la carpeta 'src'
		 * 
		 */
		
		Configuration cfg = new Configuration().configure("resources/hibernate.cfg.xml");
		
		/*
		 * Una vez inicializada la configuraci�n, se crea el ejemplar de
			SessionFactory, que normalmente solo se crea una vez y se utiliza para crear todas las
			sesiones relacionadas con un contexto dado.
		 */
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		/*
		 * Un objeto Session de Hibernate representa una �nica unidad de trabajo, una conexi�n para un almac�n de
		 *	datos dado , abierto por un SessionFactory
		 */
		Session session = sessionFactory.openSession();
		
		
		
		/*
		 * Creamos una transacci�n, con el m�todo beginTransacition comenzamos una en nuestra sesi�n
		 */
		Transaction tx = session.beginTransaction();
		
		
		/*
		 * Cualquier tipo de l�gica
		 * 
		 */
		
		persistirDiscografica(session, new Discografica("Hope Records"));
		
		/*imprimirAlbum(session, ObtenerAlbumsTWY(session));
		
		Query query = session.createQuery("from modelo.Artista");
		List<modelo.Artista> listaArtista = query.list();
		
		for (modelo.Artista a: listaArtista) {
			System.out.println(a.getName());
			System.out.println(a.getId());
			
		}*/
		
		/* Hacer commit de los cambios */
		tx.commit();
		/* Cerrar sesi�n */
		session.close();
		
		

		
		
	}

}
