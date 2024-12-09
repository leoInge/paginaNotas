package com.example.proyectoprograweb.persistence;

// Esta clase es una fábrica para crear instancias de ActivityDao.
public class ActivityDaoFactory {

    // Método para crear una instancia de ActivityDao.
    public InterfaceDao createAcivityDao() {
        // Crea y devuelve una instancia de ActivityDaoImplement.
        return new ActivityDaoImplement();
    }
}
