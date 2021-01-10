package segurosxy.modelos.patrones;


import segurosxy.cliente.model.Cliente;
import segurosxy.cliente.model.Persona;

public interface ICorredorMediator {

    void setServidorCorreoSMTP(String servidorIP);

    void enviaCorreoSMTP(Persona cliente);

}
