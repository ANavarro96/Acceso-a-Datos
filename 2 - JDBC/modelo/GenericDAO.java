package modelo;

import java.util.ArrayList;

public interface GenericDAO<T, ID> {

    // Método para guardar un nuevo objeto en la base de datos

    int add(T entity);

    // Método para actualizar un objeto existente en la base de datos

    int update(T entity);

    // Método para eliminar un objeto de la base de datos

    int delete(T entity);

    // Método para buscar un objeto por su ID

    T getbById(ID id);

    // Método para obtener todos los objetos de una tabla/entidad

    ArrayList<T> getAll();

}
