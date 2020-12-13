package tienda.models;

public class CamaraResolucionMedia extends CamaraProducto{
    @Override
    public String getCamaraFrontal() {return "Camara de 12 Mpx";}

    @Override
    public String getCamaraTrasera() {
        return "Camara de 16 Mpx";
    }
}
