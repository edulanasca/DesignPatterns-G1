package tienda.models;

public class CamaraResolucionMedia extends CamaraProducto{
    @Override
    public String getCamaraFrontal() {
        return "12 Mpx";
    }

    @Override
    public String getCamaraTrasera() {
        return "16 Mpx";
    }
}
