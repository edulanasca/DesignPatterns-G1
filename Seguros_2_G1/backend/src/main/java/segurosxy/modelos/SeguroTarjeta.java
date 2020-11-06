package segurosxy.modelos;

public class SeguroTarjeta extends Seguro {

    private Tarjeta tarjeta;

    public SeguroTarjeta(String bancoTarjeta)    {

        super();
        this.tarjeta = new Tarjeta(bancoTarjeta);
    }

    public SeguroTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public void cacularRiesgo()   {

        if (this.tarjeta.getBancoTarjeta().equals("AZTECA")) {
            this.nivelRiesgo = "ALTO";
        }
        else {
            this.nivelRiesgo = "BAJO";
        }
    }

    @Override
    public String getDetalleSeguro() {

        return "Seg. Tarjeta Numero: " + this.numero + " con riesgo: " + this.nivelRiesgo;
    }
}
