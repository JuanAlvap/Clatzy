package core;

import java.time.LocalDate;

public class ProductoCliente extends Producto {

    private boolean estadoAprovado;
    private int nivelAvance;
    private Cliente cliente;
    private Curso curso;

    public ProductoCliente(Cliente cliente, Curso curso, LocalDate fechaInicio, boolean estadoAprovado, int id, String nombre, LocalDate fechaFin, boolean estadoActivo, float valor) {
        super(id, nombre, fechaInicio, fechaFin, estadoActivo, valor);
        this.estadoAprovado = estadoAprovado;
        this.nivelAvance = 0;
        this.cliente = cliente;
        this.curso = curso;
    }

    public ProductoCliente(Cliente cliente, Curso curso, LocalDate fechaInicio, float valor, boolean estadoAprovado) {
        super(fechaInicio, valor);
        this.estadoAprovado = estadoAprovado;
        this.nivelAvance = 0;
        this.cliente = cliente;
        this.curso = curso;

        this.cliente.addProducto(this);
        this.curso.addProducto(this);
    }

    public Curso getCurso() {
        return curso;
    }

}
