package core;

import java.util.ArrayList;

public class Cliente extends Persona {

    private ArrayList<PlanCliente> planes;
    private ArrayList<ProductoCliente> productos;

    public Cliente(String nombre, String cedula, String telefono, String email) {
        super(nombre, cedula, telefono, email);
        this.planes = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public ArrayList<PlanCliente> getPlanes() {
        return planes;
    }

    public boolean addPlan(PlanCliente plan) {
        if (!this.planes.contains(plan)) {
            this.planes.add(plan);
            return true;
        }
        return false;
    }

    public boolean getProductoCliente(Curso curso) {
        for (ProductoCliente producto : this.productos) {
            if (curso == producto.getCurso()) {
                return true;
            }
        }
        return false;
    }

    /*public PlanCliente getPlan(int index) {
        for (PlanCliente planc : this.planes) {
            if (planc.getPlan().getId() == index) {
                return planc;
            }
        }
        return null;
    }*/
    public PlanCliente getPlan(int index) {
        return this.planes.get(index);
    }

    public ArrayList<ProductoCliente> getProductos() {
        return productos;
    }

    public boolean addProducto(ProductoCliente producto) {
        if (!this.productos.contains(producto)) {
            this.productos.add(producto);
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estado() {
        for (PlanCliente plan : this.planes) {
            if (plan.isEstadoActivo()) {
                return true;
            }
        }
        return false;
    }

    public PlanCliente getPlan() {
        for (PlanCliente plan : this.planes) {
            if (plan.isEstadoActivo()) {
                return plan;
            }
        }
        return null;
    }

    public boolean hasEstadoActivo() {
        for (PlanCliente plan : this.planes) {
            return plan.isEstadoActivo();
        }
        return false;
    }

}
