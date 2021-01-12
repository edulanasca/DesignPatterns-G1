package segurosxy.cliente.model;

import segurosxy.modelos.patrones.CorreoMediator;

public class Beneficiario extends PersonaObserver {
    public Beneficiario(String nombre) {
        super(nombre);
    }

    public Beneficiario(String nombre, CorreoMediator correoMediator) {
        super(nombre, correoMediator);
    }

    @Override
    public void notifica() {
        try {
            System.out.println("[Beneficiario] Notificando al Beneficiario " + getNombre());
        }
        catch(Throwable t) {
            System.out.println("[Beneficiario] Notificacion con error" + t.getMessage() );
        }
        enviarCorreo();
    }
    public void enviarCorreo(){
        correoMediator.setServidorCorreoSMTP("smtp.gmail.com");
        correoMediator.enviaCorreoSMTP(this);
    }
}
