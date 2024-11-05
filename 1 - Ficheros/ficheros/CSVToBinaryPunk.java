package ficheros;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CSVToBinaryPunk {



    public static Song procesarLinea(String linea){
        String[] songSplit = linea.split(",");
        return new Song(Integer.getInteger(songSplit[0]), songSplit[1], songSplit[2],songSplit[3],songSplit[4] );
    }

    public static ArrayList<Song> leerFichero(String fichero) throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader(fichero));

        ArrayList<Song> cancionesLeidas = new ArrayList<>();

        String linea = lector.readLine();
        while(linea!=null){
            cancionesLeidas.add(procesarLinea(linea));

            linea = lector.readLine();
        }

        lector.close();
        return cancionesLeidas;
    }

    public static void escribirBinario( ArrayList<Song> canciones) throws IOException {
        ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("punk.dat"));

        canciones.forEach(cancion -> {
            try {
                escritor.writeObject(cancion);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public static ArrayList<Song> leerCancionesBinario( String fichero) throws IOException, ClassNotFoundException {
        ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero));

        ArrayList<Song> cancionesLeidas = new ArrayList<>();
try {
    Song cancion = (Song) lector.readObject();

    while (true) {
        cancionesLeidas.add(cancion);
        cancion = (Song) lector.readObject();
    }
}
       catch (EOFException exc)
    {
        lector.close();
    }


        return cancionesLeidas;

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
       //escribirBinario(leerFichero("punk_rock_lyrics_data.csv"));
       leerCancionesBinario("punk.dat").stream()
               .collect(Collectors.groupingBy(Song::getAlbum)).
               entrySet().stream()
               .sorted(Collections.reverseOrder(Comparator.comparingInt(o -> o.getValue().size())))
               .forEach((a) -> System.out.println("Grupo " + a.getKey()
                       + " tiene un total de " + a.getValue().size() + "  canciones"));

    }
}
