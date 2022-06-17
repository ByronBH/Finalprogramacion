/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio.modelo;

import colegio.controlador.clsAlumnos;
import colegio.*;
import colegio.controlador.clsAsignaciones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoAsigna {

    private static final String SQL_SELECT = "SELECT codigo_asignacion, nombre_carrera, nombre_sede, nombre_aula, nombre_curso FROM asignacioncursosalumnos";
    private static final String SQL_INSERT = "INSERT INTO asignacioncursosalumnos(nombre_carrera, nombre_sede, nombre_aula, nombre_curso) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE asignacioncursosalumnos SET nombre_carrera=?, nombre_sede=?, nombre_aula=?, nombre_curso=? WHERE codigo_asignacion = ?";
    private static final String SQL_DELETE = "DELETE FROM asignacioncursosalumnos WHERE codigo_asignacion=?";
    private static final String SQL_QUERY = "SELECT codigo_asignacion, nombre_carrera, nombre_sede, nombre_aula, nombre_curso FROM asignacioncursosalumnos WHERE codigo_asignacion=?";
    private static final String SQL_QUERY2 = "SELECT codigo_asignacion, nombre_carrera, nombre_sede, nombre_aula, nombre_curso empdepart FROM asignacioncursosalumnos WHERE nombre_carrera=?";

    public List<clsAsignaciones> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsAsignaciones asignacion = null;
        List<clsAsignaciones> asignaciones = new ArrayList<clsAsignaciones>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_asignacion");
                String nombre = rs.getString("nombre_carrera");
                String sueldo = rs.getString("nombre_sede");
                String estado = rs.getString("nombre_aula");
                String dias = rs.getString("nombre_curso");
              

                asignacion = new clsAsignaciones();
                asignacion.setcodigo_asignacion(id);
                asignacion.setnombre_carrera(nombre);
                asignacion.setnombre_sede(sueldo);
                asignacion.setnombre_aula(estado);
                asignacion.setnombre_curso(dias);
           
                
                asignaciones.add(asignacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return asignaciones;
    }

    public int insert(clsAsignaciones asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, asignacion.getnombre_carrera());
            stmt.setString(2, asignacion.getnombre_sede());
            stmt.setString(3, asignacion.getnombre_aula());
            stmt.setString(4, asignacion.getnombre_curso());
           
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsAsignaciones asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, asignacion.getnombre_carrera());
            stmt.setString(2, asignacion.getnombre_sede());
            stmt.setString(3, asignacion.getnombre_aula());
            stmt.setString(4, asignacion.getnombre_curso());
        ;
            stmt.setInt(5, asignacion.getcodigo_asignacion());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsAsignaciones asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, asignacion.getcodigo_asignacion());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clsAsignaciones query(clsAsignaciones asignacion) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, asignacion.getcodigo_asignacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_asignacion");
                String nombre = rs.getString("nombre_carrera");
                String sueldo = rs.getString("nombre_sede");
                String estado = rs.getString("nombre_aula");
                String dias = rs.getString("nombre_curso");
             

                asignacion = new clsAsignaciones();
                asignacion.setcodigo_asignacion(id);
                asignacion.setnombre_carrera(nombre);
                asignacion.setnombre_sede(sueldo);
                asignacion.setnombre_aula(estado);
                asignacion.setnombre_curso(dias);   
             
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return asignacion;
    }
    
    public clsAsignaciones query2(clsAsignaciones asignacion) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, asignacion.getnombre_carrera());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_asignacion");
                String nombre = rs.getString("nombre_carrera");
                String sueldo = rs.getString("nombre_sede");
                String estado = rs.getString("nombre_aula");
                String dias = rs.getString("nombre_curso");
               

                asignacion = new clsAsignaciones();
                asignacion.setcodigo_asignacion(id);
                asignacion.setnombre_carrera(nombre);
                asignacion.setnombre_sede(sueldo);
                asignacion.setnombre_aula(estado);
                asignacion.setnombre_curso(dias);   
                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return asignacion;
    }
    
    
    
}
