/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Auxiliar2;
import es.albarregas.beans.Equipo;

import java.util.List;

/**
 *
 * @author jesus
 */
public interface IEquiposDAO {
    
    public List<Alumno> getEquiposAsignados();
    public List<Auxiliar2> getEquiposAsignadosSQL();
    public List<Equipo> getEquiposSinAsignar();
    public void closeConnection();
    
}
