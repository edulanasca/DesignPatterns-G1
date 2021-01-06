package tienda.models.patterns.memento;

import java.util.ArrayList;

public class Caretaker {
    private ArrayList<Memento> estadosSalvados = new ArrayList<Memento>();

    public void addMemento(Memento m) {
        estadosSalvados.add(m);
    }

    public Memento getMemento(int index) {
        return estadosSalvados.get(index);
    }
}