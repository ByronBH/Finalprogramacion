package colegio.controlador;

public class clsAulas {
    private int codigo_aula;
    private String nombre_aula;
    private String estatus_aula;

    public clsAulas() {
    }

    public clsAulas(int codigofacultad) {
        this.codigo_aula = codigofacultad;
    }
    
    public clsAulas(String snombre, String sestado) {
        this.nombre_aula = snombre;
        this.estatus_aula = sestado;
    }
    
    public clsAulas(int codigo_aula, String snombre, String sestado) {
        this.codigo_aula = codigo_aula;
        this.nombre_aula = snombre;
        this.estatus_aula = sestado;
    }
    

    public int getcodigo_aula() {
        return codigo_aula;
    }

    public void setcodigo_aula(int codigo_aula) {
        this.codigo_aula = codigo_aula;
    }

    public String getnombre_aula() {
        return nombre_aula;
    }

    public void setnombre_aula(String snombre) {
        this.nombre_aula = snombre;
    }

    public String getestatus_aula() {
        return estatus_aula;
    }

    public void setestatus_aula(String sestado) {
        this.estatus_aula = sestado;
    }
    @Override
    public String toString() {
        return "facultades{" + "codigo_departamento=" + codigo_aula + ", nombre_departamento="  +  nombre_aula +", estatus=" + estatus_aula+  "}";
    }
    
    
}
