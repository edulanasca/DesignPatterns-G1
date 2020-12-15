package tienda.models;

public class CamaraResolucionAlta extends CamaraProducto{

    @Override
    public String getCamaraFrontal() {
        return "Camara de 16 Mpx";
    }

    @Override
    public String getCamaraTrasera() {
        return "Camara de 48 Mpx";
    }
}
