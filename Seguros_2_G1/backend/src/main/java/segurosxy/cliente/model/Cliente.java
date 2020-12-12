package segurosxy.cliente.model;

import lombok.Data;
import org.bson.types.ObjectId;
import segurosxy.modelos.patrones.UbigeoContext;
import segurosxy.seguro.Seguro;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {

    private String id;
    private UbigeoContext ubigeoCasa;
    private UbigeoContext ubigeoTrabajo;
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

    public UbigeoContext getUbigeoCasa() {
        return ubigeoCasa;
    }

    public void setUbigeoCasa(UbigeoContext ubigeoCasa) {
        this.ubigeoCasa = ubigeoCasa;
    }

    public UbigeoContext getUbigeoTrabajo() {
        return ubigeoTrabajo;
    }

    public void setUbigeoTrabajo(UbigeoContext ubigeoTrabajo) {
        this.ubigeoTrabajo = ubigeoTrabajo;
    }

    public void printUbigeos(){
        System.out.println("[Ubigeo] Casa: "+ ubigeoCasa.getDepartamento() +", "+ ubigeoCasa.getProvincia() +", "+ ubigeoCasa.getDistrito());
        System.out.println("[Ubigeo] Trabajo: "+ ubigeoTrabajo.getDepartamento() +", "+ ubigeoTrabajo.getProvincia() +", "+ ubigeoTrabajo.getDistrito());
    }


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
