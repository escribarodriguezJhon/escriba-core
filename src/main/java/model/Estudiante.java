package model;

public class Estudiante extends Persona {
    
    private String codigo;
    private String serie;

    public Estudiante() {
    }

    public Estudiante(String codigo, String serie, String nombre, String telefono, String email) {
        super(nombre, telefono, email);
        this.codigo = codigo;
        this.serie = serie;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }


    @Override
    public String toString() {
        return super.toString() + 
                "Codigo: " + codigo + "\n" +
                "Serie: " + serie + "\n";
    }

    public void verificarSerie(){
        
    }

}
