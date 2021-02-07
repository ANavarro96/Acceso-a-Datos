package NeoDatis;

import java.util.ArrayList;
import java.util.Date;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.oid.OIDFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.IValuesQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;
import org.neodatis.odb.tutorial.Game;
import org.neodatis.odb.tutorial.Player;
import org.neodatis.odb.tutorial.Sport;
import org.neodatis.odb.tutorial.Team;

public class neodatis {

	
	
	public static void leerJugadores(ODB odb) {
		/* Con el método getObjects() lo que se hace es obtener TODAS las instancias de los objetos
		 * de una clase. Devuelve un objeto de tipo Objects, que es muy parecido a un ArrayList
		 */
		Objects<Player> lista = odb.getObjects(Player.class);
		/*
		 * Como estas clases (del pacquete org.neodatis.odb.tutorial) han sido proporcionadas por
		 * NeoDatis, incluyen un método toString() que permite mostrar los objetos por pantalla.
		 * Voy a aprovecharme de su existencia y utilizarlo aquí
		 */
		for (Player p : lista) System.out.println("Identificador del objeto:" + odb.getObjectId(p) +
				" información del objeto: " + p.toString());
	}
	
	public static OID guardarDeporte(ODB odb, Sport deporte) {
		/*
		 * El método store(objeto) nos permite almacenar un objeto en la 
		 * BBDD, como el método save de Hibernate.
		 * Nos devuelve el OID del objeto, al giual que Hibernate nos devuelve el ID.
		 */
		return odb.store(deporte);
		
	}
	
	
	public static void borrarDeporte(ODB odb, int id) {
		/*
		 * Con el método OIDFactory().buildObjectOID podemos instanciar el objeto OID
		 * Una vez tenemos el objeto OID, podemos borrar, modificar y sacar... los objetos en la BBDD
		 */
		OID oid = new OIDFactory().buildObjectOID(id);
		
		odb.deleteObjectWithId(oid);
		
		
	}
	
	public static void leerJuegosPorEquipo(ODB odb) {
		IQuery query = new CriteriaQuery(Game.class, Where.equal("team1.name", "Aurochs"));
		/* Con el método getObjects() lo que se hace es obtener TODAS las instancias de los objetos
		 * de una clase. Devuelve un objeto de tipo Objects, que es muy parecido a un ArrayList
		 */
		Objects<Game> lista = odb.getObjects(query);
		/*
		 * Como estas clases (del pacquete org.neodatis.odb.tutorial) han sido proporcionadas por
		 * NeoDatis, incluyen un método toString() que permite mostrar los objetos por pantalla.
		 * Voy a aprovecharme de su existencia y utilizarlo aquí
		 */
		for (Game p : lista) System.out.println("Identificador del objeto:" + odb.getObjectId(p) +
				" información del objeto: " + p.toString());
		

	}
	
	
	
	public static void poblarTablas(ODB odb) {
		Sport s = new Sport("Blitzball");
		odb.store(s);
		
		Team t1 = new Team("Aurochs");
		Team t2 = new Team("Goers");
		Team t3 = new Team("Abes");
		Team t4 = new Team("Fangs");
		
		odb.store(new Game(new Date(),s,t1,t2));
		odb.store(new Game(new Date(),s,t3,t2));
		odb.store(new Game(new Date(),s,t2,t1));
		odb.store(new Game(new Date(),s,t2,t4));
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Creamos la conexión con el objeto ODBFactory, el cual necesita que le pases
		 * la ruta al fichero
		 */
		ODB odb = ODBFactory.open("resources/tutorial1.neodatis");
		
		/*
		Sport rocket = new Sport("RocketLeague");
		System.out.println("Se ha guardado el deporte:" + rocket.getName() + " con OID: " + guardarDeporte(odb, rocket));
		
		System.out.println("El deporte "  + rocket.getName() + " se le ha asignado el OID:" + odb.getObjectId(rocket));
		
		leerJugadores(odb);
		*/
		
		//poblarTablas(odb);
		
		leerJuegosPorEquipo(odb);
		

		/* Como siempre, hay que cerrar la conexión*/
		odb.close();
	}
}
