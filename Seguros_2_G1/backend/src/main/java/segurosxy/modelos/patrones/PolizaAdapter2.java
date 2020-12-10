package segurosxy.modelos.patrones;

import segurosxy.modelos.Poliza;

public class PolizaAdapter2 extends Poliza implements IImprimible {

    public PolizaAdapter2(Integer numero, String nombresAsegurado, String nombresTomador) {
        super(numero, nombresAsegurado, nombresTomador);
    }

    public String aXML() {
        
        StringBuffer xml = new StringBuffer();
        xml.append("<impresion>");
        xml.append("<title>Formato XML</title>");
        xml.append("<poliza>");
        xml.append("<numero>" + getNumero() + "</numero>");
        xml.append("<nombresAsegurado>" + getNombresAsegurado() + "</nombresAsegurado>");
        xml.append("<nombresTomador>" + getNombresTomador() + "</nombresTomador>");
        xml.append("</poliza>");
        xml.append("</impresion>");

        return xml.toString();
    }

    @Override
    public String armarSalidaTexto()    {

        return aXML();
    }
}