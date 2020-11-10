package segurosxy.modelos;

import segurosxy.modelos.interfaces.ICertificado;

import java.util.Random;

public class Certificado implements ICertificado {
    private Integer numero;

    public Certificado() {
        this.numero = new Random().nextInt() & Integer.MAX_VALUE;
    }

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
