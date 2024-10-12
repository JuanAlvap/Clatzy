package core;

import java.time.LocalDate;
import java.util.ArrayList;

public class Curso extends Producto {

    private ArrayList<Instructor> instructores;
    private ArrayList<ProductoCliente> productosClientes;

    public Curso(int id, String nombre, LocalDate fechaInicio, float valor, Instructor instructor) {
        super(id, nombre, fechaInicio, valor);
        this.instructores = new ArrayList<>();
        this.productosClientes = new ArrayList<>();

        this.instructores.add(instructor);
    }

    public boolean addInstructor(Instructor instructor) {
        if (!this.instructores.contains(instructor)) {
            this.instructores.add(instructor);
            return true;
        }
        return false;
    }

}
