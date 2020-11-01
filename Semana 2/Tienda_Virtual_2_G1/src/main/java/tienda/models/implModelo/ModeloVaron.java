package tienda.models.implModelo;

import tienda.models.interfaces.Modelo;

public class ModeloVaron implements Modelo{
    private String id;
    @Override
    public String printModel() {
        String s ="Modelo: Varon";
        return s;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
