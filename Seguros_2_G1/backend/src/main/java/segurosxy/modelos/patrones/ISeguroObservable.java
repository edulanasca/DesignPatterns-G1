package segurosxy.modelos.patrones;

import segurosxy.cliente.model.Persona;

public interface ISeguroObservable {

    void addObserver(Persona observer);
    void removeObserver(Persona observer);
    
}