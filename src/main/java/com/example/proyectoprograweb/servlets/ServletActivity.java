package com.example.proyectoprograweb.servlets;

import com.example.proyectoprograweb.logic.Activity;
import com.example.proyectoprograweb.persistence.ServiceActivity;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletActivity", value = "/ServletActivity")
public class ServletActivity extends HttpServlet {

    private ServiceActivity serviceActivity;

    // Método de inicialización del servlet.
    public void init(){
        serviceActivity = new ServiceActivity();
    }

    // Método para manejar las solicitudes GET.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Configura la respuesta como texto plano.
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
// Obtiene todas las actividades desde el servicio.
        List<Activity> activityAll = serviceActivity.getAll();

        Gson gson = new Gson();
        // Convierte las actividades a formato JSON y las envía como respuesta.

        out.print(gson.toJson( activityAll));
    }

    // Método para manejar las solicitudes POST.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configura la respuesta como JSON.
        response.setContentType("text/json");

        // Obtiene el parámetro "add" para determinar si se está agregando una nueva actividad.
        boolean add= Boolean.parseBoolean(request.getParameter("add"));

        if (add) {
            // Si se está agregando una nueva actividad, obtiene los parámetros de la solicitud.
            String id = request.getParameter("id");
            String tipo = request.getParameter("tipo");
            String descripcion = request.getParameter("descripcion");
            String ponderado = request.getParameter("ponderado");
            String fecha = request.getParameter("fecha");
            String calificacion = request.getParameter("calificacion");
            String idMateria = request.getParameter("idMateria");

            try (PrintWriter out = response.getWriter()) {
                // Llama al servicio para guardar la nueva actividad y envía una respuesta JSON.
                if (serviceActivity.save(id, tipo, descripcion, ponderado, fecha, calificacion, idMateria)) {
                    out.print("{\"state\":true}");
                } else {
                    out.print("{\"state\":false}");
                }
            }
       }else {
            // Si no se está agregando una nueva actividad, verifica si se está actualizando o eliminando.
            boolean upDate= Boolean.parseBoolean(request.getParameter("upDate"));

            if (upDate){
                try( PrintWriter out = response.getWriter()){
                    // Si se está actualizando, obtiene los parámetros necesarios.
                    String id = request.getParameter("id");
                    String calificacion = request.getParameter("calificacion");

                    // Llama al servicio para actualizar la calificación y envía una respuesta JSON.
                    serviceActivity.upDate(id,calificacion);
                    out.print("{\"state\":true}");
                }
            }else {
                try( PrintWriter out = response.getWriter()){
                    // Si no se está actualizando, se está eliminando la actividad.
                    String id = request.getParameter("id");

                    // Llama al servicio para eliminar la actividad y envía una respuesta JSON.
                    serviceActivity.delete(id);
                    out.print("{\"state\":true}");
                }
            }

        }
    }

}
