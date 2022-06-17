package colegio.controlador;

public class clsAsignaciones {
    private int codigo_asignacion;
    private String nombre_carrera;
    private String nombre_sede;
    private String nombre_aula;
    private String nombre_curso;

    public clsAsignaciones() {
    }

    public clsAsignaciones(int codigofacultad) {
        this.codigo_asignacion = codigofacultad;
    }
    
    public clsAsignaciones(String snombre, String sestado) {
        this.nombre_carrera = snombre;
        this.nombre_sede = sestado;
    }
    
    public clsAsignaciones(int codigo_asignacion, String snombre, String sestado, String saula, String scurso) {
        this.codigo_asignacion = codigo_asignacion;
        this.nombre_carrera = snombre;
        this.nombre_sede = sestado;
        this.nombre_aula = saula;
        this.nombre_curso = scurso;
    }
    

    public int getcodigo_asignacion() {
        return codigo_asignacion;
    }

    public void setcodigo_asignacion(int codigo_asignacion) {
        this.codigo_asignacion = codigo_asignacion;
    }

    public String getnombre_carrera() {
        return nombre_carrera;
    }

    public void setnombre_carrera(String snombre) {
        this.nombre_carrera = snombre;
    }

    public String getnombre_sede() {
        return nombre_sede;
    }

    public void setnombre_sede(String sestado) {
        this.nombre_sede = sestado;
    }
     public String getnombre_aula() {
        return nombre_aula;
    }

    public void setnombre_aula(String saula) {
        this.nombre_aula = saula;
    }
      public String getnombre_curso() {
        return nombre_curso;
    }

    public void setnombre_curso(String scurso) {
        this.nombre_aula = scurso;
    }
    @Override
    public String toString() {
        return "facultades{" + "codigo_departamento=" + codigo_asignacion + ", nombre_departamento="  +  nombre_carrera +", estatus=" + nombre_sede+  "}";
    }
    
    
}
