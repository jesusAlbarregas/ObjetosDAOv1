/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Alumno;
import es.albarregas.dao.IAlumnosDAO;
import es.albarregas.dao.AlumnosDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IAlumnosDAO adao = new AlumnosDAO();
        List<Alumno> alumnos = new ArrayList<>();
        String url = "/JSP/aviso.jsp";

        String accion = request.getParameter("all");

        if (accion != null) {
            switch (accion) {
                case "alumnos":
                    alumnos = adao.getAlumnos();
                    if (alumnos != null) {
                        url = "/JSP/salida.jsp";
                        
                    }
                    break;
                case "alumnos_equipos":
                    alumnos = adao.getAlumnosEquipo();
                    if (alumnos != null) {
                        url = "/JSP/salida2.jsp";
                        
                    }
                    break;
            }
            if (!url.contains("aviso")) {
                request.setAttribute("alumnos", alumnos);
            } else {
                request.setAttribute("aviso", "No existen datos");
            }
        } else {
            request.setAttribute("aviso", "No se han pasado parámetros");

        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
