package model;

public class Profesor  extends Persona{
    
    private float salario;

    public Profesor() {
    }

    public Profesor(String nombre, String telefono, String email, float salario) {
        super(nombre, telefono, email);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }


    @Override
    public String toString() {
        return super.toString() + 
                "Salario: " + salario + "\n";
    }

}
