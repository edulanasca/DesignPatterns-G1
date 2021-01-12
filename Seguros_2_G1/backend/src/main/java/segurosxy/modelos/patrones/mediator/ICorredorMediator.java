package segurosxy.modelos.patrones.mediator;


import segurosxy.cliente.model.PersonaObserver;

public interface ICorredorMediator {

    void setServidorCorreoSMTP(String servidorIP);

    void enviaCorreoSMTP(PersonaObserver cliente);

}
