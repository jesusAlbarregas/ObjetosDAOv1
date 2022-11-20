/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Auxiliar2;
import es.albarregas.beans.Equipo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesus
 */
public class EquiposDAO implements IEquiposDAO {

    @Override
    public List<Alumno> getEquiposAsignados() {
        List<Alumno> lista = null;
        String consulta = "SELECT e.marca,a.nombre,a.grupo FROM alumnos AS a INNER JOIN equipos AS e USING(idEquipo) ORDER BY e.idEquipo";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            lista = new ArrayList<>();
            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultado.getString(2));
                alumno.setGrupo(resultado.getString(3));

                Equipo equipo = new Equipo();
                equipo.setMarca(resultado.getString(1));
                
                alumno.setEquipo(equipo);

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
    public List<Auxiliar2> getEquiposAsignadosSQL() {
        List<Auxiliar2> lista = null;
        String consulta = "SELECT e.idequipo,e.marca,a.nombre,(SELECT COUNT(*) FROM alumnos WHERE e.idequipo=idequipo) AS numero "
                + "FROM alumnos AS a INNER JOIN equipos AS e USING(idequipo) ORDER BY e.idequipo;";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            lista = new ArrayList<>();
            while (resultado.next()) {
                Auxiliar2 aux2 = new Auxiliar2();
                aux2.setIdEquipo(resultado.getInt(1));
                aux2.setMarca(resultado.getString(2));
                aux2.setAlumno(resultado.getString(3));
                aux2.setNumero(resultado.getInt(4));

                lista.add(aux2);
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
    public List<Equipo> getEquiposSinAsignar() {
        List<Equipo> lista = null;
        String consulta = "SELECT e.marca,e.numSerie FROM equipos AS e LEFT JOIN alumnos AS a USING(idequipo) WHERE a.idEquipo IS NULL";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            lista = new ArrayList<>();
            while (resultado.next()) {
                Equipo equipo = new Equipo();
                equipo.setMarca(resultado.getString(1));
                equipo.setNumSerie(resultado.getString(2));
                

                lista.add(equipo);
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
