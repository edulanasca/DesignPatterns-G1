package tienda.models;

public class CamaraResolucionBaja extends CamaraProducto{

    @Override
    public String getCamaraFrontal() {
        return "5 Mpx";
    }

    @Override
    public String getCamaraTrasera() {
        return "12 Mpx";
    }
}
