package tienda.models.patterns;

import tienda.models.*;

public class GamaBajaFactory implements IProductoFactory {

    @Override
    public LineaProducto getLineaProducto() {

        return new LineaGamaBaja();
    }

    @Override
    public MantenimientoProducto getMantenimiento() {

        return new MantenimientoEstandar();
    }

    @Override
    public BateriaProducto getBateria() {
        return new BateriaDuracionBaja();
    }

    @Override
    public CamaraProducto getCamaraProducto() {
        return new CamaraResolucionBaja();
    }

}