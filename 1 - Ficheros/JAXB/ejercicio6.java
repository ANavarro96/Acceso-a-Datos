package JAXB;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ejercicio6 {

	public static void leerXML(File fichero) throws JAXBException {
		
		// Crear objeto clase JAXBContext
		JAXBContext contexto;
		// Le decimos al contexto que busce y enganche con objetos de la clase 'Libros'
		contexto = JAXBContext.newInstance(Libros.class);
		
		// Utilizar el objeto unmarshalling, o el des-serializador
		Unmarshaller u = contexto.createUnmarshaller();
		
		Libros misLibros;
		// Des-serializo los 'Libros' de mi fichero XML
		misLibros = (Libros) u.unmarshal(fichero);
		
		
		List<Libros.Libro> listaLibro = misLibros.getLibro();
		System.out.println("LIBROS LEIDOS");
		System.out.println("------------------");
		for(int i=0;i< listaLibro.size();i++) {
			System.out.println(listaLibro.get(i).getAutor());
			System.out.println(listaLibro.get(i).getEditorial());
			System.out.println(listaLibro.get(i).getPublicadoEn());
			System.out.println(listaLibro.get(i).getTitulo());
		}
		System.out.println("FIN LISTA DE LIBROS");
		System.out.println("------------------");
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ficheroXML = new File("LibrosXML.xml");
			try {
				leerXML(ficheroXML);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al abrir el fichero con JAXB");
				e.printStackTrace();
			}


	}

}
