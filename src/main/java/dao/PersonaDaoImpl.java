package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conection.BDConection;
import idao.IPersonaDAO;
import model.Curso;
import model.Direccion;
import model.Estudiante;
import model.Persona;
import model.Profesor;

public class PersonaDaoImpl implements IPersonaDAO {

    BDConection ObjConection = new BDConection();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public ArrayList<Persona> listarPersonas() {
        try {
            conn = ObjConection.getConnection();
            String sqlEstuadiantes = "SELECT * FROM estudiantes";

            ps = conn.prepareStatement(sqlEstuadiantes);
            rs = ps.executeQuery();

            ArrayList<Persona> lista = new ArrayList<Persona>();
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setCodigo(rs.getString("codigo"));
                estudiante.setSerie(rs.getString("serie"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                lista.add(estudiante);
            }

            String sqlProfesores = "SELECT * FROM profesor";

            ps = conn.prepareStatement(sqlProfesores);
            rs = ps.executeQuery();

            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setNombre(rs.getString("nombre"));
                profesor.setTelefono(rs.getString("telefono"));
                profesor.setEmail(rs.getString("email"));
                profesor.setSalario(rs.getFloat("salario"));
                lista.add(profesor);
            }
            conn.close();

            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar personas : " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Curso> listarCursosByNombre(String nombreProfesor){
                try {
            conn = ObjConection.getConnection();
            String sqlEstuadiantes = "select curso.* from profesor , curso where id = profesorid and profesor.nombre like ?";
            ps = conn.prepareStatement(sqlEstuadiantes);
            ps.setString(1, "%" + nombreProfesor + "%");
            rs = ps.executeQuery();

            ArrayList<Curso> lista = new ArrayList<Curso>();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setCodigo(rs.getString("cursoid"));
                curso.setNombre(rs.getString("nombre"));
                curso.setCredito(rs.getString("credito"));
                lista.add(curso);
            }          
            conn.close();

            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar personas : " + e.getMessage());
            return null;
        }
    }
    @Override
    public ArrayList<Estudiante> listarPersonasByNombre(String nombre) {
        try {
            conn = ObjConection.getConnection();
            String sqlEstuadiantes = "SELECT * FROM estudiantes where nombre like ?";
            ps = conn.prepareStatement(sqlEstuadiantes);
            ps.setString(1, "%" + nombre + "%");
            rs = ps.executeQuery();

            ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setCodigo(rs.getString("codigo"));
                estudiante.setSerie(rs.getString("serie"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                lista.add(estudiante);
            }          
            conn.close();

            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar personas : " + e.getMessage());
            return null;
        }
    }

    @Override
    public Persona buscarEstudiante(String codigo) {

        try {
            conn = ObjConection.getConnection();
            String sql = "SELECT * FROM estudiantes WHERE codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            Estudiante estudiante = new Estudiante();
            while (rs.next()) {
                estudiante.setCodigo(rs.getString("codigo"));
                estudiante.setSerie(rs.getString("serie"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
            }
            conn.close();
            return estudiante;
        } catch (Exception e) {
            System.out.println("Error al buscar estudiante : " + e.getMessage());
            return null;
        }
    }

    @Override
    public Direccion obtenerDireccion(Estudiante estudiante) {

        try {
            conn = ObjConection.getConnection();
            String sql = "SELECT D.calle, D.ciudad, D.estado, D.codigo_postal, D.pais  FROM estudiantes AS E INNER JOIN direcciones AS D ON E.direccion_id = D.id WHERE E.codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, estudiante.getCodigo());
            rs = ps.executeQuery();

            Direccion direccion = new Direccion();
            while (rs.next()) {

                direccion.setCalle(rs.getString("calle"));
                direccion.setCiudad(rs.getString("ciudad"));
                direccion.setEstado(rs.getString("estado"));
                direccion.setCodigoPostal(rs.getString("codigo_postal"));
                direccion.setPais(rs.getString("pais"));
            }
            conn.close();
            return direccion;
        } catch (Exception e) {
            System.out.println("Error al obtener direccion : " + e.getMessage());
            return null;
        }
    }

}
