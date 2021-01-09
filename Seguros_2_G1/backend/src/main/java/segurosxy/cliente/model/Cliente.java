package segurosxy.cliente.model;

import lombok.Data;
import org.bson.types.ObjectId;
import segurosxy.modelos.patrones.CorreoMediator;
import segurosxy.modelos.patrones.IClienteObserver;
import segurosxy.modelos.patrones.PaisContext;
import segurosxy.modelos.patrones.UbigeoContext;
import segurosxy.seguro.Seguro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Cliente implements IClienteObserver {

    private String id;
    private Map<String, UbigeoContext> ubigeos;
    private String nombre;
    private List<Seguro> seguros;
    private Map<String, PaisContext> paises;

    protected CorreoMediator correoMediator;

    public Cliente(String nombre)   {
        id = new ObjectId().toString();
        this.nombre = nombre;
        this.seguros = new ArrayList<>();
        this.ubigeos = new HashMap<>();
        this.paises = new HashMap<>();
    }

    public Cliente(final String nombre, final CorreoMediator correoMediator) {

        this.nombre = nombre;
        this.correoMediator = correoMediator;
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

    public void printUbigeos(){

        for (Map.Entry<String, UbigeoContext> ubigeo : this.ubigeos.entrySet()) {
            System.out.println("[Ubigeo] " + ubigeo.getKey() + ": "
                + ubigeo.getValue().getDepartamento()
                + ubigeo.getValue().getProvincia()
                + ubigeo.getValue().getDistrito());
        }
    }

    @Override
    public void notifica() {
        try {
            System.out.println("[CLiente] Notificando al cliente " + this.nombre);
        }
        catch(Throwable t) {
            System.out.println("[Cliente] Notificacion con error" + t.getMessage() );
        }
    }
}
