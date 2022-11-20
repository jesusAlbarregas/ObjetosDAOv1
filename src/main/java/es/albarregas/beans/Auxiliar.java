/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jesus
 */
public class Auxiliar implements Serializable {
    
    private String nombreEquipo;
    private List<String> alumnos;

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String equipo) {
        this.nombreEquipo = equipo;
    }

    public List<String> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<String> alumno) {
        this.alumnos = alumno;
    }
    
    
    
}
