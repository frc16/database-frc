package es.fplumara.dam1.alumnos;

import es.fplumara.dam1.alumnos.model.Alumno;
import es.fplumara.dam1.alumnos.model.Curso;
import es.fplumara.dam1.alumnos.repository.AlumnoRepository;
import es.fplumara.dam1.alumnos.repository.AlumnoRepositoryDB;
import es.fplumara.dam1.alumnos.repository.AlumnoRepositoryInMemory;
import es.fplumara.dam1.alumnos.service.AlumnoService;
import es.fplumara.dam1.alumnos.service.AlumnoServiceImpl;
import es.fplumara.dam1.alumnos.service.CursoServiceImpl;

public class Main {

    public static void main(String[] args) {
        String url  = System.getenv().getOrDefault("DB_URL","jdbc:mysql://localhost:3306/alumnos");
        String user = System.getenv().getOrDefault("DB_USER","dam1");
        String pass = System.getenv().getOrDefault("DB_PASS","dam1");


        //iniciar servicios
        AlumnoRepository alumnoRepo = new AlumnoRepositoryDB(url, user, pass);
        alumnoRepo.initSchema();                                                      //crea tabla "alumno" si no existe.

        AlumnoService service = new AlumnoServiceImpl(alumnoRepo);
        CursoServiceImpl cursoService = new CursoServiceImpl(url, user, pass);

        //pruebas de alumnos

        System.out.println("================ALUMNOS=================");

        Alumno a1 = new Alumno(null, "John", "Doe", 2015);
        Alumno a2 = new Alumno(null, "Jane", "Doe", 2018);
        Alumno a3 = new Alumno(null, "Tim", "Roe", 2016);

        service.crearAlumno(a1);
        service.crearAlumno(a2);
        service.crearAlumno(a3);

        System.out.println("=== LISTA DE ALUMNOS ===");
        service.getAlumnos().forEach(a ->
                System.out.println(a.getId() + " -> " + a.getNombre() + " " + a.getApellidos() + " (" + a.getAnioNacimiento() + ")")
        );

        System.out.println("\n=== BUSCAR ALUMNO ID 2 ===");
        Alumno buscado = service.getAlumno(2);
        System.out.println(buscado.getId() + " -> " + buscado.getNombre() + " " + buscado.getApellidos());

        System.out.println("\n=== MODIFICAR ALUMNO ID 2 ===");
        Alumno modificado = new Alumno(2, "Jane", "Doe", 2009); // ejemplo: cambia año
        service.modificarAlumno(modificado);

        System.out.println("\n=== LISTA TRAS MODIFICAR ===");
        service.getAlumnos().forEach(a ->
                System.out.println(a.getId() + " -> " + a.getNombre() + " " + a.getApellidos() + " (" + a.getAnioNacimiento() + ")")
        );


        System.out.println("==============CURSOS=============");

        Curso c1 = new Curso(0, "DAM1 - Programación", true);
        Curso c2 = new Curso(0, "DAM1 - base de datos", true);
        Curso c3 = new Curso(0, "DAM1 - Sistemas", true);

        cursoService.crearCurso(c1);
        cursoService.crearCurso(c2);
        cursoService.crearCurso(c3);

        System.out.println("\n--- Cursos activos ---");
        cursoService.listarPorEstado(true).forEach(System.out::println);

        System.out.println("\n--- Cursos inactivos ---");
        cursoService.listarPorEstado(false).forEach(System.out::println);

        System.out.println("\n--- Activar curso con id 3 ---");
        cursoService.activar(3);
        cursoService.listarPorEstado(true).forEach(System.out::println);

        System.out.println("\n--- Cursos ordenados por nombre ASC ---");
        cursoService.listarOrdenadoPor("nombre", "ASC").forEach(System.out::println);

        System.out.println("\n--- Eliminar cursos que contienen 'Sistemas' ---");
        cursoService.eliminarSiNombreContiene("Sistemas");
        cursoService.listarPorEstado(true).forEach(System.out::println);
    }
}