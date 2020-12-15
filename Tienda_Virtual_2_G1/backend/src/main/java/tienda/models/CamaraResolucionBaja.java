package tienda.models;

public class CamaraResolucionBaja extends CamaraProducto{

    @Override
    public String getCamaraFrontal() {
        return "Camara de 5 Mpx";
    }

    @Override
    public String getCamaraTrasera() {
        return "Camara de 12 Mpx";
    }
}
