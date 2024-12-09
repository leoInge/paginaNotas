package com.example.proyectoprograweb.persistence;

import com.example.proyectoprograweb.logic.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImplement implements InterfaceDao<Course> {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/notas?allowPublicKeyRetrieval=true&useSSL=false";
    private final String USER = "materiasdb";
    private final String PASSWORD = "1234";

    @Override
    public List<Course> getAll() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            // Consulta SQL para obtener todos los cursos.
            String query = "SELECT * FROM materia";
            ResultSet resultSet = statement.executeQuery(query);
            List<Course> list = new ArrayList<>();

            while (resultSet.next()) {

                String id = resultSet.getString(1);
                String nombre = resultSet.getString(2);
                String nota = String.valueOf(CalcularNota(id));

                // Crea y agrega un objeto Course a la lista.
                list.add(new Course(id, nombre, nota));

            }
            System.out.println(list);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
    @Override
    public Course findById(String id) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            // Consulta SQL para buscar un curso por ID.
            String query = "SELECT * FROM materia WHERE materia_id='" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String idRoom = resultSet.getString(1);
                String nombre = resultSet.getString(2);
                String nota = resultSet.getString(3);

                // Crea y devuelve un objeto Course encontrado.
                return new Course(idRoom, nombre, nota);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public int add(Course course) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            Integer id = Integer.parseInt(course.getId());
            String nombre = course.getName();
            int nota= Integer.parseInt(course.getRate());

            // Consulta SQL para insertar un nuevo curso en la base de datos.
            String query = "INSERT INTO materia VALUES('" + id + "','" + nombre +
                    "','" + nota + "')";

            return statement.executeUpdate( query );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public void delete(Course course) {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {

            String id = course.getId();

            // Consulta SQL para eliminar todas las actividades relacionadas con este curso.
            String queryAct = "DELETE  FROM actividades WHERE materia_id='" + id + "'";

            statement.executeUpdate( queryAct );

            // Consulta SQL para eliminar el curso de la base de datos.
            String query = "DELETE FROM materia WHERE materia_id='" + id + "'";

            statement.executeUpdate( query );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //notas

    // Método para calcular la nota promedio de un curso.
    public int CalcularNota(String id) {
        int total=0;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {

            // Consulta SQL para obtener calificaciones y ponderados de actividades relacionadas con el curso.
            String query = "SELECT calificacionAct , ponteradoAct FROM actividades WHERE materia_id='" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                int ponderado = Integer.parseInt(resultSet.getString(1));
                int calificacion = Integer.parseInt(resultSet.getString(2));

                // Calcula el total de notas ponderadas.
                total=total+((calificacion*ponderado)/100);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return total;
    }

    @Override
    public void upDate(String id, String calificacion) {

        // Este método se debe implementar debido a que la clase InterfaceDao<T> lo declara, pero no requiere acciones adicionales en este caso.
    }

    @Override
    public void close() throws Exception {

        // Este método se debe implementar debido a que la clase InterfaceDao<T> lo declara, pero no requiere acciones adicionales en este caso.
    }

}