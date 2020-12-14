package segurosxy.modelos.patrones;

import segurosxy.modelos.Poliza;

public class PolizaAdapter implements IImprimible {
    
    private Poliza poliza;

    public PolizaAdapter(Poliza poliza)  {
        this.poliza = poliza;
    }

    public String aXML() {
        
        StringBuffer xml = new StringBuffer();
        xml.append("<impresion>");
        xml.append("<title>Formato XML</title>");
        xml.append("<poliza>");
        xml.append("<numero>" + this.poliza.getNumero() + "</numero>");
        xml.append("<nombresAsegurado>" + this.poliza.getNombresAsegurado() + "</nombresAsegurado>");
        xml.append("<nombresTomador>" + this.poliza.getNombresTomador() + "</nombresTomador>");
        xml.append("</poliza>");
        xml.append("</impresion>");

        return xml.toString();
    }

    @Override
    public String armarSalidaTexto()    {

        return aXML();
    }



}