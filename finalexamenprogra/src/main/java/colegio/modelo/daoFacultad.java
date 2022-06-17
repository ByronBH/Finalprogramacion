/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio.modelo;

import colegio.controlador.clsFacultades;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoFacultad {

    private static final String SQL_SELECT = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM facultades";
    private static final String SQL_INSERT = "INSERT INTO facultades(nombre_facultad, estatus_facultad) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE facultades SET nombre_facultad=?, estatus_facultad=? WHERE codigo_facultad= ?";
    private static final String SQL_DELETE = "DELETE FROM facultades WHERE codigo_facultad=?";
    private static final String SQL_QUERY = "SELECT  codigo_facultad,  nombre_facultad, estatus_facultad FROM facultades WHERE codigo_facultad= ?";

    public List<clsFacultades> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsFacultades usuario = null;
        List<clsFacultades> usuarios = new ArrayList<clsFacultades>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_facultad");
                String nombre = rs.getString("nombre_facultad");
                String estatus = rs.getString("estatus_facultad");

                usuario = new clsFacultades();
                usuario.setcodigo_facultad(codigo);
                usuario.setnombre_facultad(nombre);
                usuario.setestatus_facultad(estatus);

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(clsFacultades perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfil.getnombre_facultad());
            stmt.setString(2, perfil.getestatus_facultad());

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

    public int update(clsFacultades perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
             
             stmt.setString(1, perfil.getnombre_facultad());
            stmt.setString(2, perfil.getestatus_facultad());
            stmt.setInt(3, perfil.getcodigo_facultad());
            
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

    public int delete(clsFacultades perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getcodigo_facultad());
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

    public clsFacultades query(clsFacultades perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
           stmt.setInt(1, perfil.getcodigo_facultad());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_facultad");
                String nombre = rs.getString("nombre_facultad");
                String estatus = rs.getString("estatus_facultad");

                perfil = new clsFacultades();
                perfil.setcodigo_facultad(codigo);
                perfil.setnombre_facultad(nombre);
                perfil.setestatus_facultad(estatus);
                
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
