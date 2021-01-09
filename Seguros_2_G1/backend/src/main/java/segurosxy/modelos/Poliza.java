package segurosxy.modelos;

import lombok.AllArgsConstructor;
import segurosxy.modelos.interfaces.IPoliza;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Poliza implements IPoliza {

    private Integer numero;
    private String nombresAsegurado;
    private String nombresTomador;
    private List<String> nombresBeneficiarios;
    private Double sumaAsegurada;

    public Poliza() {
    }

    public Poliza(Integer numero) {
        this.numero = numero;
    }

    public Poliza(Integer numero, String nombresAsegurado, String nombresTomador)   {

        this.numero = numero;
        this.nombresAsegurado = nombresAsegurado;
        this.nombresTomador = nombresTomador;
        this.nombresBeneficiarios = new ArrayList<>();
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombresAsegurado() {
        return nombresAsegurado;
    }

    public void setNombresAsegurado(String nombresAsegurado) {
        this.nombresAsegurado = nombresAsegurado;
    }

    public String getNombresTomador() {
        return nombresTomador;
    }

    public void setNombresTomador(String nombresTomador) {
        this.nombresTomador = nombresTomador;
    }

    public Double getSumaAsegurada() {
        return sumaAsegurada;
    }

    public void setSumaAsegurada(Double sumaAsegurada) {
        this.sumaAsegurada = sumaAsegurada;
    }

    public String armarSalidaTexto()    {

        return "Imprimiendo Poliza Formato Estandar\n" +
            "-----------------------------------\n" +
            "Poliza numero: [" + this.numero + "]\n" +
            "Nombres Asegurado: [" + this.nombresAsegurado + "]\n" +
            "Nombres Tomador: [" + this.nombresTomador + "]\n" +
            "-----------------------------------\n";

    }

    @Override
    public String detallePoliza() {
        return "Poliza Base";
    }
}
