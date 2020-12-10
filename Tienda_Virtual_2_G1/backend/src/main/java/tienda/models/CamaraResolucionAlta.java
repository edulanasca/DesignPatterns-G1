package tienda.models;

public class CamaraResolucionAlta extends CamaraProducto{

    @Override
    public String getCamaraFrontal() {
        return "16 Mpx";
    }

    @Override
    public String getCamaraTrasera() {
        return "48 Mpx";
    }
}
