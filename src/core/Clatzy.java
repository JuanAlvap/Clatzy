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

    public boolean addInstructor(String nombre, String cedula, String telefono, String email) {
        Instructor instructor = new Instructor(nombre, cedula, telefono, email);
        boolean existCedula = false;
        if (!this.instructores.contains(instructor)) {
            this.instructores.add(instructor);
            return true;
        }
        return false;
    }

    public Instructor getInstructor(int index) {
        return this.instructores.get(index);
    }

    public boolean addCurso(int id, String nombre, LocalDate date, int precio, Instructor instructor) {
        Curso curso = new Curso(id, nombre, date, precio, instructor);
        boolean existID = false;
        if (!this.cursos.contains(curso)) {
            this.cursos.add(curso);
            return true;
        }
        return false;
    }

    public boolean addPlan(String nombre, LocalDate date, int precio, float valorMaximo) {
        Plan plan = new Plan(nombre, date, precio, valorMaximo);
        boolean existNombre = false;
        if (!this.planes.contains(plan)) {
            this.planes.add(plan);
            return true;
        }
        return false;
    }

    public boolean addCliente(String nombre, String cedula, String telefono, String email) {
        Cliente cliente = new Cliente(nombre, cedula, telefono, email);
        boolean existCedula = false;
        if (!this.clientes.contains(cliente)) {
            this.clientes.add(cliente);
            return true;
        }
        return false;
    }

    public Cliente getCliente(int index) {
        return this.clientes.get(index);
    }

    /*public Plan getPlan(int index) {
        return this.planes.get(index);
    }*/
    public Plan getPlan(int index) {
        for (Plan planc : this.planes) {
            if (planc.getId() == index) {
                return planc;
            }
        }
        return null;
    }

    public boolean comprarPlan(Cliente cliente, Plan plan, LocalDate date) {
        for (PlanCliente pc : cliente.getPlanes()) {
            if (pc.isEstadoActivo()) {
                System.out.println("El cliente " + cliente.getNombre() + " ya tiene un plan activo");
                return false;
            }
        }
        PlanCliente planCliente = new PlanCliente(cliente, plan, date, true);
        System.out.println("El cliente " + cliente.getNombre() + " compro exitosamente un plan " + plan.getNombre());
        cliente.addPlan(planCliente);
        return true;
    }

    public Curso getCurso(int index) {
        return this.cursos.get(index);
    }

    public boolean comprarCurso(Cliente cliente, Curso curso, LocalDate date) {
        for (PlanCliente pc : cliente.getPlanes()) {
            if (pc.isEstadoActivo()) {
                // Verifica si el curso está cubierto por el plan
                if (curso.getValor() > pc.getPlan().getValorMaximoCurso()) {
                    System.out.println("El plan del cliente " + cliente.getNombre() + " no cubre el curso " + curso.getNombre());
                    return false;
                }
                // Verifica si el cliente ya tiene el curso registrado
                for (ProductoCliente producto : cliente.getProductos()) {
                    if (producto.getCurso().equals(curso)) {
                        System.out.println("El cliente " + cliente.getNombre() + " ya había registrado el curso " + curso.getNombre());
                        return false;
                    }
                }
                // Si no hay problemas, registra el curso
                ProductoCliente productoCliente = new ProductoCliente(cliente, curso, date, 0, true);
                cliente.addProducto(productoCliente);
                System.out.println("El cliente " + cliente.getNombre() + " registró exitosamente el curso " + curso.getNombre());
                return true;
            }
        }
        System.out.println("El cliente " + cliente.getNombre() + " no tiene un plan activo.");
        return false;
    }

    public boolean comprarCurso(Cliente cliente, Curso curso, LocalDate date, int pago) {
        for (PlanCliente pc : cliente.getPlanes()) {
            if (pc.isEstadoActivo()) {
                if (curso.getValor() <= pc.getPlan().getValorMaximoCurso()) {
                    System.out.println("El curso esta incluido en el plan del cliente " + cliente.getNombre() + ", por lo tanto no debe pagar. Se procede a registrar el curso " + curso.getNombre() + " con costo $0");
                    ProductoCliente productoCliente2 = new ProductoCliente(cliente, curso, date, 0, true);
                    if (!cliente.getProductos().contains(curso)) {
                        cliente.addProducto(productoCliente2);
                        return true;
                    }
                } else if (curso.getValor() != pago) {
                    System.out.println("El cliente " + cliente.getNombre() + " no pago el valor correcto por el curso " + curso.getNombre());
                    return false;
                } else if (!cliente.getProductos().contains(curso)) {
                    ProductoCliente productoCliente = new ProductoCliente(cliente, curso, date, pago, true);
                    cliente.addProducto(productoCliente);
                    System.out.println("El cliente " + cliente.getNombre() + " compro exitosamente el curso " + curso.getNombre());
                    return true;
                }
            }
        }
        System.out.println("El cliente " + cliente.getNombre() + " ya habia comprado el curso " + curso.getNombre());
        return false;
    }

}
