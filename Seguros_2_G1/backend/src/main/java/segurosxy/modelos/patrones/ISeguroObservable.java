package segurosxy.modelos.patrones;

import segurosxy.cliente.model.PersonaObserver;

public interface ISeguroObservable {

    void addObserver(PersonaObserver observer);
    void removeObserver(PersonaObserver observer);
    
}