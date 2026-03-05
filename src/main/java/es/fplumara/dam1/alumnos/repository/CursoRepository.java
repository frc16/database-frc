package es.fplumara.dam1.alumnos.repository;

import es.fplumara.dam1.alumnos.model.Alumno;
import es.fplumara.dam1.alumnos.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoRepository{

    public  void intSchema();

    public void crearCurso(Curso curso);

    public void actviar(int id);

    public void eliminarSiNombreContiene(String texto);

    List<Curso> listarPorEstado(boolean activo);

    List<Curso> listarOrdenadoPor();




}
