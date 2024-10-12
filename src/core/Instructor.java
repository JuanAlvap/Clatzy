package core;

import java.util.ArrayList;

public class Instructor extends Persona{
    private ArrayList<Curso> cursos;

    public Instructor(String nombre, String cedula, String telefono, String email) {
        super(nombre, cedula, telefono, email);
        this.cursos = new ArrayList<>();
    }

    
    
}
