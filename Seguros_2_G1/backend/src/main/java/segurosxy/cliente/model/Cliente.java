package segurosxy.cliente.model;

import lombok.Data;
import org.bson.types.ObjectId;
import segurosxy.seguro.Seguro;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {

    private String id;
    private String nombre;
    private List<Seguro> seguros;

    public Cliente(String nombre)   {
        id = new ObjectId().toString();
        this.nombre = nombre;
        this.seguros = new ArrayList<>();
    }

    public void setCompraSeguro(Seguro seguro) {
        this.seguros.add( seguro );
    }

    public void getListaSeguroCliente()    {

        System.out.println("Nombre: " + this.nombre );
        for (Seguro seguro : seguros )  {

            System.out.println( "Seguro: " + seguro.detalleSeguro());
        }

    }

}
