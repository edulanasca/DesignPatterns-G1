package segurosxy.modelos;

import java.util.Random;

public class SeguroVehicular extends Seguro {

    private Vehiculo vehiculo;

    public SeguroVehicular(String marca, String modelo)    {

        super();
        this.vehiculo = new Vehiculo(marca, modelo);
    }

    public SeguroVehicular(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public void cacularRiesgo()   {

        if (this.vehiculo.getMarca().equals("Toyota") && this.vehiculo.getModelo().equals("Yaris")) {
            this.nivelRiesgo = "ALTO";
        }
        else {
            this.nivelRiesgo = "BAJO";
        }
    }

    @Override
    public String getDetalleSeguro()    {

        return "Seg. Vehicular Numero: " + this.numero + " con riesgo: " + this.nivelRiesgo;
    }
}
