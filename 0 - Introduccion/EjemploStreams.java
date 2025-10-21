import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EjemploStreams {

    enum Prueba { A, B, C , D}


    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        Integer entero = Integer.valueOf(scanner.nextLine());
        System.out.println(entero+10);
        ArrayList<Integer> lista = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // Crear una nueva lista con los n�meros pares de la lista original
        ArrayList<Integer> listaPares = lista.stream().filter(n -> n % 2 == 0).collect(Collectors.toCollection(ArrayList::new));



    }
}
