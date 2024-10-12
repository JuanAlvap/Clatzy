package core;

import java.time.LocalDate;
import java.util.ArrayList;

public class Clatzy {

    private ArrayList<Cliente> clientes;
    private ArrayList<Instructor> instructores;
    private ArrayList<Curso> cursos;
    private ArrayList<Plan> planes;

    public Clatzy() {
        this.clientes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.planes = new ArrayList<>();
        this.instructores = new ArrayList<>();
    }
    
    //Verificar .contains()
    public boolean addInstructor(String nombre, String cedula, String telefono, String email) {
        Instructor instructor = new Instructor(nombre, cedula, telefono, email);
        if (!this.instructores.contains(instructor)) {
            this.instructores.add(instructor);
            return true;
        }
        return false;
    }
    
    public Instructor getInstructor(int index){
        return this.instructores.get(index);
    }
    
    //Verificar .contains()
    public boolean addCurso(int id, String nombre, LocalDate date, int precio, Instructor instructor){
        Curso curso = new Curso(id, nombre, date, precio, instructor);
        if (!this.cursos.contains(curso)){
            this.cursos.add(curso);
            return true;
        }
        return false;
    }

}
