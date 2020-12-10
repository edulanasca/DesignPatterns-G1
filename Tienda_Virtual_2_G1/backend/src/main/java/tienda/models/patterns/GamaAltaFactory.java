package tienda.models.patterns;

import tienda.models.*;

public class GamaAltaFactory implements IProductoFactory {

    @Override
    public LineaProducto getLineaProducto() {
        
        return new LineaGamaAlta();
    }

    @Override
    public MantenimientoProducto getMantenimiento() {
        
        return new MantenimientoPremium();
    }

    
}