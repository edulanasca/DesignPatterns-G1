package segurosxy.modelos.patrones.beneficiarios;

public class Ejecutivo extends Beneficiario{
    public Ejecutivo(String nombre) {
        super(nombre);
    }

    @Override
    public void darDeAlta() {
        System.out.println("[Beneficiario Ejecutivo] dando de ALTA a "+ nombre);
    }

    @Override
    public void darDeBaja() {
        System.out.println("[Beneficiario Ejecutivo] dando de BAJA a "+nombre);
    }

    @Override
    public void suspension() {
        System.out.println("[Beneficiario Ejecutivo] suspendiendo a "+nombre);
    }
}
