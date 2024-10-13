package core;

import java.time.LocalDate;

public class PlanCliente extends Producto{
    
    private Cliente cliente;
    private Plan plan;

    public PlanCliente(Cliente cliente, Plan plan, LocalDate fechaInicio, boolean estadoActivo) {
        super(fechaInicio, estadoActivo);
        this.cliente = cliente;
        this.plan = plan;
        
        this.cliente.addPlan(this);
        this.plan.addPlanCliente(this);
    }

    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    @Override
    public boolean isEstadoActivo() {
        return super.isEstadoActivo();
    }

    

    public String getNombre() {
        return nombre;
    }

    @Override
    public float getValor() {
        return super.getValor();
    }

    public Plan getPlan() {
        return plan;
    }

}
