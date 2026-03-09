package es.fplumara.dam1.alumnos.service;

import es.fplumara.dam1.alumnos.model.Curso;
import es.fplumara.dam1.alumnos.repository.CursoRepository;
import es.fplumara.dam1.alumnos.repository.CursoRepositoryDB;

import java.util.List;

public class CursoServiceImpl implements CursoService {

    private CursoRepositoryDB cursoRepository;

    public CursoServiceImpl(){
        this.cursoRepository = new CursoRepositoryDB();
    }
    @Override
    public void crearCurso(Curso curso) {


    }

    @Override
    public void activar(int id) {

    }

    @Override
    public void eliminarSiNombreContiene(String texto) {

    }

    @Override
    public List<Curso> listarPorEstado(boolean activo) {
        return List.of();
    }

    @Override
    public List<Curso> listarOrdenadoPor(String campo, String orden) {
        return List.of();
    }

}
