package segurosxy.modelos.patrones;


import segurosxy.cliente.model.PersonaObserver;

public interface ICorredorMediator {

    void setServidorCorreoSMTP(String servidorIP);

    void enviaCorreoSMTP(PersonaObserver cliente);

}
