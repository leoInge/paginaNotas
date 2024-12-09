package com.example.proyectoprograweb.servlets;

import com.google.gson.Gson;
import com.example.proyectoprograweb.logic.Course;
import com.example.proyectoprograweb.persistence.ServiceCourse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletCourse", value = "/ServletCourse")
public class ServletCourse extends HttpServlet {
    private ServiceCourse serviceCourse;

    // Método de inicialización del servlet.
    public void init(){
        serviceCourse = new ServiceCourse();
    }

    // Método para manejar las solicitudes GET.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Configura la respuesta como texto plano.
        response.setContentType("text/plain");

            PrintWriter out = response.getWriter();

        // Obtiene todos los cursos desde el servicio.
            List<Course> serviceCourseAll = serviceCourse.getAll();

            Gson gson = new Gson();

        // Convierte los cursos a formato JSON y los envía como respuesta.
            out.print(gson.toJson( serviceCourseAll));

    }

    // Método para manejar las solicitudes POST.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configura la respuesta como JSON.
        response.setContentType("text/json");

        // Obtiene los parámetros de la solicitud para crear un nuevo curso.
            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String nota = request.getParameter("nota");

            try (PrintWriter out = response.getWriter()) {
                // Llama al servicio para guardar el nuevo curso y envía una respuesta JSON.
                if (serviceCourse.save(id, nombre, nota)) {
                    out.print("{\"state\":true}");
                } else {
                    out.print("{\"state\":false}");
                }
            }

    }
}
