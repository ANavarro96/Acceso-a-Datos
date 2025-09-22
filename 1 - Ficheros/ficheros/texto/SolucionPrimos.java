package ficheros.texto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SolucionPrimos {

    public static void main(String[] args) {
        String fichero = "primos.txt";
        try {
            ejercicio1(fichero);
            ejercicio2(fichero);
            ejercicio3(fichero);
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }


    static void ejercicio1(String nombreFichero) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, false));

            for (int n = 2; n <= 500; n++) {
                if (esPrimo(n)) {
                    bw.write(Integer.toString(n));
                    bw.newLine();
                }
            }
        bw.close();
    }


    static void ejercicio2(String nombreFichero) throws IOException {
        // Esta estructura de meter el reader en un try se llama try-with-resources.
        // Cerrará el reader automáticamente al salir del bloque try.
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }


    static void ejercicio3(String nombreFichero) throws IOException {
        int total = 0;
        int numeroDeLinea = 0;


        BufferedReader br = new BufferedReader(new FileReader(nombreFichero));

            String linea;
            while ((linea = br.readLine()) != null) {
                numeroDeLinea++;


                int valor = Integer.parseInt(linea);
                if (numeroDeLinea % 2 == 0) {
                        total += valor;
                } else {
                        total -= valor;
                }

        }
        br.close();

        // Aquí os dejo otro try-with-resources
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, true))) {
            bw.write("RESULTADO: " + total);
            bw.newLine();
        }
    }

    static boolean esPrimo(int n) {
        for (int i = 2; i <= (n/2); i ++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
