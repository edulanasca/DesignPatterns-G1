package tienda.models;

import java.util.List;

public abstract class MantenimientoProducto {
    
    public abstract String getPeriodo();

    public abstract List<String> tareasMantenimiento();
}