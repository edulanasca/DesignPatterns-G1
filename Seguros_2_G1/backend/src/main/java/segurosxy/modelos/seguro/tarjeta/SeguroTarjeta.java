package segurosxy.modelos.seguro.tarjeta;

import segurosxy.modelos.Tarjeta;
import segurosxy.modelos.seguro.Seguro;

public class SeguroTarjeta extends Seguro {

    private Tarjeta tarjeta;

    public SeguroTarjeta(String bancoTarjeta)    {

        super();
        this.tarjeta = new Tarjeta(bancoTarjeta);
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public void calcularRiesgo()   {

        if (this.tarjeta.getBancoTarjeta().equals("AZTECA")) {
            this.nivelRiesgo = "ALTO";
        }
        else {
            this.nivelRiesgo = "BAJO";
        }
    }

    @Override
    public String detalleSeguro() {

        return "Seg. Tarjeta Numero: " + this.numero + " con riesgo: " + this.nivelRiesgo;
    }
}
