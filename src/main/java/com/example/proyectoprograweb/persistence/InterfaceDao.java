package com.example.proyectoprograweb.persistence;

import java.util.List;

public interface InterfaceDao<T> extends AutoCloseable {

    // Obtiene una lista de todos los elementos de tipo T.
    List<T> getAll();

    // Busca un elemento de tipo T por su ID y lo devuelve.
    T findById(String id);

    // Agrega un nuevo elemento de tipo T a la fuente de datos y devuelve la cantidad de registros afectados.
    int add(T t);

    // Elimina un elemento de tipo T de la fuente de datos.
    void delete(T t);

    // Actualiza un elemento de tipo T con una calificación en la fuente de datos.
    void upDate(String id, String calificacion);
}
