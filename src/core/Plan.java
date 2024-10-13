package core;

import java.time.LocalDate;
import java.util.ArrayList;

public class Plan extends Producto {

    private float valorMaximoCurso;
    private ArrayList<PlanCliente> planes;

    public Plan(String nombre, LocalDate fechaInicio,  float valor, float valorMaximoCurso) {
        super(nombre, fechaInicio, valor);
        this.valorMaximoCurso = valorMaximoCurso;
        this.planes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public boolean isEstadoActivo() {
        return super.isEstadoActivo();
    }
    
    public boolean addPlanCliente(PlanCliente plan){
        if(!this.planes.contains(plan)){
            this.planes.add(plan);
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public float getValorMaximoCurso() {
        return valorMaximoCurso;
    }

}
