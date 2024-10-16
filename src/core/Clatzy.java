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
        Curso curso = new Curso(id, nombre, date, precio, instructor, null, false);
        if (!this.cursos.contains(curso)) {
            this.cursos.add(curso);
            return true;
        }
        return false;
    }

    public boolean addPlan(String nombre, LocalDate date, int precio, float valorMaximo) {
        Plan plan = new Plan(nombre, date, precio, valorMaximo, 0, null, false);
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

    public Plan getPlan(int index) {
        return this.planes.get(index);
    }

    /*public Plan getPlan(int index) {
        for (Plan planc : this.planes) {
            if (planc.getId() == index) {
                return planc;
            }
        }
        return null;
    }*/
    public boolean comprarPlan(Cliente cliente, Plan plan, LocalDate date) {
        for (PlanCliente pc : cliente.getPlanes()) {
            if (pc.isEstadoActivo()) {
                System.out.println("El cliente " + cliente.getNombre() + " ya tiene un plan activo");
                return false;
            }
        }
        PlanCliente planCliente = new PlanCliente(cliente, plan, date, true, 0, "", null, 0);
        System.out.println("El cliente " + cliente.getNombre() + " compro exitosamente un plan " + plan.getNombre());
        cliente.addPlan(planCliente);
        return true;
    }

    public Curso getCurso(int index) {
        return this.cursos.get(index);
    }

    public void comprarCurso(Cliente cliente, Curso curso, LocalDate date) {
        for (PlanCliente pc : cliente.getPlanes()) {
            if (pc.isEstadoActivo()) {
                if (cliente.getProductoCliente(curso)) {
                    System.out.println("El cliente " + cliente.getNombre() + " ya habia registrado el curso " + curso.getNombre());
                    break;
                }
                // Verifica si el curso está cubierto por el plan
                if (curso.getValor() <= pc.getPlan().getValorMaximoCurso()) {
                    ProductoCliente productoCliente = new ProductoCliente(cliente, curso, date, 0, true);
                    cliente.addProducto(productoCliente);
                    System.out.println("El cliente " + cliente.getNombre() + " registro exitosamente el curso " + curso.getNombre());
                } else {
                    System.out.println("El plan del cliente " + cliente.getNombre() + " no cubre el curso " + curso.getNombre());
                }
                // Verifica si el cliente ya tiene el curso registrado

            }
        }

    }

    public void comprarCurso(Cliente cliente, Curso curso, LocalDate date, int pago) {
        PlanCliente planCliente = null;
        for (PlanCliente pc : cliente.getPlanes()) {
            if (pc.isEstadoActivo()) {
                planCliente = pc;
            }
        }
        if (cliente.getProductoCliente(curso)) {
            System.out.println("El cliente " + cliente.getNombre() + " ya habia comprado el curso " + curso.getNombre());
        } else {
            if (cliente.hasEstadoActivo()) {
                System.out.println(curso.getValor() + " <= " + cliente.getPlan().getPlan().getValorMaximoCurso());
                if (curso.getValor() <= cliente.getPlan().getPlan().getValorMaximoCurso()) {
                    System.out.println("El curso esta incluido en el plan del cliente " + cliente.getNombre() + ", por lo tanto no debe pagar. Se procede a registrar el curso " + curso.getNombre() + " con costo $0");
                    ProductoCliente productoCliente = new ProductoCliente(cliente, curso, date, 0, true);
                    if (!cliente.getProductos().contains(curso)) {
                        cliente.addProducto(productoCliente);
                    }
                } else {
                    ProductoCliente productoCliente = new ProductoCliente(cliente, curso, date, pago, true);
                    System.out.println("El cliente " + cliente.getNombre() + " compro exitosamente el curso " + curso.getNombre());
                    if (!cliente.getProductos().contains(curso)) {
                        cliente.addProducto(productoCliente);
                    }
                }
            } else {
                if (curso.getValor() != pago) {
                    System.out.println("El cliente " + cliente.getNombre() + " no pago el valor correcto por el curso " + curso.getNombre());
                } else {
                    ProductoCliente productoCliente = new ProductoCliente(cliente, curso, date, pago, true);
                    System.out.println("El cliente " + cliente.getNombre() + " compro exitosamente el curso " + curso.getNombre());
                    if (!cliente.getProductos().contains(curso)) {
                        cliente.addProducto(productoCliente);
                    }
                }
            }
        }
    }

}
