package tienda.models.patterns;

import java.util.ArrayList;

public class CaretakerPrecio {

    private String id;
    private ArrayList<MementoPrecio> mementos = new ArrayList<>();

    public CaretakerPrecio()    {
        
    }

    public void addMementoPrecio(MementoPrecio m) {
        mementos.add(m);
    }

    public MementoPrecio ultimoMementoPrecio() {
        return mementos.get(1);
    }

    public MementoPrecio unMementoPrecio(int historia) {
        return mementos.get(historia);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
