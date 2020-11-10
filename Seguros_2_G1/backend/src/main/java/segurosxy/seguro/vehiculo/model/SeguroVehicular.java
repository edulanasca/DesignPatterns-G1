package segurosxy.seguro.vehiculo.model;


import segurosxy.modelos.Vehiculo;
import segurosxy.seguro.Seguro;

public abstract class SeguroVehicular extends Seguro {

    protected Vehiculo vehiculo;

    public SeguroVehicular() {
    }

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

    public static SeguroVehicular getSeguroVehicular(String tipo) {
        switch (tipo.toLowerCase()) {
            case "choque":
                return new SeguroChoque();
            case "robo":
                return new SeguroRobo();
            case "soat":
                return new SeguroSOAT();
            default:
                return new SeguroTodoRiesgo();
        }
    }

    public abstract String detalleSeguro();
    public abstract void calcularRiesgo();

}
