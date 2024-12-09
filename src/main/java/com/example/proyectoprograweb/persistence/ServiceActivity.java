package com.example.proyectoprograweb.persistence;

import com.example.proyectoprograweb.logic.Activity;

import java.util.List;

public class ServiceActivity {

    private ActivityDaoImplement activityDaoImplement;

    public ServiceActivity() {
        activityDaoImplement = new ActivityDaoImplement();
    }

    // Obtiene una lista de todas las actividades.
    public List<Activity> getAll() {
        List<Activity> list = activityDaoImplement.getAll();
        return list;
    }

    // Guarda una nueva actividad en la fuente de datos y devuelve true si se guardó correctamente.
    public boolean save(String... data) {
        String idAct = data[0];
        String tipo = data[1];
        String descripcion = data[2];
        String ponderado = data[3];
        String fecha = data[4];
        String calificacion = data[5];
        String idMateria = data[6];

        return activityDaoImplement.add(new Activity(idAct, tipo, descripcion, ponderado, fecha, calificacion, idMateria)) > 0;
    }

    // Elimina una actividad por su ID.
    public void delete(String id) {
        activityDaoImplement.delete(activityDaoImplement.findById(id));
    }

    // Actualiza la calificación de una actividad por su ID.
    public void upDate(String id, String calificacion) {
        activityDaoImplement.upDate(id, calificacion);
    }
}
