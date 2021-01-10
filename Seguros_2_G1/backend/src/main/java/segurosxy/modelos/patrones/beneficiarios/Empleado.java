package segurosxy.modelos.patrones.beneficiarios;

public class Empleado extends Beneficiario {
    public Empleado(String nombre) {
        super(nombre);
    }

    @Override
    public void darDeAlta() {
        System.out.println("[Beneficiario Empleado] dando de ALTA a "+ nombre);
    }

    @Override
    public void darDeBaja() {
        System.out.println("[Beneficiario Empleado] dando de BAJA a "+nombre);
    }

    @Override
    public void suspension() {
        System.out.println("[Beneficiario Empleado] suspendiendo a "+nombre);
    }
}
