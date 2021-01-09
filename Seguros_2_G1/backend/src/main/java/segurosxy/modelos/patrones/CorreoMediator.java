package segurosxy.modelos.patrones;

import segurosxy.cliente.model.Cliente;
import segurosxy.modelos.email.EmailUtil;

public class CorreoMediator implements ICorredorMediator {

    private String servidorSMTP;

    @Override
    public void setServidorCorreoSMTP(String servidorIP) {

        this.servidorSMTP = servidorIP;
    }

    private String preparaMensaje(String nombre)  {
        final StringBuffer salida = new StringBuffer();

        //salida.append("\n================================================================\n");
        salida.append("[CorreoMediator] Enviando mensaje por Correo, servidor IP: "+ servidorSMTP );
        salida.append("\n[CorreoMediator]                                  Cliente: "+ nombre );
        //salida.append("\n================================================================\n");


        return salida.toString();
    }

    @Override
    public void enviaCorreoSMTP(Cliente cliente) {
        // enviando correo...
        System.out.println( preparaMensaje(cliente.getNombre()) );

        try {
            EmailUtil.send(servidorSMTP, "example@gmail.com", "password", "gianmar.sanchez@gmail.com", "hello", preparaMensaje(cliente.getNombre()));
        }catch (Exception e){
            System.out.println("[CorreoMediator][Error] "+ e.toString());
        }
    }

}
