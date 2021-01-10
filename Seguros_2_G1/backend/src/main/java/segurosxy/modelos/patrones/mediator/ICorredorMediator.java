package segurosxy.modelos.patrones.mediator;


import segurosxy.cliente.model.Cliente;

public interface ICorredorMediator {

    void setServidorCorreoSMTP(String servidorIP);

    void enviaCorreoSMTP(Cliente cliente);

}
