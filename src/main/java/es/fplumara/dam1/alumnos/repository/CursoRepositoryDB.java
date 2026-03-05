package es.fplumara.dam1.alumnos.repository;

import es.fplumara.dam1.alumnos.model.Curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CursoRepositoryDB implements CursoRepository{

    private final String url;
    private final String user;
    private final String pass;

    public CursoRepositoryDB(String url, String user, String pass){
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    private final Connection getConnetion() throws SQLException {

        return DriverManager.getConnection(url,user,pass);
    }

    //métodos

    public void crearCurso(Curso curso){

        String sql = "INSERT INTO cursos (id, nombre, activo) VALUES(?,?,?)";
        try(PreparedStatement ps = getConnetion().prepareStatement(sql)){
            ps.setInt(1, curso.getId());
            ps.set

        }catch(SQLException e){

            System.out.println("Error al crear el curso: " + e.getMessage());
        }


    }

}
