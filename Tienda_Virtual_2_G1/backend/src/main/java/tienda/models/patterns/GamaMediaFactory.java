package tienda.models.patterns;

import tienda.models.*;

public class GamaMediaFactory implements IProductoFactory{

    @Override
    public LineaProducto getLineaProducto() {
        return new LineaGamaMedia();
    }

    @Override
    public MantenimientoProducto getMantenimiento() {
        return new MantenimientoEstandar();
    }

    @Override
    public BateriaProducto getBateria() {
        return new BateriaDuracionMedia();
    }

    @Override
    public CamaraProducto getCamaraProducto() {
        return new CamaraResolucionMedia();
    }
}
