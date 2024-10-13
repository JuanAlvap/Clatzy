package core;

import java.util.ArrayList;

public class Instructor extends Persona{
    private ArrayList<Curso> cursos;

    public Instructor(String nombre, String cedula, String telefono, String email) {
        super(nombre, cedula, telefono, email);
        this.cursos = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public boolean addCurso(Curso curso){
        if(!this.cursos.contains(curso)){
            this.cursos.add(curso);
            return true;
        }
        return false;
    }
    
}
