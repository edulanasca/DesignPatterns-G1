package segurosxy.modelos.seguro;

import segurosxy.modelos.interfaces.ICertificado;
import segurosxy.modelos.interfaces.IPoliza;

import java.util.Random;

public abstract class Seguro {

    protected Integer numero;
    protected ICertificado certificado;
    protected IPoliza poliza;
    protected String nivelRiesgo = "NINGUNO";

    public Seguro() {
        this.numero = new Random().nextInt();
    }

    public ICertificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    public IPoliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNivelRiesgo()  {
        return this.nivelRiesgo;
    }

    public abstract String detalleSeguro();

    public abstract void calcularRiesgo();
}
