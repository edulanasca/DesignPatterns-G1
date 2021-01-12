package segurosxy.cliente.model;

import segurosxy.modelos.patrones.CorreoMediator;

public class Contratante extends PersonaObserver {
    public Contratante(String nombre) {
        super(nombre);
    }

    public Contratante(String nombre, CorreoMediator correoMediator) {
        super(nombre, correoMediator);
    }

    @Override
    public void notifica() {
        try {
            System.out.println("[Contratante] Notificando al contratante " + getNombre());
        }
        catch(Throwable t) {
            System.out.println("[Contratante] Notificacion con error" + t.getMessage() );
        }
        //SEGUN LA LOGICA DE NEGOCIO NO SE ENVIA COOREO AL CONTRATANTE
        //enviarCorreo();
    }
    public void enviarCorreo(){
        correoMediator.setServidorCorreoSMTP("smtp.gmail.com");
        correoMediator.enviaCorreoSMTP(this);
    }


}
