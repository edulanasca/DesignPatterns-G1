package tienda.models.implModelo;

import tienda.models.interfaces.Modelo;

public class ModeloMujer implements Modelo{
    private String id;
    @Override
    public String printModel() {
        String s ="Modelo: Mujer";
        return s;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
