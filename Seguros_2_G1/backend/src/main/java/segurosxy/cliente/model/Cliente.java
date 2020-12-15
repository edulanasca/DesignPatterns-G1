package segurosxy.cliente.model;

import lombok.Data;
import org.bson.types.ObjectId;
import segurosxy.modelos.patrones.PaisContext;
import segurosxy.modelos.patrones.UbigeoContext;
import segurosxy.seguro.Seguro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Cliente {

    private String id;
    private Map<String, UbigeoContext> ubigeos;
    private String nombre;
    private List<Seguro> seguros;
    private Map<String, PaisContext> paises;

    public Cliente(String nombre)   {
        id = new ObjectId().toString();
        this.nombre = nombre;
        this.seguros = new ArrayList<>();
        this.ubigeos = new HashMap<>();
        this.paises = new HashMap<>();
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

    public void printUbigeos(){

        for (Map.Entry<String, UbigeoContext> ubigeo : this.ubigeos.entrySet()) {
            System.out.println("[Ubigeo] " + ubigeo.getKey() + ": "
                + ubigeo.getValue().getDepartamento()
                + ubigeo.getValue().getProvincia()
                + ubigeo.getValue().getDistrito());
        }
    }

}
