package segurosxy.cliente.model;

import lombok.Data;
import org.bson.types.ObjectId;
import segurosxy.modelos.patrones.IClienteObserver;
import segurosxy.modelos.patrones.CorreoMediator;
//import segurosxy.modelos.patrones.IClienteObserver;
import segurosxy.modelos.patrones.PaisContext;
import segurosxy.modelos.patrones.UbigeoContext;
import segurosxy.modelos.patrones.mediator.ICorredorMediator;
import segurosxy.seguro.Seguro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Cliente extends PersonaObserver {

//datos de persona
/*  private String id;
    private String nombre;
    protected CorreoMediator correoMediator;*/

//datos de cliente
    private List<Seguro> seguros;
    private Map<String, PaisContext> paises;
    private Map<String, UbigeoContext> ubigeos;

    protected ICorredorMediator correoMediator;

//constructores de cliente
    public Cliente(String nombre)   {
    //se utiliza constructor del persona
        super(nombre);

        this.ubigeos = new HashMap<>();
        this.seguros = new ArrayList<>();
        this.paises = new HashMap<>();
    }

    public Cliente(final String nombre, final ICorredorMediator correoMediator) {
    //se utiliza constructor de persona
        super(nombre,correoMediator);

        this.seguros = new ArrayList<>();
    }

//metodos de cliente
    public void setCompraSeguro(Seguro seguro) {
        this.seguros.add( seguro );
    }
    public void getListaSeguroCliente()    {

        System.out.println("Nombre: " + getNombre());
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

//implementacion de metodos de la interfaz
    @Override
    public void notifica() {
        try {
            System.out.println("[CLiente] Notificando al cliente " + getNombre());
        }
        catch(Throwable t) {
            System.out.println("[Cliente] Notificacion con error" + t.getMessage() );
        }
    }


    //getters de los datos del cliente
    public List<Seguro> getSeguros() {
        return seguros;
    }

    public Map<String, PaisContext> getPaises() {
        return paises;
    }

    public Map<String, UbigeoContext> getUbigeos() {
        return ubigeos;
    }
}
