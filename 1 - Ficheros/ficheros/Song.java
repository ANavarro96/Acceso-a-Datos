package ficheros;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Song implements Serializable {

    public Song(Integer id, String nombre, String album, String grupo, String letra) {
        this.id = id;
        this.nombre = nombre;
        this.album = album;
        this.grupo = grupo;
        this.letra = letra;
    }


    Integer id;
    String nombre;
    String album;
    String grupo;
    String letra;
}
