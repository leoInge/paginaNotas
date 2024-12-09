package com.example.proyectoprograweb.persistence;

import com.example.proyectoprograweb.logic.Course;

import java.util.List;

public class ServiceCourse {
    private CourseDaoImplement courseDaoImplement;

    public ServiceCourse() {
        courseDaoImplement = new CourseDaoImplement();
    }

    // Obtiene una lista de todos los cursos.
    public List<Course> getAll() {
        List<Course> list = courseDaoImplement.getAll();
        return list;
    }

    // Guarda un nuevo curso en la fuente de datos y devuelve true si se guardó correctamente.
    public boolean save(String... data) {
        // Convertimos los datos a los tipos de datos del objeto Course
        String id = data[0];
        String nombre = data[1];
        String nota = data[2];

        return courseDaoImplement.add(new Course(id, nombre, nota)) > 0;
    }
}
