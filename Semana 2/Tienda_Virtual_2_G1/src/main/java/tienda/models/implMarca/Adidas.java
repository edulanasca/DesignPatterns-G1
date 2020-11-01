package tienda.models.implMarca;
import tienda.models.interfaces.Marca;
public class Adidas implements Marca{
    private String id;
    private Double comision = 0.08;
    @Override
    public String printMarca() {
        String s="Marca: Adidas";
        return s;
    }    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Double getComision() {
        return comision;
    }
    public void setComision(Double comision) {
        this.comision = comision;
    }
}
