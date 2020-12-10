package tienda.models.patterns;

import tienda.models.BateriaProducto;
import tienda.models.CamaraProducto;
import tienda.models.LineaProducto;
import tienda.models.MantenimientoProducto;

public interface IProductoFactory {

    LineaProducto getLineaProducto();

    MantenimientoProducto getMantenimiento();

    BateriaProducto getBateria();

    CamaraProducto getCamaraProducto();


}