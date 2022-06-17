/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio.modelo;

import colegio.controlador.clsCarreras;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCarrera {

    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM carreras";
    private static final String SQL_INSERT = "INSERT INTO carreras(nombre_carrera, codigo_facultad, estatus_carrera) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE carreras SET nombre_carrera=?, codigo_facultad estatus_carrera=? WHERE codigo_carrera= ?";
    private static final String SQL_DELETE = "DELETE FROM carreras WHERE codigo_carrera=?";
    private static final String SQL_QUERY = "SELECT  codigo_carrera,  nombre_carrera, codigo_facultad, estatus_carrera FROM carreras WHERE codigo_carrera= ?";

    public List<clsCarreras> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCarreras carrera = null;
        List<clsCarreras> carreras = new ArrayList<clsCarreras>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                String estatus = rs.getString("estatus_carrera");
                String codigof = rs.getString("codigo_facultad");

                carrera = new clsCarreras();
                carrera.setcodigo_carrera(codigo);
                carrera.setnombre_carrera(nombre);
                carrera.setcodigo_facultad(codigof);
                carrera.setestatus_carrera(estatus);

                carreras.add(carrera);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return carreras;
    }

    public int insert(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, carrera.getnombre_carrera());
             stmt.setString(2, carrera.getcodigo_facultad());
            stmt.setString(3, carrera.getestatus_carrera());
            

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

    public int update(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
             
             stmt.setString(1, carrera.getnombre_carrera());
              stmt.setString(2, carrera.getcodigo_facultad());
            stmt.setString(3, carrera.getestatus_carrera());
            stmt.setInt(4, carrera.getcodigo_carrera());
            
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

    public int delete(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, carrera.getcodigo_carrera());
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

    public clsCarreras query(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
           stmt.setInt(1, carrera.getcodigo_carrera());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                 String codigof = rs.getString("codigo_facultad");
                String estatus = rs.getString("estatus_carrera");

                carrera = new clsCarreras();
                carrera.setcodigo_carrera(codigo);
                carrera.setnombre_carrera(nombre);
                carrera.setcodigo_facultad(codigof);
                carrera.setestatus_carrera(estatus);
                
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
        return carrera;
    }
}
