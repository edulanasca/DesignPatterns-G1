package segurosxy.seguro.tarjeta;

import segurosxy.modelos.Tarjeta;
import segurosxy.modelos.interfaces.INivelRiesgo;
import segurosxy.seguro.Seguro;

public class SeguroTarjeta extends Seguro implements INivelRiesgo {

    private Tarjeta tarjeta;

    public SeguroTarjeta() { }

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

        return "Seg. Tarjeta Numero: " + this.tarjeta.getBancoTarjeta() + " con riesgo: " + this.nivelRiesgo;
    }
}
