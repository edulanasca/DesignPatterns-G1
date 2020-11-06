package segurosxy.modelos.seguro;

import segurosxy.modelos.interfaces.ICertificado;

public class Certificado implements ICertificado {
    private Integer numero;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String detalleCertificado() {
        return "Certificado Base";
    }
}
