/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Auxiliar;
import es.albarregas.beans.Auxiliar2;
import es.albarregas.beans.Equipo;
import es.albarregas.dao.IAlumnosDAO;
import es.albarregas.dao.AlumnosDAO;
import es.albarregas.dao.EquiposDAO;
import es.albarregas.dao.IEquiposDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
        IEquiposDAO edao = new EquiposDAO();
        List<Alumno> alumnos = new ArrayList<>();
        String url = "/JSP/aviso.jsp";

        String accion = request.getParameter("all");

        if (accion != null) {
            switch (accion) {
                case "alumnos":
                    alumnos = adao.getAlumnos();
                    if (alumnos != null) {
                        url = "/JSP/salida.jsp";
                        request.setAttribute("alumnos", alumnos);
                    } else {
                        url = "/JSP/aviso.jsp";
                        request.setAttribute("aviso", "No existen datos");
                    }
                    break;
                case "alumnos_equipos":
                    alumnos = adao.getAlumnosEquipo();
                    if (alumnos != null) {
                        url = "/JSP/salida2.jsp";
                        request.setAttribute("alumnos", alumnos);
                    } else {
                        url = "/JSP/aviso.jsp";
                        request.setAttribute("aviso", "No existen datos");
                    }
                    break;

                case "equipo_alumnos":
                    alumnos = edao.getEquiposAsignados();
                    if (alumnos != null) {
                        Iterator<Alumno> itAlumno = alumnos.iterator();
                        List<Auxiliar> listado = new ArrayList<>();
                        List<String> alumAux = null;
                        String equipoAux = "";
                        Auxiliar aux = null;
                        while (itAlumno.hasNext()) {
                            Alumno alumno = new Alumno();

                            alumno = itAlumno.next();
                            if (!equipoAux.equalsIgnoreCase(alumno.getEquipo().getMarca())) {
                                if (!equipoAux.equals("")) {
                                    aux.setAlumnos(alumAux);
                                    listado.add(aux);
                                }
                                aux = new Auxiliar();
                                aux.setNombreEquipo(alumno.getEquipo().getMarca());

                                equipoAux = alumno.getEquipo().getMarca();
                                alumAux = new ArrayList<>();
                            }
                            alumAux.add(alumno.getNombre());
                        }
                        aux.setAlumnos(alumAux);
                        listado.add(aux);
                        request.setAttribute("listado", listado);
                        url = "/JSP/salida3.jsp";
                    } else {
                        url = "/JSP/aviso.jsp";
                        request.setAttribute("aviso", "No existen datos");
                    }
                    break;

                case "equipo_alumnos2":
                    List<Auxiliar2> listado2 = edao.getEquiposAsignadosSQL();
                    if (listado2 != null) {
                        request.setAttribute("listado2", listado2);
                        url = "/JSP/salida4.jsp";
                    } else {
                        url = "/JSP/aviso.jsp";
                        request.setAttribute("aviso", "No existen datos");
                    }
                    break;

                case "equipo_sinalumnos":
                    List<Equipo> equipos = edao.getEquiposSinAsignar();
                    if (equipos != null) {
                        request.setAttribute("equipos", equipos);
                        url = "/JSP/salida5.jsp";
                    } else {
                        url = "/JSP/aviso.jsp";
                        request.setAttribute("aviso", "No existen datos");
                    }
                    break;

            }

        } else {
            request.setAttribute("aviso", "No se han pasado parámetros");
            url = "index.jsp";

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
