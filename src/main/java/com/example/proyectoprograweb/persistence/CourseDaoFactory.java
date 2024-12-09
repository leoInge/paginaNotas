package com.example.proyectoprograweb.persistence;

// Esta clase es una fábrica para crear instancias de CourseDao.
public class CourseDaoFactory {

    // Método para crear una instancia de CourseDao.
    public InterfaceDao createCourseDao() {
        // Crea y devuelve una instancia de CourseDaoImplement.
        return new CourseDaoImplement();
    }
}
