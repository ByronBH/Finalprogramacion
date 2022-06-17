package colegio.controlador;

public class clsCarreras {
    private int codigo_carrera;
    private String nombre_carrera;
    private String codigo_facultad;
    private String estatus_carrera;

    public clsCarreras() {
    }

    public clsCarreras(int codigofacultad) {
        this.codigo_carrera = codigofacultad;
    }
    
    public clsCarreras(String snombre, String sestado) {
        this.nombre_carrera = snombre;
        this.estatus_carrera = sestado;
    }
    
    public clsCarreras(int codigo_carrera, String snombre, String sestado, String sfacultad) {
        this.codigo_carrera = codigo_carrera;
        this.nombre_carrera = snombre;
        this.codigo_facultad = sfacultad;
        this.estatus_carrera = sestado;
        
    }
    

    public int getcodigo_carrera() {
        return codigo_carrera;
    }

    public void setcodigo_carrera(int codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getnombre_carrera() {
        return nombre_carrera;
    }

    public void setnombre_carrera(String snombre) {
        this.nombre_carrera = snombre;
    }
      public String getcodigo_facultad() {
        return codigo_facultad;
    }
      public void setcodigo_facultad(String snombre) {
        this.codigo_facultad = snombre;
    }
   
    public void setestatus_carrera(String sestado) {
        this.estatus_carrera = sestado;
    }
     public String getestatus_carrera() {
        return estatus_carrera;
    }
    @Override
    public String toString() {
        return "facultades{" + "codigo_departamento=" + codigo_carrera + ", nombre_departamento="  +  nombre_carrera +", estatus=" + estatus_carrera+  "}";
    }
    
    
}
