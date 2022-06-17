package colegio.controlador;

public class clsFacultades {
    private int codigo_facultad;
    private String nombre_facultad;
    private String estatus_facultad;

    public clsFacultades() {
    }

    public clsFacultades(int codigofacultad) {
        this.codigo_facultad = codigofacultad;
    }
    
    public clsFacultades(String snombre, String sestado) {
        this.nombre_facultad = snombre;
        this.estatus_facultad = sestado;
    }
    
    public clsFacultades(int codigo_facultad, String snombre, String sestado) {
        this.codigo_facultad = codigo_facultad;
        this.nombre_facultad = snombre;
        this.estatus_facultad = sestado;
    }
    

    public int getcodigo_facultad() {
        return codigo_facultad;
    }

    public void setcodigo_facultad(int codigo_facultad) {
        this.codigo_facultad = codigo_facultad;
    }

    public String getnombre_facultad() {
        return nombre_facultad;
    }

    public void setnombre_facultad(String snombre) {
        this.nombre_facultad = snombre;
    }

    public String getestatus_facultad() {
        return estatus_facultad;
    }

    public void setestatus_facultad(String sestado) {
        this.estatus_facultad = sestado;
    }
    @Override
    public String toString() {
        return "facultades{" + "codigo_departamento=" + codigo_facultad + ", nombre_departamento="  +  nombre_facultad +", estatus=" + estatus_facultad+  "}";
    }
    
    
}
