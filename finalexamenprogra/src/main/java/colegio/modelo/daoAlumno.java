/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio.modelo;

import seguridad.modelo.*;
import colegio.controlador.clsAlumnos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoAlumno {

    private static final String SQL_SELECT = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno,  FROM alumnos";
    private static final String SQL_INSERT = "INSERT INTO alumnos(nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno ) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombre_alumno=?, direccion_alumno=?, telefono_alumno=?, email_alumno=?, estatus_alumno=? WHERE carnet_alumno = ?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE carnet_alumno=?";
    private static final String SQL_QUERY = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos WHERE carnet_alumno=?";
    private static final String SQL_QUERYN = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos WHERE nombre_alumno=?";    

    public List<clsAlumnos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsAlumnos alumno = null;
        List<clsAlumnos> alumnos = new ArrayList<clsAlumnos>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("carnet_alumno");
                String nombre = rs.getString("nombre_alumno");
                String contrasena = rs.getString("direccion_alumno");
                String ultimasesion = rs.getString("telefono_alumno");
                String estatus = rs.getString("email_alumno");
                String nombrereal = rs.getString("estatus_alumno");
                String correoe = rs.getString("usucorreoe");
                String telefono = rs.getString("usutelefono");
                String direccion = rs.getString("usudireccion");

                alumno = new clsAlumnos();
                alumno.setcarnet_alumno(id);
                alumno.setnombre_alumno(nombre);
                alumno.setdireccion_alumno(contrasena);
                alumno.settelefono_alumno(ultimasesion);
                alumno.setemail_alumno(estatus);
                alumno.setestatus_alumno(nombrereal);
                               alumnos.add(alumno);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return alumnos;
    }

    public int insert(clsAlumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumno.getnombre_alumno());
            stmt.setString(2, alumno.getdireccion_alumno());
            stmt.setString(3, alumno.gettelefono_alumno());
            stmt.setString(4, alumno.getemail_alumno());
            stmt.setString(5, alumno.getestatus_alumno());            
            

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

    public int update(clsAlumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumno.getnombre_alumno());
            stmt.setString(2, alumno.getdireccion_alumno());
            stmt.setString(3, alumno.gettelefono_alumno());
            stmt.setString(4, alumno.getemail_alumno());
            stmt.setString(5, alumno.getestatus_alumno());            
                  
            stmt.setInt(9, alumno.getcarnet_alumno());

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

    public int delete(clsAlumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alumno.getcarnet_alumno());
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

    public clsAlumnos query(clsAlumnos alumno) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, alumno.getcarnet_alumno());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("carnet_alumno");
                String nombre = rs.getString("nombre_alumno");
                String contrasena = rs.getString("direccion_alumno");
                String ultimasesion = rs.getString("telefono_alumno");
                String estatus = rs.getString("email_alumno");
                String nombrereal = rs.getString("estatus_alumno");
                String correoe = rs.getString("usucorreoe");
                String telefono = rs.getString("usutelefono");
                String direccion = rs.getString("usudireccion");

                alumno = new clsAlumnos();
                alumno.setcarnet_alumno(id);
                alumno.setnombre_alumno(nombre);
                alumno.setdireccion_alumno(contrasena);
                alumno.settelefono_alumno(ultimasesion);
                alumno.setemail_alumno(estatus);
                alumno.setestatus_alumno(nombrereal);
             
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
        return alumno;
    }
public clsAlumnos queryn(clsAlumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, alumno.getnombre_alumno());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("carnet_alumno");
                String nombre = rs.getString("nombre_alumno");
                String contrasena = rs.getString("direccion_alumno");
                String ultimasesion = rs.getString("telefono_alumno");
                String estatus = rs.getString("email_alumno");
                String nombrereal = rs.getString("estatus_alumno");
                String correoe = rs.getString("usucorreoe");
                String telefono = rs.getString("usutelefono");
                String direccion = rs.getString("usudireccion");

                alumno = new clsAlumnos();
                alumno.setcarnet_alumno(id);
                alumno.setnombre_alumno(nombre);
                alumno.setdireccion_alumno(contrasena);
                alumno.settelefono_alumno(ultimasesion);
                alumno.setemail_alumno(estatus);
                alumno.setestatus_alumno(nombrereal);
            
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
        return alumno;
    }
    
}
