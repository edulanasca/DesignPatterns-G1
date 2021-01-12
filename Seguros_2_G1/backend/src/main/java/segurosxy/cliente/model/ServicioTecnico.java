package segurosxy.cliente.model;


import segurosxy.modelos.patrones.mediator.CorreoMediator;

public class ServicioTecnico extends PersonaObserver {
    public ServicioTecnico(String nombre) {
        super(nombre);
    }

    public ServicioTecnico(String nombre, CorreoMediator correoMediator) {
        super(nombre, correoMediator);
    }

    @Override
    public void notifica() {
        try {
            System.out.println("[Servicio Tecnico] Notificando al Servicio Tecnico " + getNombre());
        }
        catch(Throwable t) {
            System.out.println("[Servicio Tecnico] Notificacion con error" + t.getMessage() );
        }
    }
}
