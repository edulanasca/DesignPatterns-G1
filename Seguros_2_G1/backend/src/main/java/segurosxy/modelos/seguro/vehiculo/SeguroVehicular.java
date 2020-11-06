package segurosxy.modelos.seguro.vehiculo;


import segurosxy.modelos.Vehiculo;
import segurosxy.modelos.seguro.Seguro;

public abstract class SeguroVehicular extends Seguro {

    private Vehiculo vehiculo;

    public SeguroVehicular(String marca, String modelo) {
        super();
        this.vehiculo = new Vehiculo(marca, modelo);
    }

    public SeguroVehicular(Vehiculo vehiculo) {
        super();
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public abstract String detalleSeguro();
    public abstract void calcularRiesgo();

//    @Override
//    public void cacularRiesgo()   {
//
//        if (this.vehiculo.getMarca().equals("Toyota") && this.vehiculo.getModelo().equals("Yaris")) {
//            this.nivelRiesgo = "ALTO";
//        }
//        else {
//            this.nivelRiesgo = "BAJO";
//        }
//    }
//
//    @Override
//    public String getDetalleSeguro()    {
//
//        return "Seg. Vehicular Numero: " + this.numero + " con riesgo: " + this.nivelRiesgo;
//    }
}
