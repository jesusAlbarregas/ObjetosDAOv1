package es.albarregas.dao;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlumnosDAO implements IAlumnosDAO {
    
    @Override
    public List<Alumno> getAlumnos() {
        
        List<Alumno> lista = null;
        String consulta = "SELECT nombre,grupo FROM alumnos";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            lista = new ArrayList<>();
            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setGrupo(resultado.getString("grupo"));
                lista.add(alumno);
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return lista;
    }
    
    @Override
    public List<Alumno> getAlumnosEquipo() {
        
        List<Alumno> lista = null;
        String consulta = "SELECT a.nombre,e.marca,e.numSerie FROM alumnos as a left join equipos as e using(idEquipo)";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            lista = new ArrayList<>();
            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultado.getString(1));
                if (resultado.getString(2) != null) {
                    Equipo equipo = new Equipo();
                    equipo.setMarca(resultado.getString(2));
                    equipo.setNumSerie(resultado.getString(3));
                    alumno.setEquipo(equipo);
                } else {
                    alumno.setEquipo(null);
                }
                lista.add(alumno);
            }
            
            resultado.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return lista;
        
    }
    
    @Override
    public void closeConnection() {
        
        ConnectionFactory.closeConnection();
        
    }
    
}
