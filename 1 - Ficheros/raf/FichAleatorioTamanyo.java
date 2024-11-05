package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FichAleatorioTamanyo {
    static ArrayList<String> peliculas = new ArrayList<>();
    static  ArrayList<Long> ganancias = new ArrayList<>();

    static ArrayList<Integer> premios = new ArrayList<>();

    static final int TAMANYO = (17) + 4 + 8;

    public static void main(String[] args) {
        // ArrayList de String: Películas en las que ha participado un famoso
        peliculas.add("Inception");
        peliculas.add("Titanic");
        peliculas.add("The Revenant");
        peliculas.add("Shutter Island");
        peliculas.add("Catch Me If You Can");
        peliculas.add("Django Unchained");
        peliculas.add("The Great Gatsby");
        peliculas.add("The Wolf of Wall Street");
        peliculas.add("Once Upon a Time in Hollywood");
        peliculas.add("Gangs of New York");

        // ArrayList de Long: Ganancias anuales en millones de dólares (estimación)
        ganancias.add(30000000L);
        ganancias.add(25000000L);
        ganancias.add(20000000L);
        ganancias.add(35000000L);
        ganancias.add(40000000L);
        ganancias.add(15000000L);
        ganancias.add(45000000L);
        ganancias.add(32000000L);
        ganancias.add(28000000L);
        ganancias.add(50000000L);

        // ArrayList de Integer: Cantidad de premios ganados en diferentes años
        premios.add(3);
        premios.add(2);
        premios.add(1);
        premios.add(4);
        premios.add(5);
        premios.add(1);
        premios.add(3);
        premios.add(2);
        premios.add(4);
        premios.add(6);


        try {
            RandomAccessFile fichero = new RandomAccessFile("resources/ficheros/raf.dat","rw");

            crearFichero(fichero);
            leerFichero(fichero);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void crearFichero(RandomAccessFile fichero) throws IOException {
        for(int i = 0; i< 10; i++){
           StringBuilder sb =  new StringBuilder(peliculas.get(i));
           sb.setLength(15);
            fichero.writeUTF(sb.toString());
            fichero.writeInt(premios.get(i));
            fichero.writeLong(ganancias.get(i));
        }
    }


    public static void leerFichero(RandomAccessFile fichero) throws IOException {
        System.out.println(fichero.length()/TAMANYO);
        fichero.seek(0);
        for(int i = 0; i< (fichero.length()/TAMANYO); i++){
            System.out.println(i);
            System.out.println(fichero.readUTF());
            System.out.println(fichero.readInt());
            System.out.println(fichero.readLong());
        }
    }

}
