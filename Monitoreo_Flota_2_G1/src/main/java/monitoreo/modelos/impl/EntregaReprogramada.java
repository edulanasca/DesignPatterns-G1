package monitoreo.modelos.impl;

public class EntregaReprogramada extends EntregaGeneral{


    public EntregaReprogramada(String rangoHora, String fecha) {
        super(rangoHora, fecha);
        costoReprogramacion();
    }

    @Override
    public void listarEntrega() {
        System.out.println("[Entrega Reprogramada] Entrega planificada: " + this.fecha + " - " + this.rangoHora);
    }

    private void costoReprogramacion(){
        this.costo = this.costo + 30.10;
    }
}
