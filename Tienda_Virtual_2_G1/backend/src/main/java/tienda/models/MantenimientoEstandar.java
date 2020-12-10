package tienda.models;

import java.util.ArrayList;
import java.util.List;

public class MantenimientoEstandar extends MantenimientoProducto {
    

    @Override
    public String getPeriodo() {
        
        return "3 meses";
    }

    @Override
    public List<String> tareasMantenimiento() {
        
        List<String> tasks = new ArrayList<>();
        tasks.add("Revision por garantía");
        tasks.add("Fallas de fábrica");
        return tasks;
    }

}