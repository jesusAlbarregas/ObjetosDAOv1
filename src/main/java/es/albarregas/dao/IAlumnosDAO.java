package es.albarregas.dao;

import es.albarregas.beans.Alumno;

import java.util.List;


public interface IAlumnosDAO {
    
    public List<Alumno> getAlumnos();
    public List<Alumno> getAlumnosEquipo();
    public void closeConnection();
    
}