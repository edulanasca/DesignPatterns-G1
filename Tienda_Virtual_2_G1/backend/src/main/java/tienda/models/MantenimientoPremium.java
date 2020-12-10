package tienda.models;

import java.util.ArrayList;
import java.util.List;

public class MantenimientoPremium extends MantenimientoProducto {

    @Override
    public String getPeriodo() {
        
        return "12 meses";
    }

    @Override
    public List<String> tareasMantenimiento() {
        
        List<String> tasks = new ArrayList<>();
        tasks.add("Revisión por garantía");
        tasks.add("Daños cubiertos");
        return tasks;
    }

    
}