package core;

import java.time.LocalDate;
import java.util.ArrayList;

public class Curso extends Producto {

    private ArrayList<Instructor> instructores;
    private ArrayList<ProductoCliente> productosClientes;

    public Curso(int id, String nombre, LocalDate fechaInicio, float valor, Instructor instructor, LocalDate fechaFin, boolean estadoActivo) {
        super(id, nombre, fechaInicio, fechaFin, estadoActivo, valor);
        this.instructores = new ArrayList<>();
        this.productosClientes = new ArrayList<>();

        this.instructores.add(instructor);

        this.instructores.get(0).addCurso(this);
    }

    
    
    public Curso(int id, String nombre, LocalDate fechaInicio, float valor, Instructor instructor) {
        super(id, nombre, fechaInicio, valor);
        this.instructores = new ArrayList<>();
        this.productosClientes = new ArrayList<>();

        this.instructores.add(instructor);

        this.instructores.get(0).addCurso(this);
    }

    public int getId() {
        return id;
    }

    public float getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean addProducto(ProductoCliente producto) {
        if (!this.productosClientes.contains(producto)) {
            this.productosClientes.add(producto);
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Curso)) {
            return false;
        }
        Curso curso = (Curso) obj;
        return this.id == curso.id; // Compara solo el ID
    }
}
