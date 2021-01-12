package segurosxy.cliente.model;

import segurosxy.modelos.patrones.mediator.ICorredorMediator;

public class ClienteAsegurado extends Cliente {

    public ClienteAsegurado(String nombre, ICorredorMediator correoMediator) {

        super(nombre, correoMediator);
    }

    public void notifica(){
        super.notifica();
        enviaCorreo();
    }

    public void enviaCorreo()    {

        correoMediator.setServidorCorreoSMTP("localhost");
        correoMediator.enviaCorreoSMTP(this);
    }
}
