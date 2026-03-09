package es.fplumara.dam1.alumnos.service;

import es.fplumara.dam1.alumnos.model.Curso;

import java.util.List;

public interface CursoService {

    public void crearCurso(Curso curso);

    public void activar (int id);

    public void eliminarSiNombreContiene( String texto);

    List<Curso> listarPorEstado(boolean activo);

    List<Curso> listarOrdenadoPor(String campo, String orden);


}
