package core;

import java.time.LocalDate;

public abstract class Producto {
    
    private static boolean estado = false;
    private static float valor2;
    
    protected int id;
    protected String nombre;
    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
    protected boolean estadoActivo;
    protected float valor;

    public Producto(int id, String nombre, LocalDate fechaInicio, float valor) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = null;
        this.estadoActivo = estado;
        this.valor = valor;
        valor2 = valor;
        
        estado = this.estadoActivo;
    }

    public Producto(String nombre, LocalDate fechaInicio,float valor) {
        this.id = 0;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = null;
        this.estadoActivo = estado;
        this.valor = valor;
        valor2 = valor;
        
        estado = this.estadoActivo;
    }

    public Producto(LocalDate fechaInicio, boolean estadoActivo) {
        this.fechaInicio = fechaInicio;
        this.estadoActivo = estadoActivo;
        this.id = 0;
        this.nombre = "";
        this.fechaFin = null;
        this.valor = valor2;
        
        estado = this.estadoActivo;
    }

    public Producto(LocalDate fechaInicio, float valor) {
        this.fechaInicio = fechaInicio;
        this.valor = valor;
        valor2 = valor;
        
        estado = this.estadoActivo;
    }

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public float getValor() {
        return valor;
    }

}
