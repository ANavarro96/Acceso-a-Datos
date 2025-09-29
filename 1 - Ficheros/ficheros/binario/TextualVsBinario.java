package ficheros.binario;

import java.io.*;
import java.util.ArrayList;

public class TextualVsBinario {

    private final String FICHERO_BINARIO = "humanos.dat";
    
    public static class Humano {
        String nombre;
        int anyoNacimiento;

        public Humano(String nombre, int anyoNacimiento) {
            this.nombre = nombre;
            this.anyoNacimiento = anyoNacimiento;
        }
    }

    // Leer un fichero textual
    public static void leerTextual(String rutaFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Escribir en un fichero textual
    public static void escribirTextual(String rutaFichero, String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFichero))) {
            bw.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Escribir datos binarios
    public static void escribirBinario(String rutaFichero, ArrayList<Humano> humanos) {
        /* TODO */

    }


    // Leer datos binarios
    public static void leerBinario(String rutaFichero) {
              /*TODO*/
    }

    public static void main(String args[])  {

        // Con estas clases escribiremos datos en binario

        ArrayList<Humano> humanos = new ArrayList<>();
        humanos.add(new Humano("Ana", 1990));
        humanos.add(new Humano("Luis", 1985));
        humanos.add(new Humano("Marta", 2000));




        // Con estas clases leeremos de los datos en binario




    }


}
