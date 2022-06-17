package colegio.controlador;

public class clsSedes {
    private int codigo_sede;
    private String nombre_sede;
    private String estatus_sede;

    public clsSedes() {
    }

    public clsSedes(int codigofacultad) {
        this.codigo_sede = codigofacultad;
    }
    
    public clsSedes(String snombre, String sestado) {
        this.nombre_sede = snombre;
        this.estatus_sede = sestado;
    }
    
    public clsSedes(int codigo_sede, String snombre, String sestado) {
        this.codigo_sede = codigo_sede;
        this.nombre_sede = snombre;
        this.estatus_sede = sestado;
    }
    

    public int getcodigo_sede() {
        return codigo_sede;
    }

    public void setcodigo_sede(int codigo_sede) {
        this.codigo_sede = codigo_sede;
    }

    public String getnombre_sede() {
        return nombre_sede;
    }

    public void setnombre_sede(String snombre) {
        this.nombre_sede = snombre;
    }

    public String getestatus_sede() {
        return estatus_sede;
    }

    public void setestatus_sede(String sestado) {
        this.estatus_sede = sestado;
    }
    @Override
    public String toString() {
        return "facultades{" + "codigo_departamento=" + codigo_sede + ", nombre_departamento="  +  nombre_sede +", estatus=" + estatus_sede+  "}";
    }
    
    
}
