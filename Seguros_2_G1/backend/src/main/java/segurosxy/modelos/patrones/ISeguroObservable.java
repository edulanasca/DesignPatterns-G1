package segurosxy.modelos.patrones;

public interface ISeguroObservable {

    void addObserver(IClienteObserver observer);
    void removeObserver(IClienteObserver observer);
    
}