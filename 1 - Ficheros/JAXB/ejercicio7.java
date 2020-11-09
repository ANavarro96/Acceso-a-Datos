package JAXB;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ejercicio7 {

	public static void escribirMisLibros(File fichero) throws JAXBException {
		
		Libros misLibros = new Libros();
		
		JAXB.Libros.Libro libroRubius = new JAXB.Libros.Libro();
		libroRubius.setAutor("El Rubius");
		libroRubius.setEditorial("Nose");
		libroRubius.setTitulo("El libro Troll del Rubius");
		libroRubius.setPublicadoEn("2013");
		
		misLibros.getLibro().add(libroRubius);
		
		// Crear objeto clase JAXBContext
		JAXBContext contexto;
		// Le decimos al contexto que busce y enganche con objetos de la clase 'Libros'
		contexto = JAXBContext.newInstance(Libros.class);
		
		// Serializar (o transformar) de Java a XML
		Marshaller m = contexto.createMarshaller();
		
		// El método marshall pide el primer objeto que se quiere
		// serializar, y el fichero donde se va a hacer
		m.marshal(misLibros, fichero);
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fichero = new File("MisLibros.xml");
		try {
			escribirMisLibros(fichero);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al abrir el fichero con JAXB");
			e.printStackTrace();
		}
	}

}
