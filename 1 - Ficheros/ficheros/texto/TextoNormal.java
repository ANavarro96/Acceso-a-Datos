package ficheros.texto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextoNormal {

    public static void leerFicheroReader(String fichero){

        try {
            BufferedReader lector = new BufferedReader(new FileReader(fichero));

            String frase = lector.readLine();

            while(frase != null) {
                System.out.println(frase.contains("Butters"));
                frase = lector.readLine();
            }

            lector.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        leerFicheroReader("resources/ficheros/southpark.txt");
    }
}
