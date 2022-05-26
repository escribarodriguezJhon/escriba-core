package idao;

import java.util.ArrayList;
import java.util.List;
import model.Curso;

import model.Direccion;
import model.Estudiante;
import model.Persona;

public interface IPersonaDAO {

    public ArrayList<Persona> listarPersonas();

    public Persona buscarEstudiante(String codigo);

    public Direccion obtenerDireccion(Estudiante estudiante);

    public ArrayList<Estudiante> listarPersonasByNombre(String nombre);

    public ArrayList<Curso> listarCursosByNombre(String nombreProfesor);

}
