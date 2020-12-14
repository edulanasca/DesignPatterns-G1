package segurosxy.modelos.patrones;

import java.util.HashMap;

public class PaisFactory {

    private HashMap<String, PaisFlyweight> paises = new HashMap<>();
    private static PaisFactory paisFactory = null;

    public static synchronized PaisFactory getInstance()  {

        if (paisFactory== null)  {

            paisFactory = new PaisFactory();
        }
        return paisFactory;
    }

    private  PaisFactory(){
        //se inicializa la coneccion a la base de datos si es que hay :''''v
    }

    public PaisFlyweight getPais(String codPais){
        PaisFlyweight flyweight = null;

        if (paises.get(codPais)==null)   {
            //se saca de la base de datos el nombre del pais
            String nombrePais = "peru";//sacado de la db
            String codMarc = "51";//sacado de la db
            flyweight = new PaisFlyweight(codPais,nombrePais,codMarc);
            paises.put( codPais, flyweight);
            System.out.println("[PaisFactory] Creando y recuperando los datos de PaisFlyweight");
        }
        else{
            flyweight = (PaisFlyweight) paises.get(codPais);
        }
        return flyweight;

    };



}
