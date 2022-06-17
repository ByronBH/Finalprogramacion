/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio.modelo;

import colegio.controlador.clsCursos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCurso {

    private static final String SQL_SELECT = "SELECT codigo_curso, nombre_curso, estatus_curso FROM cursos";
    private static final String SQL_INSERT = "INSERT INTO cursos(nombre_curso, estatus_curso) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE cursos SET nombre_curso=?, estatus_curso=? WHERE codigo_curso= ?";
    private static final String SQL_DELETE = "DELETE FROM cursos WHERE codigo_curso=?";
    private static final String SQL_QUERY = "SELECT  codigo_curso,  nombre_curso, estatus_curso FROM cursos WHERE codigo_curso= ?";

    public List<clsCursos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCursos curso = null;
        List<clsCursos> cursos = new ArrayList<clsCursos>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_curso");
                String nombre = rs.getString("nombre_curso");
                String estatus = rs.getString("estatus_curso");

                curso = new clsCursos();
                curso.setcodigo_curso(codigo);
                curso.setnombre_curso(nombre);
                curso.setestatus_curso(estatus);

                cursos.add(curso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return cursos;
    }

    public int insert(clsCursos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfil.getnombre_curso());
            stmt.setString(2, perfil.getestatus_curso());

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

    public int update(clsCursos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
             
             stmt.setString(1, perfil.getnombre_curso());
            stmt.setString(2, perfil.getestatus_curso());
            stmt.setInt(3, perfil.getcodigo_curso());
            
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

    public int delete(clsCursos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getcodigo_curso());
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

    public clsCursos query(clsCursos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
           stmt.setInt(1, perfil.getcodigo_curso());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_curso");
                String nombre = rs.getString("nombre_curso");
                String estatus = rs.getString("estatus_curso");

                perfil = new clsCursos();
                perfil.setcodigo_curso(codigo);
                perfil.setnombre_curso(nombre);
                perfil.setestatus_curso(estatus);
                
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
        return perfil;
    }
}
