package DOM_XML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class MusicoXML {



	/*	
	 * Este programa lo que hace es implementar dos funciones, con las cuales se leen y escriben Musicos en un fichero
	 * XML, utilizando la API de DOM
	 */

			/*
			 * Escribe en un fichero XML el contenido de la lista que se le pasa como parámetro
			 */
			public void escribirXML(ArrayList<Musico> listaMusicos) {
				// Creamos el DocumentBuilderFactory, que es el objeto que crea objetos de clase DocumentBuilder
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				Document documento = null;
				
				try {
					// Creamos un documentBuilder utilizando la factory
					DocumentBuilder builder = factory.newDocumentBuilder();
					
					// Creamos nuestro árbol DOM, en este caso vacío
					DOMImplementation dom = builder.getDOMImplementation();
					
					// Ahora hacemos que nuestro árbol apunte a un documento.
					// El primer parámetro representa el namespace del fichero, dejarlo a null
					// El segundo es nuestro elemento raíz 
					// El tercero es el tipo de elemento, dejarlo a null
					
					documento = dom.createDocument(null,  "Musicos", null);
					
					// Con getDocumentElement() accedemos al elemento raíz
					
					Element raiz = documento.getDocumentElement();
					
					/*
					 * En DOM vamos a trabajar con diversos elementos:
					 * Element: Corresponde a cada elemento (marcas) del documento
					 * Node: Corresponde a cualquier componente del documento, puede ser textual, un elemento, un atributo...
					 * Text: Se recfiere al texto que hay dentro de cada elemento
					 */
					Element nodoMusico = null, nodoDatos = null;
				
					Text texto = null;
					
				
					
					// Ahora, por cada Musico de nuestro arrayList que nos envían por parámetro
					for (Musico Musico : listaMusicos) {
					
						//Creamos un elemento Musico y lo añadimos a la raiz
						nodoMusico = documento.createElement("Musico");
						raiz.appendChild(nodoMusico);
						
						//Si qusieramos añadir un ATRIBUTO, se haría así (es un ejemplo) :
						//nodoMusico.setAttribute("Discografica", "Hopeless Records");
						
						// Creamos un elemento nombre y lo añadimos al elemento Musico
						nodoDatos = documento.createElement("nombre");
						nodoMusico.appendChild(nodoDatos);
						
						texto = documento.createTextNode(Musico.getNombre());
						nodoDatos.appendChild(texto);
						
						// Creamos un elemento año_formacion y lo añadimos al elemento Musico
						nodoDatos = documento.createElement("año_formacion");
						nodoMusico.appendChild(nodoDatos);
						
						texto = documento.createTextNode(String.valueOf(Musico.getFormacion()));
						nodoDatos.appendChild(texto);
						
						
						// Creamos un elemento genero y lo añadimos al elemento Musico
						nodoDatos = documento.createElement("genero");
						nodoMusico.appendChild(nodoDatos);
						
						texto = documento.createTextNode(Musico.getGenero());
						nodoDatos.appendChild(texto);
					}
					
					// Una vez tenemos nuestro árbol DOM creado, hay que tranformarlo a nuestro fichero XML
					
					
					
					/* La clase Transformer de Java es una clase muy potente, que permite transformar
						elementos de un tipo de datos a otro: DOM a texto, DOM a String, DOM a binario...
						Este año sólo pasaremos de DOM a texto, y se hace con estos métodos.
						
						Dicha clase necesita dos parámetros, uno de tipo Source, y otro de tipo Result.
					 */
					
					
					
					

					Source source = new DOMSource(documento);
					Result resultado = new StreamResult(new File("GruposMusica.xml"));
					
					// Transformer funciona igual que Document, necesitamos una "fábrica" que cree
					// objetos de tipo Transformer, pero aquí lo simplifico un poco más
					
					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					transformer.transform(source, resultado);
					
				} catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				} catch (TransformerConfigurationException tce) {
					tce.printStackTrace();
				} catch (TransformerException te) {
					te.printStackTrace();
				}
			}
			
			/*
			 * Lee un fichero XML y muestra el contenido por pantalla
			 */
			public void leerFicheroXML() {
				
				// Creamos el DocumentBuilderFactory, que es el objeto que crea objetos de clase DocumentBuilder
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				Document documento = null;
				
				try {
					
					// Creamos un documentBuilder utilizando la factory
					DocumentBuilder builder = factory.newDocumentBuilder();
					
					/*
					 * Ahora no tenemos que crear un documento, si no leer de un fichero.
					 * Eso se consigue con el método parse
					 */
					documento = builder.parse(new File("GruposMusica.xml"));
					
				
					/*
					 * El método getElementsByTagName lo que devuelve es todos aquellos elementos que
					 * se llamen como el String que se pasa por parámetro.
					 * En este caso, no queremos coger el nodo raíz, si no todos los hijos.
					 */
					NodeList Musicos = documento.getElementsByTagName("Musico");
					for (int i = 0; i < Musicos.getLength(); i++) {
						Node Musico = Musicos.item(i);
						// Siempre que se lee de un DOM hay que comprobar que es de tipo ELEMENT_NODE
						// y que no es un espacio, un comentario, algún error humano...
						if(Musico.getNodeType() == Node.ELEMENT_NODE) {
						// El método item(0) nos devolverá el nodo de la lista
						
						
						/*
						 * Como tenemos guardado un objeto de tipo Node, lo podemos especificar
						 * creando una variable de tipo Element
						 */
						
						
						Element elemento = (Element) Musico;

						
						System.out.print(elemento.getElementsByTagName("nombre").item(0).getTextContent());
						System.out.print(" ");
						System.out.print(elemento.getElementsByTagName("año_formacion").item(0).getTextContent());
						System.out.print(" ");
						System.out.print(elemento.getElementsByTagName("genero").item(0).getTextContent());
						System.out.println();
						/*
						 * Para obtener los atributos, se tendría que ejecutar algo así
						 *  elemento.getAttribute("Discografica");
						 */
						}
					}
					
				} catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} catch (SAXException saxe) {
					saxe.printStackTrace();
				}
			}
			
			public static void main(String args[]) {
				
				ArrayList<Musico> listaMusicos = null;
				
				Musico Musico1 = new Musico("The Wonder Years", 2005,"Punk-Pop");
				Musico Musico2 = new Musico("La Polla Records", 1980, "Punk");
				Musico Musico3 = new Musico("Phoebe Bridgers", 2012, "Indie-folk");
				
				listaMusicos = new ArrayList<Musico>();
				listaMusicos.add(Musico1);
				listaMusicos.add(Musico2);
				listaMusicos.add(Musico3);
				
				MusicoXML principal = new MusicoXML();
				principal.escribirXML(listaMusicos);
				principal.leerFicheroXML();
			}
	}


