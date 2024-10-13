package core;

public abstract class Persona {
    
    protected String nombre;
    protected String cedula;
    protected String telefono;
    protected String email;

    public Persona(String nombre, String cedula, String telefono, String email) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.email = email;
    }

}
