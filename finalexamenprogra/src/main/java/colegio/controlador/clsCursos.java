package colegio.controlador;

public class clsCursos {
    private int codigo_curso;
    private String nombre_curso;
    private String estatus_curso;

    public clsCursos() {
    }

    public clsCursos(int codigofacultad) {
        this.codigo_curso = codigofacultad;
    }
    
    public clsCursos(String snombre, String sestado) {
        this.nombre_curso = snombre;
        this.estatus_curso = sestado;
    }
    
    public clsCursos(int codigo_curso, String snombre, String sestado) {
        this.codigo_curso = codigo_curso;
        this.nombre_curso = snombre;
        this.estatus_curso = sestado;
    }
    

    public int getcodigo_curso() {
        return codigo_curso;
    }

    public void setcodigo_curso(int codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public String getnombre_curso() {
        return nombre_curso;
    }

    public void setnombre_curso(String snombre) {
        this.nombre_curso = snombre;
    }

    public String getestatus_curso() {
        return estatus_curso;
    }

    public void setestatus_curso(String sestado) {
        this.estatus_curso = sestado;
    }
    @Override
    public String toString() {
        return "facultades{" + "codigo_departamento=" + codigo_curso + ", nombre_departamento="  +  nombre_curso +", estatus=" + estatus_curso+  "}";
    }
    
    
}
