package tienda.models.patterns.memento;

import tienda.models.Cliente;

public class Memento {
    private Cliente cliente;

    public Memento(Cliente clieneteParaSalvar)
    {
        this.cliente = clieneteParaSalvar;
    }

    public Cliente getEstado()
    {
        return this.cliente;
    }
}
