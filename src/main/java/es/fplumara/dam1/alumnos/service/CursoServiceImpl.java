package es.fplumara.dam1.alumnos.service;

import es.fplumara.dam1.alumnos.model.Curso;
import es.fplumara.dam1.alumnos.repository.CursoRepositoryDB;

import java.util.List;

public class CursoServiceImpl implements CursoService {

    // BUG CORREGIDO: usamos la interfaz, no la implementación concreta
    // y recibimos el repository por constructor (igual que AlumnoServiceImpl)
    private final CursoRepositoryDB cursoRepository;

    // Constructor con parámetros de conexión
    public CursoServiceImpl(String url, String user, String pass) {
        this.cursoRepository = new CursoRepositoryDB(url, user, pass);
        this.cursoRepository.intSchema(); // crea la tabla si no existe
    }

    // =====================================================
    // Crear curso — con validaciones
    // =====================================================
    @Override
    public void crearCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser null");
        }
        if (curso.getNombre() == null || curso.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del curso no puede estar vacío");
        }
        cursoRepository.crearCurso(curso);
        System.out.println("✅ Curso creado: " + curso.getNombre());
    }

    // =====================================================
    // Activar curso por id
    // =====================================================
    @Override
    public void activar(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser un entero positivo");
        }
        cursoRepository.activar(id);
        System.out.println("✅ Curso con id " + id + " activado");
    }

    // =====================================================
    // Eliminar cursos cuyo nombre contiene el texto
    // =====================================================
    @Override
    public void eliminarSiNombreContiene(String texto) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("El texto de búsqueda no puede estar vacío");
        }
        cursoRepository.eliminarSiNombreContiene(texto);
        System.out.println("✅ Cursos que contenían '" + texto + "' eliminados");
    }

    // =====================================================
    // Listar por estado activo/inactivo
    // =====================================================
    @Override
    public List<Curso> listarPorEstado(boolean activo) {
        return cursoRepository.listarPorEstado(activo);
    }

    // =====================================================
    // Listar ordenado por campo y dirección
    // =====================================================
    @Override
    public List<Curso> listarOrdenadoPor(String campo, String orden) {
        if (campo == null || campo.isBlank()) {
            throw new IllegalArgumentException("El campo no puede estar vacío");
        }
        if (orden == null || orden.isBlank()) {
            throw new IllegalArgumentException("El orden no puede estar vacío");
        }
        return cursoRepository.listarOrdenadoPor(campo, orden);
    }
}
