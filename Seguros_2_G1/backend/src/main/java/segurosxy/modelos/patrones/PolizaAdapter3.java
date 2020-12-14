package segurosxy.modelos.patrones;

import segurosxy.modelos.Poliza;
import segurosxy.modelos.interfaces.IPoliza;

public class PolizaAdapter3 implements IImprimible {


    private Poliza poliza;

    public PolizaAdapter3(Poliza poliza)  {
        this.poliza = poliza;
    }

    public String aJSON() {
        StringBuffer json = new StringBuffer();
        json.append("{\n");
        json.append("'titulo' : 'Formato JSON',\n");
        json.append("'numero' : ").append(poliza.getNumero()).append(",\n");
        json.append("'nombreAsegurado' : '").append(poliza.getNombresAsegurado()).append(",\n");
        json.append(poliza.getNombresTomador()).append(",\n");
        json.append("}");
        return json.toString();
    }

    @Override
    public String armarSalidaTexto() {
        return aJSON();
    }
}
