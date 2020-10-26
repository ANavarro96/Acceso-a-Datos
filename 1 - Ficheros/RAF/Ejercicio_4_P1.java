package generated;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio_4_P1 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		
		String nombre = null;
		String localidad = null;
		String respuesta = null;
		StringBuffer buffer = null;
		
		try {
			// sE CREA la variable RandomAccessFile
			RandomAccessFile fichero = new RandomAccessFile("departamento.dat","rw");
			System.out.println("¿Quieres introducir un nuevo departamento?");
			respuesta = teclado.nextLine();
			
			// Calculamos el número de departamentos -> Tamaño del fichero/Tamaño en bytes del objeto que se guarda
			int numeroDeDepartamentos = (int) (fichero.length()/74);
			
			// Nos vamos al final
			fichero.seek(fichero.length());
			
			// Escribe en el fichero
			
			while (!respuesta.equals("FIN")) {
				
				System.out.println("Introduce el nombre");
				nombre = teclado.nextLine();
				System.out.println("Introduce la localidad");
				localidad = teclado.nextLine();
				
				numeroDeDepartamentos++;
				// Escribimos un entero
				fichero.writeInt(numeroDeDepartamentos);
				
				// Escribimos Un string de 15
				buffer = new StringBuffer(nombre);
				buffer.setLength(15);
				fichero.writeChars(buffer.toString());
				
				// Escribimos Un string de 20
				buffer = new StringBuffer(localidad);
				buffer.setLength(20);
				fichero.writeChars(buffer.toString());
				
				// Continuamos el bucle
				System.out.println("¿Quieres introducir un nuevo departamento?");
				respuesta = teclado.nextLine();
				
			}
			
			// Leer del fichero
			fichero.seek(0);
			String nombreLeido = "";
			String LocalidadLeida = "";
			
			for (int i = 0; i < numeroDeDepartamentos;i++) {
				
				// Leemos un entero
				System.out.println(fichero.readInt());
				
				// Leemos los 15 caracteres que forman el nombre
				for (int j = 0; j < 15; j++) {
					nombreLeido += fichero.readChar(); 
				}
				System.out.println(nombreLeido);
				
				// Leemos los 20 caracteres que forman la localidad
				for (int k = 0; k < 20; k++) {
					LocalidadLeida += fichero.readChar(); 
				}
				System.out.println(LocalidadLeida);
				
				// Borramos los string de nombreLeido y LocalidadLeida
				nombreLeido = "";LocalidadLeida="";
					
			}
			
	
		fichero.close();
			
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el fichero!!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
