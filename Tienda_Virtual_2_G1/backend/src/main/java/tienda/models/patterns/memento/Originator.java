package tienda.models.patterns.memento;

import tienda.models.Cliente;

public class Originator {
    private Cliente cliente;

    public void set(Cliente cliente)
    {
        this.cliente = cliente;
        cliente.toString();

    }

    public Memento guardandoParaMemento()
    {
        System.out.println("Originator: Salvando a Memento.");
        System.out.println(cliente.toString()+"-guardado");
        return new Memento(cliente);
    }

    public Cliente restaurandoDesdeMemento(Memento m)
    {
        System.out.println("-restaurado-");
        return this.cliente = m.getEstado();
    }
}