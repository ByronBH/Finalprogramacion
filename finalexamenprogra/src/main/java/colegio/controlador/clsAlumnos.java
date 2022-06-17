package colegio.controlador;

import seguridad.controlador.*;

public class clsAlumnos {
    private int carnet_alumno;
    private String nombre_alumno;
    private String direccion_alumno;
    private String telefono_alumno;
    private String email_alumno;
    private String estatus_alumno;
    private String usucorreoe;
    private String usutelefono;
    private String usudireccion;
    public clsAlumnos() {
    }

    public clsAlumnos(int p_carnet_alumno) {
        this.carnet_alumno = p_carnet_alumno;
    }
    
    public clsAlumnos(String p_nombre_alumno, String p_direccion_alumno) {
        this.nombre_alumno = p_nombre_alumno;
        this.direccion_alumno = p_direccion_alumno;
    }
    
    public clsAlumnos(int p_carnet_alumno, String p_nombre_alumno, String p_direccion_alumno) {
        this.carnet_alumno = p_carnet_alumno;
        this.nombre_alumno = p_nombre_alumno;
        this.direccion_alumno = p_direccion_alumno;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getcarnet_alumno() {
        return carnet_alumno;
    }

    public void setcarnet_alumno(int carnet_alumno) {
        this.carnet_alumno = carnet_alumno;
    }

    public String getnombre_alumno() {
        return nombre_alumno;
    }

    public void setnombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getdireccion_alumno() {
        return direccion_alumno;
    }

    public void setdireccion_alumno(String direccion_alumno) {
        this.direccion_alumno = direccion_alumno;
    }

    public String gettelefono_alumno() {
        return telefono_alumno;
    }

    public void settelefono_alumno(String telefono_alumno) {
        this.telefono_alumno = telefono_alumno;
    }

    public String getemail_alumno() {
        return email_alumno;
    }

    public void setemail_alumno(String email_alumno) {
        this.email_alumno = email_alumno;
    }

    public String getestatus_alumno() {
        return estatus_alumno;
    }

    public void setestatus_alumno(String estatus_alumno) {
        this.estatus_alumno = estatus_alumno;
    }

  }