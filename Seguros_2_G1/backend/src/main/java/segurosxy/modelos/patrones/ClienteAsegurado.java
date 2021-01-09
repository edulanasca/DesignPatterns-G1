package segurosxy.modelos.patrones;

import segurosxy.cliente.model.Cliente;

public class ClienteAsegurado extends Cliente {

    public ClienteAsegurado(String nombre, CorreoMediator correoMediator) {

        super(nombre, correoMediator);
    }

    public void notifica(){
        super.notifica();
        enviaCorreo();
    }

    public void enviaCorreo()    {

        correoMediator.setServidorCorreoSMTP("smtp.gmail.com");
        correoMediator.enviaCorreoSMTP(this);
    }
}
