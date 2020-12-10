package tienda.models.patterns;

import tienda.models.LineaProducto;
import tienda.models.MantenimientoProducto;

public interface IProductoFactory {

    LineaProducto getLineaProducto();

    MantenimientoProducto getMantenimiento();

}