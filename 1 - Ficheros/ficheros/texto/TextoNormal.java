package ficheros.texto;

import java.io.*;

public class TextoNormal {

    public static void leerFicheroReader(String fichero){

        try {
            // Abro un canal de lectura, de línea en línea.
            BufferedReader lector = new BufferedReader(new FileReader(fichero));

            String frase = lector.readLine();

            while(frase != null) {
                // Aquí proceso el texto.
                // En este ejemplo saco el texto por pantalla, pero se podría hacer cualquier otra cosa.
                System.out.println(frase);

                // Vuelvo a leer
                frase = lector.readLine();
            }

            // IMPORTANTE CERRAR EL FLUJO DE LECTURA!!
            lector.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void escribirFicheroReader(String fichero, String fraseAEscribir){

        try {
            // Abro un canal de escritura
            // Recordad que el segundo parámetro es el modo append, a false MACHACA el fichero
            // A true empieza a escribir desde el final.
            BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero, false));

            escritor.write(fraseAEscribir);
            escritor.newLine();

            // IMPORTANTE CERRAR EL FLUJO DE ESCRITURA!!
            // Es común que se nos olvide y no se escriba nada en el fichero. :(
            escritor.close();

        } catch (FileNotFoundException e) {
            // Excepción que se lanza cuando no encuentra el fichero a escriibir, es un directorio por ejemplo.
            throw new RuntimeException(e);
        } catch (IOException e) {
            // Excepción que se lanza cuando hay un error de E/S, disco lleno, etc.
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        leerFicheroReader("resources/ficheros/southpark.txt");
    }
}
