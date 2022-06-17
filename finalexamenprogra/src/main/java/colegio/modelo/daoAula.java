/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio.modelo;

import colegio.controlador.clsAulas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoAula {

    private static final String SQL_SELECT = "SELECT codigo_aula, nombre_aula, estatus_aula FROM aulas";
    private static final String SQL_INSERT = "INSERT INTO aulas(nombre_aula, estatus_aula) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE aulas SET nombre_aula=?, estatus_aula=? WHERE codigo_aula= ?";
    private static final String SQL_DELETE = "DELETE FROM aulas WHERE codigo_aula=?";
    private static final String SQL_QUERY = "SELECT  codigo_aula,  nombre_aula, estatus_aula FROM aulas WHERE codigo_aula= ?";

    public List<clsAulas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsAulas aula = null;
        List<clsAulas> aulas = new ArrayList<clsAulas>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_aula");
                String nombre = rs.getString("nombre_aula");
                String estatus = rs.getString("estatus_aula");

                aula = new clsAulas();
                aula.setcodigo_aula(codigo);
                aula.setnombre_aula(nombre);
                aula.setestatus_aula(estatus);

                aulas.add(aula);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return aulas;
    }

    public int insert(clsAulas perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfil.getnombre_aula());
            stmt.setString(2, perfil.getestatus_aula());

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

    public int update(clsAulas perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
             
             stmt.setString(1, perfil.getnombre_aula());
            stmt.setString(2, perfil.getestatus_aula());
            stmt.setInt(3, perfil.getcodigo_aula());
            
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

    public int delete(clsAulas perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getcodigo_aula());
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

    public clsAulas query(clsAulas perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
           stmt.setInt(1, perfil.getcodigo_aula());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_aula");
                String nombre = rs.getString("nombre_aula");
                String estatus = rs.getString("estatus_aula");

                perfil = new clsAulas();
                perfil.setcodigo_aula(codigo);
                perfil.setnombre_aula(nombre);
                perfil.setestatus_aula(estatus);
                
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
