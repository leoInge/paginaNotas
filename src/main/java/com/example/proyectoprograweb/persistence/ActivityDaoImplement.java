package com.example.proyectoprograweb.persistence;

import com.example.proyectoprograweb.logic.Activity;
import com.example.proyectoprograweb.logic.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDaoImplement implements InterfaceDao<Activity>  {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/notas?allowPublicKeyRetrieval=true&useSSL=false";
    private final String USER = "materiasdb";
    private final String PASSWORD = "1234";

    // Método para obtener todas las actividades desde la base de datos.
    @Override
    public List<Activity> getAll() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            String query = "SELECT * FROM actividades";
            ResultSet resultSet = statement.executeQuery(query);
            List<Activity> list = new ArrayList<>();

            while (resultSet.next()) {

                String id = resultSet.getString(1);
                String tipo = resultSet.getString(2);
                String descripcion = resultSet.getString(3);
                String ponderado = resultSet.getString(4);
                String fecha = resultSet.getString(5);
                String calificacion = resultSet.getString(6);
                String idMateria = resultSet.getString(7);

                String queryId = "SELECT materiaNombre FROM materia WHERE materia_id='" + idMateria + "'";


                // Agrega cada actividad a la lista.
                list.add(new Activity(id, tipo,descripcion,ponderado,fecha,calificacion,idMateria));

            }
            System.out.println(list);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    // Método para encontrar una actividad por su ID.
    @Override
    public Activity findById(String id) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            String query = "SELECT * FROM actividades WHERE actId='" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                String idAct = resultSet.getString(1);
                String tipo = resultSet.getString(2);
                String descripcion = resultSet.getString(3);
                String ponderado = resultSet.getString(4);
                String fecha = resultSet.getString(5);
                String calificacion = resultSet.getString(6);
                String idMateria = resultSet.getString(7);

                // Devuelve la actividad encontrada.
                return new Activity(idAct, tipo,descripcion,ponderado,fecha,calificacion,idMateria);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    // Método para agregar una actividad a la base de datos.
    @Override
    public int add(Activity activity) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            int id = Integer.parseInt(activity.getIdActividad());
            String tipo = activity.getTipoActividad();
            String descripcion = activity.getDescripcionActividad();
            String ponderado = activity.getPonderado();
            String fecha = activity.getFechaEntrega();
            String calificacion = activity.getCalificacionActividad();
            int idMateria = Integer.parseInt(activity.getIdMateria());

            String query = "INSERT INTO actividades VALUES('" + id + "','" + tipo +
                    "','" + descripcion +
                    "','" + ponderado +
                    "','" + fecha +
                    "','" + calificacion +
                    "','"+ idMateria +"')";

            // Ejecuta la inserción en la base de datos y devuelve el resultado.
            return statement.executeUpdate( query );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    // Método para eliminar una actividad de la base de datos.
    @Override
    public void delete(Activity activity) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            String id = activity.getIdActividad();

            String query = "DELETE  FROM actividades WHERE actId='" + id + "'";

            // Ejecuta la eliminación en la base de datos.
            statement.executeUpdate( query );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    // Método para actualizar la calificación de una actividad en la base de datos.
    @Override
    public void upDate(String id, String calificacion) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {

            String query = "UPDATE actividades set calificacionAct='"+calificacion+"' WHERE actId='" + id + "'";
            // Ejecuta la actualización en la base de datos.
            statement.executeUpdate( query );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        // Este método se debe implementar debido a que la clase InterfaceDao<T> lo declara, pero no requiere acciones adicionales en este caso.

    }
}
