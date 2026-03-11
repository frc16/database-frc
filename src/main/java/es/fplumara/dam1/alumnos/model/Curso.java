package es.fplumara.dam1.alumnos.model;

import static java.lang.Boolean.TRUE;

public class Curso {

    private int id;
    private String nombre;
    private boolean activo;


    //constructor
    public Curso(int id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Curso() {

    }

    // getters and setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public boolean isActivo() {
        return activo;
    }
    public void setaActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void validar(){
        if(nombre==null||nombre.isBlank()){
            throw new IllegalArgumentException("el nombre del curso no puede estar en blanco");
        }
        if(nombre.length()>100){
            throw new IllegalArgumentException("el nombre no puede ser superior a 100 caracteres");
        }

    }

    @Override

    public String toString (){
        return "Curso{id= " + id + ", nombre='" + nombre + "'" + "activo= " + activo + "}";
    }
}




